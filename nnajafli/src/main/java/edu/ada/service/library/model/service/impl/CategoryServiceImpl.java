package edu.ada.service.library.model.service.impl;

import edu.ada.service.library.model.entity.CategoryEntity;
import edu.ada.service.library.model.entity.UserEntity;
import edu.ada.service.library.model.service.CategoryService;
import edu.ada.service.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public CategoryEntity findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public CategoryEntity findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public boolean checkCategory(String name) {
        CategoryEntity categoryEntity;
        categoryEntity = categoryRepository.findByName(name);
        if (categoryEntity != null && categoryEntity.getId() > 0) {

            categoryEntity = categoryRepository.findByName(name);

            if (categoryEntity != null && categoryEntity.getId() > 0) {
                return true;
            } else {
                return false;
            }

        } else {
            return true;
        }
    }
}
