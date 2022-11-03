package com.jpaul.dao;

import com.jpaul.model.Category;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DAO implements IDAOCategory {

    public Category create(Category o) throws Exception {

        this.connectDatabase();
        CallableStatement callableStatement = this.connection.prepareCall("call stpCCategory(?)");
        callableStatement.setString(1,o.getName());
        this.resultSet = this.executeQuery(callableStatement);

        Category category = new Category();
        while(resultSet.next()){
            category.setIdCategory(resultSet.getInt("idCategory"));
            category.setName(resultSet.getString("name"));
        }
        return category;
    }

    public List<Category> read() throws Exception {
        this.connectDatabase();

        CallableStatement callableStatement = this.connection.prepareCall("call stpRCategory()");
        this.resultSet = this.executeQuery(callableStatement);

        ArrayList<Category> categories = new ArrayList<Category>();
        while(resultSet.next()){
            Category category = new Category();
            category.setIdCategory(resultSet.getInt("idCategory"));
            category.setName(resultSet.getString("name"));
            categories.add(category);
        }
        return categories;
    }

    public Category update(Category o) throws Exception {
        this.connectDatabase();
        CallableStatement callableStatement = this.connection.prepareCall("call stpUCategory(?,?)");

        callableStatement.setInt(1,o.getIdCategory());
        callableStatement.setString(2,o.getName());

        this.resultSet = this.executeQuery(callableStatement);

        Category category = new Category();
        while(resultSet.next()){
            category.setIdCategory(this.resultSet.getInt("idCategory"));
            category.setName(this.resultSet.getString("name"));
        }
        return category;
    }

    public Category delete(Category o) throws Exception {
        this.connectDatabase();
        CallableStatement callableStatement = this.connection.prepareCall("call stpDCategory(?,?)");

        callableStatement.setInt(1,2);
        callableStatement.setInt(2,o.getIdCategory());

        this.resultSet = this.executeQuery(callableStatement);

        Category category = new Category();
        while(resultSet.next()){
            category.setIdCategory(this.resultSet.getInt("idCategory"));
            category.setName(this.resultSet.getString("name"));
        }
        return category;
    }

    public List<Category> search(String pattern) throws Exception {
        this.connectDatabase();
        CallableStatement callableStatement = connection.prepareCall("call stpSCategory(?)");

        callableStatement.setString(1,pattern);

        this.resultSet = this.executeQuery(callableStatement);

        ArrayList<Category> categories = new ArrayList<Category>();
        while(resultSet.next()){
            Category category = new Category();
            category.setIdCategory(this.resultSet.getInt("idCategory"));
            category.setName(this.resultSet.getString("name"));
            categories.add(category);
        }
        return categories;
    }

    public Category gotoId(Category o) throws Exception {
        this.connectDatabase();
        CallableStatement callableStatement = this.connection.prepareCall("call stpGTIDCategory(?)");
        callableStatement.setInt(1,o.getIdCategory());

        this.resultSet = this.executeQuery(callableStatement);

        Category category = new Category();
        while(resultSet.next()){
            category.setIdCategory(resultSet.getInt("idCategory"));
            category.setName(resultSet.getString("name"));
        }
        return category;
    }
}
