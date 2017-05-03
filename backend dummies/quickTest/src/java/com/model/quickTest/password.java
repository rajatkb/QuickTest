
package com.model.quickTest;

import java.security.MessageDigest;
import java.sql.*;

public class password {
    
    private int id;
    private String password;
    
    private String encrypt(String password)
    {
       try{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        password = sb.toString();
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
        return password;
    }
    /*
        The encrypt method needs to be implemeneted
    */
    public void setData( int id , String rawPassword )
    {
        this.id = id;
        this.password = encrypt(rawPassword);
    }
    
    public void viewData()
    {
        System.out.println(this.id);
        System.out.println(this.password);
    }
    
    public String getPass()
    {
        return this.password;
    }
    
    /* this is where the passwords are handled*/
    
    public int createDB(Connection dbObj)
    {
        try
        {
            Statement state = (Statement) dbObj.createStatement();
            state.execute("CREATE TABLE IF NOT EXISTS password(\n" +
                          "id          INT UNIQUE,\n" +
                          "password    VARCHAR(65),\n" +
                          "PRIMARY KEY(id)\n" +
                          "); ");
            return 1;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    public int insertIntoDB(Connection dbObj)
    {
        try
        {   
            Statement set = (Statement) dbObj.createStatement();
            set.execute("INSERT INTO password( id , password) VALUES ( "+String.valueOf(this.id)+" , \""+this.password+"\");");
            return 1;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    
    }
    
    public int loadDataFromDB(Connection dbObj , int Id)
    {
        try
        {
            Statement state = (Statement) dbObj.createStatement();
            ResultSet set =state.executeQuery("SELECT * FROM password WHERE id="+String.valueOf(Id)+";");
            set.next();
            this.id = Id;
            this.password = set.getString("password");
            return 1;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
            
    
}
