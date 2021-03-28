package edu.ada.service.library.controller;

import org.springframework.http.ResponseEntity;

public interface LibraryWS {

    ResponseEntity books();

    ResponseEntity pickUp(int bookId, int studentId);

    ResponseEntity dropOff(int bookId, int studentId);


    ResponseEntity currentlyPickUp(int studentId);

    ResponseEntity wholePickUp(int studentId);

}
