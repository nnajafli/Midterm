package edu.ada.service.library.repository;

import edu.ada.service.library.model.entity.LibraryHistoryEntity;
import edu.ada.service.library.model.service.LibraryHistoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryHistoryRepository extends JpaRepository<LibraryHistoryEntity, Integer> {

    LibraryHistoryEntity findByBookIdAndStudentId(int bookId, int studentId);

    List<LibraryHistoryEntity> findAllByStudentId(int studentId);

    List<LibraryHistoryEntity> findAllByStudentIdAndDateTaken(int studentId, String takenDate);


}
