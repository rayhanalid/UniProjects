package com.PATCH.PetDatingApp.repository;

import com.PATCH.PetDatingApp.model.MatchHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchHistoryRepository extends MongoRepository<MatchHistory, String> {
    List<MatchHistory> findByPid1(String pid1);
    List<MatchHistory> findByPid2(String pid2);
    Optional<MatchHistory> findByPid1AndPid2(String pid1, String pid2);

    ResponseEntity<MatchHistory> findByStatus(boolean status);

    void deleteByMid(String mid);

    List<MatchHistory> findAll();
    MatchHistory findByMid(String mid);

    void deleteById(String mid);
}
