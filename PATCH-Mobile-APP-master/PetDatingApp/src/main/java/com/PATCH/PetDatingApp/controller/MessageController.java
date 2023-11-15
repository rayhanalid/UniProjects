package com.PATCH.PetDatingApp.controller;

import com.PATCH.PetDatingApp.dto.MessageStatusDto;
import com.PATCH.PetDatingApp.model.MatchHistory;
import com.PATCH.PetDatingApp.model.Message;
import com.PATCH.PetDatingApp.repository.MatchHistoryRepository;
import com.PATCH.PetDatingApp.repository.MessageRepository;
import com.PATCH.PetDatingApp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.*;

//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private final MessageService messageService;
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MatchHistoryRepository matchHistoryRepository;


    public MessageController(MessageService messageService, SimpMessagingTemplate template, MessageRepository messageRepository){
        this.messageService = messageService;
        this.template = template;
        this.messageRepository= messageRepository;
    }

//    @PostMapping("/create")
//    public ResponseEntity<Message> createMessage(@RequestBody String pid1,String pid2 ,Message message) {
//
//
//        // Generate MSID
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String timestamp = sdf.format(new Date());
//        String msid = "MSID-" + timestamp;
//        message.setMsid(msid);
//
//        // Set default status
//        message.setStatus("delivered"); // Assuming the default status is "delivered"
//
//        // Set dateCreated
//        message.setDateCreated(new Date());
//        template.convertAndSend("/topic/messages", message);
//
//        Message createdMessage = messageService.createMessage(message);
//
//
//        Optional<MatchHistory> optionalMatch = matchHistoryRepository.findByPid1AndPid2(pid1, pid2);
//        if(optionalMatch.isPresent()) {
//            MatchHistory match = optionalMatch.get();
//
//            match.setHasInteracted(true);
//
//            matchHistoryRepository.save(match);
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
//    }

    @PostMapping("/create")
    public ResponseEntity<Message> createMessage(@RequestBody Map<String, String> request) {
        String pid1 = request.get("pid1");
        String pid2 = request.get("pid2");
        String body = request.get("body");
        Message message = new Message();
        message.setPid1(pid1);
        message.setPid2(pid2);
        message.setBody(body);

//         Generate MSID
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        String msid = "MSID-" + timestamp;
        message.setMsid(msid);

        // Set default status
        message.setStatus("delivered"); // Assuming the default status is "delivered"

        // Set dateCreated
        message.setDateCreated(new Date());
        template.convertAndSend("/topic/messages", message);

        Message createdMessage = messageService.createMessage(message);


        Optional<MatchHistory> optionalMatch = matchHistoryRepository.findByPid1AndPid2(pid1, pid2);
        if(optionalMatch.isPresent()) {
            MatchHistory match = optionalMatch.get();

            match.setHasInteracted(true);

            matchHistoryRepository.save(match);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
    }






    @GetMapping("/{msid}")
    public ResponseEntity<Message> getMessageById(@PathVariable String msid) {
        Optional<Message> message = messageService.getMessageByMsid(msid);
        return message.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pet/{pid}")
    public ResponseEntity<List<Message>> getMessagesByPid(@PathVariable String pid) {
        List<Message> messages = messageService.getMessagesByPid(pid);
        return ResponseEntity.ok(messages);
    }

    @PutMapping("/{msid}")
    public ResponseEntity<Message> updateMessageStatus(@PathVariable String msid, @RequestBody MessageStatusDto statusDto) {
        Message updatedMessage = messageService.updateMessageStatus(msid, statusDto.getStatus());
        return ResponseEntity.ok(updatedMessage);

    }


    @PutMapping("/{id}")
    public void updateMessage(@PathVariable int id, @RequestBody Message message) {

        // update message

        template.convertAndSend("/topic/messages", message);

    }


    //    @DeleteMapping("/{msid}")
//    public ResponseEntity<Void> deleteMessage(@PathVariable String msid) {
//        boolean deleted = messageService.deleteMessageByMsid(msid);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//@DeleteMapping("/{msid}")
//public ResponseEntity<Void> deleteMessage(@PathVariable String msid) {
//    messageService.deleteMessageByMsid(msid);
//    return ResponseEntity.noContent().build();
//}
@DeleteMapping("/{msid}")
public ResponseEntity<String> deleteMessage(@PathVariable String msid) {
    messageService.deleteMessageByMsid(msid);
    return ResponseEntity.ok("Message Deleted Successfully!");
}

    @PostMapping("/broadcast")
    public void broadcastMessage(@RequestBody Message message) {

        template.convertAndSend("/topic/messages", message);

    }

//    @PostMapping("/send")
//    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String timestamp = sdf.format(new Date());
//        String msid = "MSID-" + timestamp;
//        message.setMsid(msid);
//        message.setStatus("delivered");
//        message.setDateCreated(new Date());
//        Message saved = messageRepository.save(message);
//
//        try {
//            template.convertAndSend("/topic/messages", message);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        return ResponseEntity.ok(saved);
//
//    }
@PostMapping("/send")
public ResponseEntity<String> sendMessage(@RequestBody Message message) {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String timestamp = sdf.format(new Date());
    String msid = "MSID-" + timestamp;
    message.setMsid(msid);
    message.setStatus("delivered");
    message.setDateCreated(new Date());
    Message saved = messageRepository.save(message);

    try {
        template.convertAndSend("/topic/messages", message);
    } catch (Exception e) {
        return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok("Message Send Successfully!");

}

    @PostMapping("")
    public ResponseEntity<Void> handleMessage(
            @RequestBody Message message,
            @RequestParam("senderPetId") String senderPetId,
            @RequestParam("receiverPetId") String receiverPetId
    ) {

        // Generate unique message ID
        String messageId = UUID.randomUUID().toString();

        // Add sender and receiver pet IDs to message
        message.setMsid(messageId);
        message.setPid1(senderPetId);
        message.setPid2(receiverPetId);

        // Save message to database
        messageRepository.save(message);

        // Publish message via WebSocket
        template.convertAndSend("/chat", message);

        return ResponseEntity.ok().build();

    }
    @GetMapping("/history")
    public ResponseEntity<List<Message>> getMessageHistoryByPids(
            @RequestParam("pid1") String pid1,
            @RequestParam("pid2") String pid2
    ) {
        List<Message> messageHistory = messageService.getMessageHistoryByPids(pid1, pid2);
        return ResponseEntity.ok(messageHistory);
    }
}

