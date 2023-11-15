package com.PATCH.PetDatingApp.repository;

import com.PATCH.PetDatingApp.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PetRepository extends MongoRepository<Pet, String> {
    List<Pet> findByUid(String uid);
    Pet findByPid(String pid);

    Pet findByUidAndPid(String uid, String pid);


}
