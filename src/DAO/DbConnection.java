/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ABC
 */
public class DbConnection {
        
    public Connection getDbConnection(){
        
         Connection conn = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
             System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aedfinalproject", "root", "admin");
            System.out.println("Connected database successfully...");
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return conn;
}
    
}
