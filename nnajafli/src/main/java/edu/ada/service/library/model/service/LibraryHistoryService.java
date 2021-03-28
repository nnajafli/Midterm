package edu.ada.service.library.model.service;

import edu.ada.service.library.model.dto.LibraryModel;
import edu.ada.service.library.model.entity.LibraryHistoryEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LibraryHistoryService {


    void pickup(int bookId, int studentId);

    void dropoff(int bookId, int studentId);

    boolean check(int bookId);

    List<LibraryModel> currentlyPickUp(int studentId);

    List<LibraryModel> wholePickUp(int studentId);

}
