package edu.ada.service.library.model.service;

import edu.ada.service.library.model.dto.BookMetaDATA;
import edu.ada.service.library.model.dto.LibraryModel;
import edu.ada.service.library.model.entity.Books;

import java.util.List;

public interface BooksService {


    Books searchByName(String name);

    List<Books> searchByCategory(int categoryId);

    List<Books> books();

    List<LibraryModel> getList();


}
