package com.jpaul.dao.impl;

import com.jpaul.dao.CategoryDAO;
import com.jpaul.dao.IDAOManager;

public class DAOManager  implements IDAOManager {
    private CategoryDAO categoryDAO = null;

    @Override
    public CategoryDAO getCategoryDAO() {
        if(categoryDAO ==null){
            return categoryDAO = new CategoryDAO();
        }
        return null;
    }
}
