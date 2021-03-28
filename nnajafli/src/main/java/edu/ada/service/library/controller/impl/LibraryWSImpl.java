package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.LibraryWS;
import edu.ada.service.library.model.service.BooksService;
import edu.ada.service.library.model.service.LibraryHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")

public class LibraryWSImpl implements LibraryWS {
    protected static Logger logger = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    @Autowired
    private BooksService booksService;

    @Autowired
    private LibraryHistoryService libraryHistoryService;

    @Override
    @RequestMapping(value = "/listOfBook", method = RequestMethod.GET)
    public ResponseEntity books() {
        return ResponseEntity.ok(booksService.getList());
    }

    @Override
    @RequestMapping(value = "/pickup", method = RequestMethod.GET)

    public ResponseEntity pickUp(@RequestHeader("bookId") int bookId, @RequestHeader("studentId") int studentId) {
        libraryHistoryService.pickup(bookId, studentId);
        logger.info("Book Taken BookID: " + bookId);

        return new ResponseEntity("Taken by: " + studentId, HttpStatus.OK);


    }

    @Override
    @RequestMapping(value = "/dropoff", method = RequestMethod.GET)
    public ResponseEntity dropOff(@RequestHeader("bookId") int bookId, @RequestHeader("studentId") int studentId) {
        libraryHistoryService.dropoff(bookId, studentId);
        logger.info("Book Drop Off BookID: " + bookId);

        return new ResponseEntity("Dropped by: " + studentId, HttpStatus.OK);

    }

    @Override
    @RequestMapping(value = "/currentlyHistory", method = RequestMethod.GET)

    public ResponseEntity currentlyPickUp(@RequestHeader("studentId") int studentId) {
        return new ResponseEntity(libraryHistoryService.currentlyPickUp(studentId), HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ResponseEntity wholePickUp(@RequestHeader("studentId") int studentId) {
        return new ResponseEntity(libraryHistoryService.wholePickUp(studentId), HttpStatus.OK);

    }

}
