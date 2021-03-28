package edu.ada.service.library.model.service.impl;

import edu.ada.service.library.model.dto.BookMetaDATA;
import edu.ada.service.library.model.dto.LibraryModel;
import edu.ada.service.library.model.dto.StudentDataModel;
import edu.ada.service.library.model.entity.Books;
import edu.ada.service.library.model.entity.CategoryEntity;
import edu.ada.service.library.model.entity.UserEntity;
import edu.ada.service.library.model.service.BooksService;
import edu.ada.service.library.repository.BooksRepository;
import edu.ada.service.library.repository.CategoryRepository;
import edu.ada.service.library.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {


    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Books searchByName(String name) {
        return booksRepository.findByName(name);
    }

    @Override
    public List<Books> searchByCategory(int categoryId) {
        return booksRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public List<Books> books() {

        List<Books> books = booksRepository.findAll();


        return booksRepository.findAll();
    }

    @Override
    public List<LibraryModel> getList() {

        List<Books> list = booksRepository.findAll();

        List<LibraryModel> list1 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            LibraryModel libraryModel = new LibraryModel();
            BookMetaDATA bookMetaDATA = new BookMetaDATA();
            bookMetaDATA.setName(list.get(i).getName());
            bookMetaDATA.setUserId(list.get(i).getUserID());
            bookMetaDATA.setCategoryName(categoryRepository.findById(list.get(i).getCategoryId()).get().getName());
            bookMetaDATA.setAvailable(list.get(i).getAvailable());
            StudentDataModel studentDataModel = new StudentDataModel();
            if (list.get(i).getUserID() > 0) {
                UserEntity userEntity = userRepository.findById(Long.parseLong(String.valueOf(list.get(i).getUserID()))).get();
                studentDataModel.setLastname(userEntity.getLastname());
                studentDataModel.setFirstname(userEntity.getFirstname());
                studentDataModel.setId(Integer.parseInt(String.valueOf(userEntity.getId())));
            }
            libraryModel.setBookMetaDATA(bookMetaDATA);

            libraryModel.setStudentDataModel(studentDataModel);

            list1.add(libraryModel);
        }
        return list1;
    }


}
