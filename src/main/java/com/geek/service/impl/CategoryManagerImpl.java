package com.geek.service.impl;

import com.geek.dao.CategoryDAO;
import com.geek.model.Category;
import com.geek.service.CategoryManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManagerImpl implements CategoryManager {

    Logger logger = Logger.getLogger(CategoryManagerImpl.class);

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public Category getCategoryById(int cid) {
        List<Category> categories = categoryDAO.getCategoriesById(cid);
        if (categories == null || categories.size() == 0 || categories.size() > 1) {
            return null;
        }

        return categories.get(0);
    }

    @Override
    public int addCategory(String cname) {
        return categoryDAO.addCategory(cname);
    }

    @Override
    public int updateCategoryById(int cid, String cname) {
        return categoryDAO.updateCategoryById(cid, cname);
    }

    @Override
    public int deleteCategoryById(int cid) {
        return categoryDAO.deleteCategoryById(cid);
    }

}
