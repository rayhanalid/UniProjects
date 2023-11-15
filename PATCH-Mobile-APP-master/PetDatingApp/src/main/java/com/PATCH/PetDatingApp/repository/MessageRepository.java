package com.PATCH.PetDatingApp.repository;

import com.PATCH.PetDatingApp.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    Optional<Message> findById(String msid);

    List<Message> findByPid1(String pid1);
    List<Message> findByPid2(String pid2);

    Optional<Message> findByMsid(String msid);
    Optional<Message> getMessageByMsid(String msid);
    List<Message>findByPid1OrPid2 (String pid);

    List<Message> findByPid1OrPid2(String pid1, String pid2);
     void deleteById(String msid);

    void delete(Message message);
    void deleteByMsid(String msid);
    @Query("{$or: [{pid1: ?0, pid2: ?1}, {pid1: ?1, pid2: ?0}]}")
    List<Message> findMessageHistoryByPids(String pid1, String pid2);
}
