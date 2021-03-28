package edu.ada.service.library.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class RegistrationModel implements Serializable {
    private String firstname;
    private String lastname;
    private String birthday;
    private String password;
    private String email;


    public RegistrationModel(String firstname, String lastname, String birthday, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.password = password;
        this.email = email;
    }

    public RegistrationModel() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

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
}
