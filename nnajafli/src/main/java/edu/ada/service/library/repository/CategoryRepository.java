package edu.ada.service.library.repository;

import edu.ada.service.library.model.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

   CategoryEntity findByName(String name);

}
