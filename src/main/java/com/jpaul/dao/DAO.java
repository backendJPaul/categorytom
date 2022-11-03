package com.jpaul.dao;

import com.jpaul.model.Category;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    protected Connection connection;
    protected CallableStatement callableStatement;
    protected ResultSet resultSet;


    private final String user = "admin";
    private final String pass = "root";
    private final String database = "dbcategory";

    //TODO change to protected
    protected void connectDatabase() throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcategory","admin","root");
        }
        catch(SQLException e){
            throw new Exception(e.toString());
        }

    }

    protected void disconnectDatabase()throws Exception{
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(callableStatement != null){
                callableStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        catch(SQLException e){
            throw new Exception(e.toString());
        }
    }

    protected ResultSet executeQuery(CallableStatement callableStatement)throws SQLException{
        this.callableStatement = callableStatement;
        return callableStatement.executeQuery();
    }
}
