/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanagement;
import com.mysql.jdbc.Connection;
import java.io.*;
import java.sql.*;
/**
 *
 * @author Rajat
 */
public class DbManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try
        {   
            String dbURL = "jdbc:mysql://localhost:3306/quicktest";
            String uname = "root";
            String pass  = "iamrajat"; 
            Connection dbServerConnect =  (Connection) DriverManager.getConnection(dbURL,uname,pass);
            
            
            question obj= new question();
            obj.createDB(dbServerConnect);
            String[] ar={"aesehi", "fuck of", "no", "yes"};
            obj.putQuestion(1, "Why i have aked this?", ar );
            obj.insertIntoDB(dbServerConnect);
            obj.loadFromDB(dbServerConnect, 2);
            obj.seeQuestion();
            
            
        }catch(SQLException ex)
        {
            System.out.println("Connection Failed to db" + ex);
        }
    }
    
}
