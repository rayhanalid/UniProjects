package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.Message;
import com.PATCH.PetDatingApp.repository.MessageRepository;
import java.util.List;
import java.util.Optional;

public interface MessageService {
    Message sendMessage(Message message);
    List<Message> getMessagesByPid1(String pid1);
    List<Message> getMessagesByPid2(String pid2);
    Message updateMessageStatus(String msid, String status);
//    void updateMessageStatus(String msid, String status);
    Message createMessage(Message message);
    Optional<Message> getMessageByMsid(String msid);
      List<Message> getMessagesByPid(String pid);

    boolean deleteMessageByMsid(String msid);
    List<Message> getMessagesByPetId(String pid1, String pid2);
//    Message saveMessage(Message message);

    public Message saveMessage(Message msg);
    List<Message> getMessageHistoryByPids(String pid1, String pid2);
}
