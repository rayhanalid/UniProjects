package com.PATCH.PetDatingApp.dto;



public class RegistrationRequest {
    private String email;
    private String username;
    private String password;

    // Constructors, getters, and setters

    // Default constructor (you can also generate constructors using IDE)
    public RegistrationRequest() {}

    // Parameterized constructor
    public RegistrationRequest(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Getters and setters (you can also generate them using IDE)
    // ...
}

