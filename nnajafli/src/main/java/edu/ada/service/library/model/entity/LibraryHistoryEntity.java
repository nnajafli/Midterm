package edu.ada.service.library.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LibraryHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int studentId;

    private int bookId;

    private String dateTaken;
    private String dateDrop;

    public LibraryHistoryEntity(int id, int studentId, int bookId, String dateTaken, String dateDrop) {
        this.id = id;
        this.studentId = studentId;
        this.bookId = bookId;
        this.dateTaken = dateTaken;
        this.dateDrop = dateDrop;
    }

    public LibraryHistoryEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getDateDrop() {
        return dateDrop;
    }

    public void setDateDrop(String dateDrop) {
        this.dateDrop = dateDrop;
    }
}
