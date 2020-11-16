package com.geek.service;

import com.geek.model.Category;

import java.util.List;

public interface CategoryManager {

    List<Category> getAllCategories();

    Category getCategoryById(int cid);

    int addCategory(String cname);

    int updateCategoryById(int cid, String cname);

    int deleteCategoryById(int cid);

}

