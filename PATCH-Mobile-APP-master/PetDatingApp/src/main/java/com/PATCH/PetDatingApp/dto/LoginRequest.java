package com.PATCH.PetDatingApp.dto;

public class LoginRequest extends UserRequest {

    private String email;
    private String password;
    private String idToken;

//    public String getUsernameOrEmail() {
//        return usernameOrEmail;
//    }

//    public void setUsernameOrEmail(String usernameOrEmail) {
//        this.usernameOrEmail = usernameOrEmail;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
