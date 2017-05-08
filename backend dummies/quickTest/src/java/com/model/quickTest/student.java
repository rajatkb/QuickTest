/*
    THE STUDENT DB MODULE IS DONE
    *setNewData /sets data for first time by programmer
    *getId / allows to get the teacher ID whenever necessary
    *viewData / allows to view the data inside the object
    *insertDataIntoDB / allows for inserting data into the db that is insie the object
    *loadDataFromDB/ loads the entire data from teh db to the application
    *deleteDataFromDB / deletes that particular dataset that is loaded using loadFromDB
*/ 
package com.model.quickTest;
import com.businessLogic.quickTest.utility;
import java.sql.*;
import java.io.*;

public class student {
    
    private int studentId;
    private int rollNo;
    private int batchYear;
    private String name;
    private String username;
    private String department;
    private int depCode;
    private String email;
   
    

    public String getUsername() {
        return username;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public int getBatchYear() {
        return batchYear;
    }
   
    
    public void setNewData(String email,int rollNo, int batchYear, String name, String username, int depCode)
    {
        utility util = new utility();
        this.email = email;
        this.rollNo = rollNo;
        this.batchYear = batchYear;
        this.name = name;
        this.username = username;
        this.department = util.mapDepCode(depCode);
        this.depCode = depCode;
        this.studentId=  Integer.valueOf(String.valueOf(batchYear)+String.valueOf(rollNo));
    }
   
    public void viewData()
    {
        System.out.println(this.email);
        System.out.println(this.rollNo);
        System.out.println(this.batchYear);
        System.out.println(this.name);
        System.out.println(this.username);
        System.out.println(this.department);
        System.out.println(this.depCode);
        System.out.println(this.studentId);
        
    }
    public int getBatchAndDep()
    {
        return Integer.valueOf(String.valueOf(this.batchYear)+String.valueOf(this.depCode));
    }
    
    public int getStudentId()
    {
        return this.studentId;
    }
    
    /* THIS IS WHERE THE DATABASE OF THE STUDENT IS MANAGED*/
    
    public void createDB(Connection dbObj)
    {
        try{
            Statement stateObj = (Statement) dbObj.createStatement();
            stateObj.execute("CREATE TABLE IF NOT EXISTS student" +
                            "(studentId       INT NOT NULL UNIQUE," +
                            "username        VARCHAR(50) NOT NULL UNIQUE," +
                            "batchYear       INT NOT NULL," +
                            "depCode         INT NOT NULL," +
                            "name            VARCHAR(50) NOT NULL," +
                            "department      VARCHAR(50) NOT NULL,"+
                            "rollno          INT NOT NULL , "+
                            "email           VARCHAR(50) NOT NULL UNIQUE, "+
                            "PRIMARY KEY(studentId)" +
                            ");");
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
    }
    
    public int insertDataIntoDB(Connection dbObj)
    {
        try{
            Statement state =(Statement) dbObj.createStatement();
            state.execute("INSERT INTO student(studentId , username , batchYear , depCode , name , department , rollno , email)" +
                          "VALUES ("+String.valueOf(this.studentId)+", \""+this.username+"\","+String.valueOf(this.batchYear)+","+String.valueOf(this.depCode)+", \""+this.name+"\" , \""+this.department+"\", "+String.valueOf(this.rollNo)+",\""+this.email+"\");");
            
            return this.studentId;
        }catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    public void deleteDataFromDB(Connection dbObj)
    {
        try{
            
            Statement state = (Statement) dbObj.createStatement();
            state.execute("DELETE FROM student WHERE studentId="+String.valueOf(this.studentId)+";");
            
        }catch(Exception ex){
        
            System.out.println(ex);
        }
    }
    
    public void loadDataFromDb(Connection dbObj, int studentId)
    {
        try{
            Statement state = (Statement) dbObj.createStatement();
            ResultSet set = state.executeQuery("SELECT * FROM student WHERE studentId="+String.valueOf(studentId)+";");
            set.next();
            this.batchYear = set.getInt("batchYear");
            this.depCode = set.getInt("depCode");
            this.department = set.getString("department");
            this.email = set.getString("email");
            this.name = set.getString("name");
            this.rollNo= set.getInt("rollNo");
            this.studentId = set.getInt("studentId");
            this.username = set.getString("username");
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
