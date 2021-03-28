package edu.ada.service.library.model.service;


import edu.ada.service.library.model.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity findById(int id);

    CategoryEntity findByName(String name);

    boolean checkCategory(String name);

}
