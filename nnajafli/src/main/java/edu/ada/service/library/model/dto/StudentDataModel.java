package edu.ada.service.library.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class StudentDataModel implements Serializable {
    private int id;
    private String firstname;
    private String lastname;

    public StudentDataModel(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public StudentDataModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
