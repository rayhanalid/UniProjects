package com.PATCH.PetDatingApp.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Lob;
import java.text.SimpleDateFormat;
import java.util.*;

@Document(collection = "pets")
public class Pet {
    @Id
    private String id;
    @NotBlank
    private String pid;
    private String uid;
    private String name;
    private String type;
    private String breed;
    private String colors;
    private String gender;
    private double weight;
    private int age;
    private String vaccineStatus;
    private String character1;
    private String character2;
    private String character3;
    private String like;
    private String dislike;
    private String bio; // Added the bio field
    private double longitude;
    private double latitude;
    private Date dateCreated;
    private Date lastModified;
    private String imageUrl;
    @Lob
    private List<byte[]> imageDataList = new ArrayList<>();
    private List<String> imageUrls = new ArrayList<>();
    public Pet() {
        // Generate PID with timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        this.pid = "PID-" + timestamp;
        this.dateCreated = new Date();
        this.lastModified = new Date();
        this.imageUrls = new ArrayList<>();
    }

    // Getters and setters for all fields

    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    // ... getters and setters for other fields

    public Date getdateCreated() {
        return dateCreated;
    }
    public void setdateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getlastModified() {
        return lastModified;
    }
    public void setlastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    public String getCharacter1() {
        return character1;
    }

    public void setCharacter1(String character1) {
        if (this.type.equals("Cat")) {
            String[] catTraits = {"insecure", "fearful", "scared of people", "suspicious", "shy",
                    "active", "alert", "curious", "inquisitive", "inventive", "smart",
                    "tyranny", "bullying", "aggressiveness", "volatility",
                    "unpredictability", "ruthlessness", "reflects affection",
                    "gentleness", "friendliness towards people"};
            if (Arrays.asList(catTraits).contains(character1)) {
                this.character1 = character1;
            } else {
                throw new IllegalArgumentException("Invalid cat trait for character1");
            }
        } else if (this.type.equals("Dog")) {
            String[] dogTraits = {"sociable", "outgoing", "trustworthy", "straightforward",
                    "anxious", "irritable", "shy", "curious", "imaginative",
                    "excitable", "efficient", "thorough", "not lazy"};
            if (Arrays.asList(dogTraits).contains(character1)) {
                this.character1 = character1;
            } else {
                throw new IllegalArgumentException("Invalid dog trait for character1");
            }
        }
    }

    public String getCharacter2() {
        return character2;
    }
    public void setCharacter2(String character2) {
        if (this.character1.equals(character2)) {
            throw new IllegalArgumentException("Character 2 cannot be the same as Character 1");
        }

        if (this.type.equals("Cat")) {
            String[] catTraits = {"insecure", "fearful", "scared of people", "suspicious", "shy",
                    "active", "alert", "curious", "inquisitive", "inventive", "smart",
                    "tyranny", "bullying", "aggressiveness", "volatility",
                    "unpredictability", "ruthlessness", "reflects affection",
                    "gentleness", "friendliness towards people"};
            if (!Arrays.asList(catTraits).contains(character2)) {
                throw new IllegalArgumentException("Invalid cat trait for character2");
            }
        } else if (this.type.equals("Dog")) {
            String[] dogTraits = {"sociable", "outgoing", "trustworthy", "straightforward",
                    "anxious", "irritable", "shy", "curious", "imaginative",
                    "excitable", "efficient", "thorough", "not lazy"};
            if (!Arrays.asList(dogTraits).contains(character2)) {
                throw new IllegalArgumentException("Invalid dog trait for character2");
            }
        }

        this.character2 = character2;
    }

    public void setCharacter3(String character3) {
        if (this.character1.equals(character3) || this.character2.equals(character3)) {
            throw new IllegalArgumentException("Character 3 cannot be the same as Character 1 or Character 2");
        }

        if (this.type.equals("Cat")) {
            String[] catTraits = {"insecure", "fearful", "scared of people", "suspicious", "shy",
                    "active", "alert", "curious", "inquisitive", "inventive", "smart",
                    "tyranny", "bullying", "aggressiveness", "volatility",
                    "unpredictability", "ruthlessness", "reflects affection",
                    "gentleness", "friendliness towards people"};
            if (!Arrays.asList(catTraits).contains(character3)) {
                throw new IllegalArgumentException("Invalid cat trait for character3");
            }
        } else if (this.type.equals("Dog")) {
            String[] dogTraits = {"sociable", "outgoing", "trustworthy", "straightforward",
                    "anxious", "irritable", "shy", "curious", "imaginative",
                    "excitable", "efficient", "thorough", "not lazy"};
            if (!Arrays.asList(dogTraits).contains(character3)) {
                throw new IllegalArgumentException("Invalid dog trait for character3");
            }
        }

        this.character3 = character3;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColors() {
        return colors;
    }
    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getVaccineStatus() {
        return vaccineStatus;
    }
    public void setVaccineStatus(String vaccineStatus) {
        this.vaccineStatus = vaccineStatus;
    }

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLike() {
        return like;
    }
    public void setLike(String like) {
        this.like = like;
    }

    public String getDislike() {
        return dislike;
    }
    public void setDislike(String dislike) {
        this.dislike = dislike;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public Pet orElse(Object o) {
        return null;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<byte[]> getImageDataList() {
        return imageDataList;
    }

    public void setImageDataList(List<byte[]> imageDataList) {
        this.imageDataList = imageDataList;
    }

    public void addImageData(byte[] imageData) {
        if (this.imageDataList == null) {
            this.imageDataList = new ArrayList<>();
        }
        this.imageDataList.add(imageData);
    }

    public void addImageUrl(String imageUrl) {
        if (this.imageUrls == null) {
            this.imageUrls = new ArrayList<>();
        }
        this.imageUrls.add(imageUrl);
    }

    // Optional method to get the decoded byte array from Base64-encoded image data
//    public byte[] getDecodedImageData() {
//        return Base64.getDecoder().decode(imageDataList);
//    }
    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
    @Override
    public String toString() {
        return "Pet{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", colors='" + colors + '\'' +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", vaccineStatus='" + vaccineStatus + '\'' +
                ", character1='" + character1 + '\'' +
                ", character2='" + character2 + '\'' +
                ", character3='" + character3 + '\'' +
                ", bio='" + bio + '\'' +
                ", like='" + like + '\'' +
                ", dislike='" + dislike + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", imageData='" + imageDataList + '\'' +
                ", imageUrl='" + imageUrl + '\'' +


                '}';
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getCharacter3() {
        return character3;
    }
}
