package com.PATCH.PetDatingApp.repository;

import com.PATCH.PetDatingApp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByEmail(String email);
    User findByUid(String uid);

/*
    User findByResetToken(String resetToken);
    User updateResetToken(String email, String token);
*/

    void deleteAllById(Iterable<? extends String> ids);

    void deleteById(Iterable<? extends String> ids);
    boolean existsByEmail(String email);

//    boolean existsByUsername(String username);

//   User findByUsername(String username);
//    User findByUsernameOrEmail(String username, String email);

//    User findOneByUsername(String username);
}
