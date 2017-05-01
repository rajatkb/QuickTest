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
    
}
