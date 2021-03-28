package edu.ada.service.library.model.dto;

public class LibraryModel {
    private BookMetaDATA bookMetaDATA;

    private StudentDataModel studentDataModel;

    public LibraryModel(BookMetaDATA bookMetaDATA, StudentDataModel studentDataModel) {
        this.bookMetaDATA = bookMetaDATA;
        this.studentDataModel = studentDataModel;
    }

    public LibraryModel() {
    }

    public BookMetaDATA getBookMetaDATA() {
        return bookMetaDATA;
    }

    public void setBookMetaDATA(BookMetaDATA bookMetaDATA) {
        this.bookMetaDATA = bookMetaDATA;
    }

    public StudentDataModel getStudentDataModel() {
        return studentDataModel;
    }

    public void setStudentDataModel(StudentDataModel studentDataModel) {
        this.studentDataModel = studentDataModel;
    }
}
