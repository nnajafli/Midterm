package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.LibraryWS;
import org.springframework.http.ResponseEntity;

public class LibraryWSLDAImpl implements LibraryWS {
    @Override
    public ResponseEntity books() {
        return null;
    }

    @Override
    public ResponseEntity pickUp(int bookId, int studentId) {
        return null;
    }

    @Override
    public ResponseEntity dropOff(int bookId, int studentId) {
        return null;
    }

    @Override
    public ResponseEntity currentlyPickUp(int studentId) {
        return null;
    }

    @Override
    public ResponseEntity wholePickUp(int studentId) {
        return null;
    }

}
