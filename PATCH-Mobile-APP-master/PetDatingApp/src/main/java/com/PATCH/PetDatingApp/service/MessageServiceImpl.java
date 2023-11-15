package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.Message;
import com.PATCH.PetDatingApp.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public Message sendMessage(Message message) {
        // Set the timestamp for the msid
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        String msid = "MSID-" + timestamp;
        message.setMsid(msid);

        // Set the date created
        message.setDateCreated(new Date());

        // Set the status based on the success of saving the message
        Message savedMessage = messageRepository.save(message);
        if (savedMessage != null) {
            savedMessage.setStatus("delivered");
        } else {
            savedMessage.setStatus("failed");
        }

        return savedMessage;
    }

    @Override
    public List<Message> getMessagesByPid(String pid) {
        return messageRepository.findByPid1OrPid2(pid, pid);
    }
    @Override
    public List<Message> getMessagesByPetId(String pid1, String pid2) {
        return messageRepository.findByPid1OrPid2(pid1, pid2);
    }
@Override
public boolean deleteMessageByMsid(String msid) {
    messageRepository.deleteByMsid(msid);
    return true;
}

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
    @Override
    public List<Message> getMessagesByPid1(String pid1) {
        return messageRepository.findByPid1(pid1);
    }

    @Override
    public List<Message> getMessagesByPid2(String pid2) {
        return messageRepository.findByPid2(pid2);
    }

    @Override
    public Message updateMessageStatus(String msid, String status) {
        Optional<Message> optionalMessage = messageRepository.findById(msid);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            message.setStatus(status);
            messageRepository.save(message);
            return message;
        } else {
            throw new IllegalArgumentException("Message not found with MSID: " + msid);
        }
    }
    @Override
    public Optional<Message> getMessageByMsid(String msid) {
        Optional<Message> optionalMessage = messageRepository.findByMsid(msid);
        if (optionalMessage.isPresent()) {
            return messageRepository.findByMsid(msid);
        } else {
            throw new IllegalArgumentException("Message not found with MSID: " + msid);
        }
    }
    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
    @Override
    public List<Message> getMessageHistoryByPids(String pid1, String pid2) {
        // Query the database for messages where pid1 and pid2 match either pid1 or pid2 in the message
        List<Message> messageHistory = messageRepository.findMessageHistoryByPids(pid1, pid2);
        return messageHistory;
    }

    }

