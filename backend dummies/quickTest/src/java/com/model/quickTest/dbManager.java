package com.model.quickTest;
import java.io.*;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class dbManager {

    Connection dbObj;
    
    public dbManager()
    {
        try
        {   
            Context initContext  = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource)envContext.lookup("jdbc/db");
            Connection dbServerConnect =  (Connection) dataSource.getConnection();
            this.dbObj = dbServerConnect;
            
        }catch(Exception ex)
        {
            System.out.println("Connection Failed to db" + ex);
        }
    }
    
    public Connection getConnector()
    {
        return this.dbObj;
    }

    public String dummy()
    {
        try
        {
            Statement state = (Statement) dbObj.createStatement();
            ResultSet set = state.executeQuery("SELECT * FROM teacher");
            set.next();
            return set.getString("username");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return "null";
        }
    }
    
    public int intialiseAllDB()
    {
        password pobj = new password();
        teacher tobj = new teacher();
        student sobj = new student();
        question qobj = new question();
        test tsobj = new test();
        pobj.createDB(dbObj);
        tobj.createDB(dbObj);
        sobj.createDB(dbObj);
        qobj.createDB(dbObj);
        tsobj.createDB(dbObj);
        
        return 1;
    }
    
    public  teacher teacher_search(int id)
    {
        teacher obj = new teacher();
        obj.loadDataFromDb(dbObj, id);
        return obj;
    }
    
    public teacher teacher_search(String user) 
    {
        try{
        Statement state = (Statement) this.dbObj.createStatement();
        ResultSet set= state.executeQuery("SELECT teacherId FROM teacher WHERE username=\""+user+"\" or email=\""+user+"\";");
        teacher obj = new teacher();
        set.next();
        obj.loadDataFromDb(dbObj,set.getInt("teacherId"));
        return obj;
        }
        catch(Exception ex)
        {
            System.out.println(ex + "The user is not found");
            return null;
        }
       
    }
    
    
    public int registerTeacher( String username,String name,String jobDescription,String email,String specialization,String qualification , String password)
    {
        try{
        teacher obj= new teacher();
        obj.setNewData(name, username, jobDescription, email, specialization, qualification);
        int insertedId=obj.insertDataIntoDB(dbObj);
        // This deotes the succesfull insertion of data into the db for teacheer
        // may fail if the value is 0 which is bcz of dulicate data 
        if(insertedId!=0 )
        {   
            password pobj = new password();
            pobj.setData(insertedId  , password);
            pobj.insertIntoDB(dbObj);
            //insert the id  and password in the DB
            return insertedId;
        }
        
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            
        }
        return 0;
    }
    
    public student student_search(int id)
    {
        student obj = new student();
        obj.loadDataFromDb(dbObj, id);
        return obj;
    }
    
    public student student_search(String user) 
    {
        try{
        Statement state = (Statement) this.dbObj.createStatement();
        ResultSet set= state.executeQuery("SELECT studentId FROM student WHERE username=\""+user+"\" or email=\""+user+"\";");
        student obj = new student();
        set.next();
        obj.loadDataFromDb(dbObj,set.getInt("studentId"));
        return obj;
        }
        catch(Exception ex)
        {
            System.out.println(ex + "The user is not found");
            return null;
        }
       
    }
    
    
    
    
    
    
    
    public int  studentRegister(String email,int rollNo, int batchYear, String name, String username, int depCode , String password)
    {
        try{
        student obj =new student();
        obj.setNewData(email, rollNo, batchYear, name, username, depCode);
        int insertedId = obj.insertDataIntoDB(dbObj);
        if(insertedId != 0)
        {
            password pobj = new password();
            pobj.setData(insertedId, password);
            pobj.insertIntoDB(dbObj);
            //insert the id and password
            return insertedId;
        }
        }
        catch(Exception ex)
        {
            System.out.println("Exception at student register" + ex);
        }
        return 0;
    }
    
    
}
