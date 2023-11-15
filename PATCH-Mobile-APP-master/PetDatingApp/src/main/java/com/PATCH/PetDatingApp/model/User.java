package com.PATCH.PetDatingApp.model;

import com.PATCH.PetDatingApp.repository.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.PATCH.PetDatingApp.model.MarkedForum;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank
    private String uid;

    @NotBlank
    private String name;


    @NotBlank
    @Size(max = 100)
    @Email
    @Column(nullable = false,unique = true)
    private String email;

    @NotBlank
    private String password;

    @CreatedDate
    @Field("dateCreated")
    private Date dateCreated;

    @LastModifiedDate
    @Field("lastModified")
    private Date lastModified;
    private String resetToken;
    @Transient
    private String jwtToken;
    private byte[] profileImage;
    private String profileImageUrl;

    private List<MarkedForum> likedForums;
    private List<MarkedForum> savedForums;
    List<MarkedForum> markedForums;



    public User() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        this.uid = "UID-" + timestamp;  // Use timestamp for UID
//        this.likedForums = new ArrayList<>();
//        this.savedForums = new ArrayList<>();
    }

    public User(String name, String email, String password) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        this.id = id;
        this.uid = "UID-" + timestamp;  // Use timestamp for UID
        this.name = name;
        this.email = email;
        this.password = hashPassword(password);
        this.dateCreated = new Date();
//        this.likedForums = new ArrayList<>();
//        this.savedForums = new ArrayList<>();
    }
    private static String hashPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    // Getters and setters...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        if (!uid.startsWith("UID-")) {
            throw new IllegalArgumentException("UID must start with UID-");
        }
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("Raw password before trimming: " + password);
        this.password = password.trim();
        System.out.println("Trimmed password: " + this.password);
    }

     public Date getDateCreated() {
          return dateCreated;
       }

      public void setDateCreated(Date dateCreated) {
      this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
/*

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public boolean isResetTokenValid() {
        return resetToken != null && !resetToken.isEmpty();
    }
*/

   public List<MarkedForum> getLikedForums() {
        return likedForums;
    }

    public void setLikedForums(List<MarkedForum> likedForums) {
        this.likedForums = likedForums;
    }

    public List<MarkedForum> getSavedForums() {
        return savedForums;
    }

    public void setSavedForums(List<MarkedForum> savedForums) {
        this.savedForums = savedForums;
    }

    public void insert(UserRepository userRepository) {
        userRepository.save(this);
    }

    public User orElse(Object o) {
    return null;}

    public void setPets(List<Pet> userPets) {
    }

    public List<Pet> getPets() {
       return null;
    }


    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    public String getJwtToken() {
        return jwtToken;
    }
    public byte[] getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(byte[] image) {
        this.profileImage = image;
    }

    public void setProfileImageUrl(String url) {
        this.profileImageUrl = url;
    }



    public String getProfileImageUrl() {
        return profileImageUrl;
    }


}
