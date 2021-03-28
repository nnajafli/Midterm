package edu.ada.service.library.model.dto;



import java.io.Serializable;


public class BookMetaDATA implements Serializable {
    private String name;
    private int userId;
    private String available;
    private String categoryName;

    public BookMetaDATA(String name, int userId, String available, String categoryName) {
        this.name = name;
        this.userId = userId;
        this.available = available;
        this.categoryName = categoryName;
    }

    public BookMetaDATA() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
