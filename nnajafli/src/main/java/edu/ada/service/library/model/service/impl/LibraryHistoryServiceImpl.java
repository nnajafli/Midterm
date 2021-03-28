package edu.ada.service.library.model.service.impl;

import edu.ada.service.library.model.dto.BookMetaDATA;
import edu.ada.service.library.model.dto.LibraryModel;
import edu.ada.service.library.model.dto.StudentDataModel;
import edu.ada.service.library.model.entity.Books;
import edu.ada.service.library.model.entity.CategoryEntity;
import edu.ada.service.library.model.entity.LibraryHistoryEntity;
import edu.ada.service.library.model.entity.UserEntity;
import edu.ada.service.library.model.service.LibraryHistoryService;
import edu.ada.service.library.repository.BooksRepository;
import edu.ada.service.library.repository.CategoryRepository;
import edu.ada.service.library.repository.LibraryHistoryRepository;
import edu.ada.service.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryHistoryServiceImpl implements LibraryHistoryService {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");


    @Autowired
    private LibraryHistoryRepository libraryHistoryRepository;
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void pickup(int bookId, int studentId) {
        LibraryHistoryEntity libraryHistoryEntity = new LibraryHistoryEntity();
        libraryHistoryEntity.setBookId(bookId);
        libraryHistoryEntity.setStudentId(studentId);
        libraryHistoryEntity.setDateTaken(simpleDateFormat.format(new Date()));
        Books books = booksRepository.findById(bookId).get();
        books.setUserID(studentId);
        books.setAvailable("Taken");
        libraryHistoryRepository.save(libraryHistoryEntity);
        booksRepository.save(books);


    }

    @Override
    public void dropoff(int bookId, int studentId) {
        LibraryHistoryEntity libraryHistoryEntity = libraryHistoryRepository.findByBookIdAndStudentId(bookId, studentId);
        libraryHistoryEntity.setDateDrop(simpleDateFormat.format(new Date()));
        Books books = booksRepository.findById(bookId).get();
        books.setUserID(0);
        books.setAvailable("Not Taken");
        libraryHistoryRepository.save(libraryHistoryEntity);
        booksRepository.save(books);
    }

    @Override
    public boolean check(int bookId) {
        System.out.printf(String.valueOf(bookId));
        Books books;
        books = booksRepository.findFirstById(bookId);

        if (books == null) {
            return false;

        } else {
            return false;
        }
    }

    @Override
    public List<LibraryModel> currentlyPickUp(int studentId) {

        List<LibraryHistoryEntity> list =
                libraryHistoryRepository.findAllByStudentIdAndDateTaken(studentId, simpleDateFormat.format(new Date()));

        List<LibraryModel> libraryModels = new ArrayList<>();
        if (list.size() > 0 && list != null) {
            for (int i = 0; i < list.size(); i++) {
                LibraryModel libraryModel = new LibraryModel();
                Books books = booksRepository.findById(list.get(i).getBookId()).get();
                CategoryEntity categoryEntity = categoryRepository.findById(books.getCategoryId()).get();
                StudentDataModel studentDataModel = new StudentDataModel();
                UserEntity userEntity = userRepository.findById(Long.parseLong(String.valueOf(list.get(i).getStudentId()))).get();
                BookMetaDATA bookMetaDATA = new BookMetaDATA();
                bookMetaDATA.setName(books.getName());
                bookMetaDATA.setAvailable(books.getAvailable());
                bookMetaDATA.setCategoryName(categoryEntity.getName());
                bookMetaDATA.setUserId(list.get(i).getStudentId());
                studentDataModel.setFirstname(userEntity.getFirstname());
                studentDataModel.setId(list.get(i).getStudentId());
                studentDataModel.setLastname(userEntity.getLastname());
                libraryModel.setBookMetaDATA(bookMetaDATA);
                libraryModel.setStudentDataModel(studentDataModel);
                libraryModels.add(libraryModel);

            }


        }

        return libraryModels;
    }

    @Override
    public List<LibraryModel> wholePickUp(int studentId) {
        List<LibraryHistoryEntity> list =
                libraryHistoryRepository.findAllByStudentId(studentId);

        List<LibraryModel> libraryModels = new ArrayList<>();
        if (list.size() > 0 && list != null) {
            for (int i = 0; i < list.size(); i++) {
                LibraryModel libraryModel = new LibraryModel();
                Books books = booksRepository.findById(list.get(i).getBookId()).get();
                CategoryEntity categoryEntity = categoryRepository.findById(books.getCategoryId()).get();
                StudentDataModel studentDataModel = new StudentDataModel();
                UserEntity userEntity = userRepository.findById(Long.parseLong(String.valueOf(list.get(i).getStudentId()))).get();
                BookMetaDATA bookMetaDATA = new BookMetaDATA();
                bookMetaDATA.setName(books.getName());
                bookMetaDATA.setAvailable(books.getAvailable());
                bookMetaDATA.setCategoryName(categoryEntity.getName());
                bookMetaDATA.setUserId(list.get(i).getStudentId());
                studentDataModel.setFirstname(userEntity.getFirstname());
                studentDataModel.setId(list.get(i).getStudentId());
                studentDataModel.setLastname(userEntity.getLastname());
                libraryModel.setBookMetaDATA(bookMetaDATA);
                libraryModel.setStudentDataModel(studentDataModel);
                libraryModels.add(libraryModel);

            }


        }

        return libraryModels;
    }

}

