package com.example.case_md3.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    private final String URL = "jdbc:mysql://localhost:3306/Unicorm_library?useSSL=false" ;
    private final String userName = "root" ;
    private final String password = "123456";
    public Connection getConnection (){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,userName,password) ;
        }catch (Exception e ) {
            e.printStackTrace();
        }
        return connection;
    }
}
