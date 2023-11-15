/*
package com.PATCH.PetDatingApp.MdbSpringBootApplication;

import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.PATCH.PetDatingApp.repository")
public class MdbSpringBootApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String name = "testing";
        Optional<User> userOptional = userRepository.findByName(name);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println("User found: " + user.getUserId() + " - " + user.getEmail());
        } else {
            System.out.println("User not found");
        }
    }
}
*/
