package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.BookLibraryWS;
import edu.ada.service.library.model.dto.BookMetaDATA;
import edu.ada.service.library.model.entity.Books;
import edu.ada.service.library.model.entity.CategoryEntity;
import edu.ada.service.library.model.service.AuthenticationService;
import edu.ada.service.library.model.service.BooksService;
import edu.ada.service.library.model.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")

public class BookLibraryWSImpl implements BookLibraryWS {

    protected static Logger logger = LoggerFactory.getLogger(AuthenticationWSImpl.class);


    @Autowired
    private BooksService booksService;

    @Autowired
    private CategoryService categoryService;


    @Override
    @RequestMapping(value = "/searchName", method = RequestMethod.GET)
    public ResponseEntity searchByName(@RequestParam(name = "bookName", required = true) String bookName) {
        Books books = booksService.searchByName(bookName);
        if (books != null && books.getId() > 0) {
            logger.info("Search Book Name: " + bookName);
            return new ResponseEntity(booksService.searchByName(bookName), HttpStatus.OK);
        } else {
            logger.info("Book Name is not in our db: " + bookName);
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @Override
    @RequestMapping(value = "/searchCategory", method = RequestMethod.GET)
    public ResponseEntity searchByCategory(@RequestParam(name = "categoryName", required = true) String categoryName) {
        if (categoryService.checkCategory(categoryName)) {
            CategoryEntity categoryEntity = categoryService.findByName(categoryName);
            logger.info("Search Book Category NAmme: " + categoryName);
            return ResponseEntity.ok(booksService.searchByCategory(categoryEntity.getId()));
        } else {
            logger.info("Category is not in our db: " + categoryName);
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
