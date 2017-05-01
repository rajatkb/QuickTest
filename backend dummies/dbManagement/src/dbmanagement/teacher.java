/*
    THE TEACHER DB MODULE IS DONE
    *setNewData /sets data for first time by programmer
    *setUpdateData / chnages and updates few data for changing in database
    *getId / allows to get the teacher ID whenever necessary
    *viewData / allows to view the data inside the object
    *insertDataIntoDB / allows for inserting data into the db that is insie the object
    *loadDataFromDB/ loads the entire data from teh db to the application
    *deleteDataFromDB / deletes that particular dataset that is loaded using loadFromDB
    *updateDataIntoDB / call after updating the data a normall call would simply rewrite the same data
*/
package dbmanagement;

import com.mysql.jdbc.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class teacher {
    
    private int teacherId;
    private String username;
    private String name;
    private String jobDescription;
    private String email;
    private String specialization;
    private String qualification;
    
    /*
        Other stuff can be added later
    */
    
    
    public int setNewData( String name, String username ,String jobDescription ,String email,String specialization , String qualification )
    {
        this.name= name;
        this.username = username;
        this.jobDescription = jobDescription;
        this.email = email;
        this.specialization= specialization;
        this.qualification=qualification;
        return teacherId;
    }
    
    public void viewData()
    {
        System.out.println(this.name);
        System.out.println(this.teacherId);
        System.out.println(this.username);
        System.out.println(this.jobDescription);
        System.out.println(this.email);
        System.out.println(this.qualification);
        System.out.println(this.specialization);
    }
    
    public void setUpdateData(String name , String jobDescription , String specialization , String qualification )
    {
        this.name=name;
        this.specialization= specialization;
        this.qualification=qualification;
        this.jobDescription = jobDescription;
    }
    public int getID()
    {
        return this.teacherId;
    }
    
    
    /*
    BELOW FUNCTION USED FOR DATABASE OPERATION
    */
    
    public void createDB(Connection dbObj) //CREATES DATABASE FOR FIRST TIME
    {
         try{
            Statement stateObj = (Statement) dbObj.createStatement();
            stateObj.execute("CREATE TABLE IF NOT EXISTS teacher" +
                            "(teacherId       INT NOT NULL UNIQUE AUTO_INCREMENT," +
                            "username        VARCHAR(50) NOT NULL UNIQUE," +
                            "jobDescription  VARCHAR(50) NOT NULL," +
                            "email           VARCHAR(50) NOT NULL UNIQUE," +
                            "specialization  VARCHAR(50) NOT NULL," +
                            "qualification   VARCHAR(50) NOT NULL," +
                            "name            VARCHAR(50) NOT NULL, "  +
                            "PRIMARY KEY(teacherId)" +
                            ");");
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
    }
    
    public int insertDataIntoDB(Connection dbObj) // INSERTS THE DATA INTO THE TABLE
    {
        try
        {
            Statement stateObj = (Statement) dbObj.createStatement();
            stateObj.execute("INSERT INTO teacher(username , jobDescription , email , specialization , qualification, name)" +
                             "VALUES (\""+this.username+"\", \""+this.jobDescription+"\",\""+this.email+"\",\""+this.specialization+"\", \""+this.qualification+"\",\""+this.name+"\");");
            ResultSet rst= stateObj.executeQuery( "SELECT teacherId from teacher WHERE username = \""+this.username+"\";");
            rst.next();
            this.teacherId= Integer.parseInt(rst.getString("teacherId"));
            return 1;
        }
        catch( SQLException ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    public void deleteDataFromDB(Connection dbObj)
    {   
        try
        {
            Statement stateObj = (Statement) dbObj.createStatement();
            stateObj.execute("DELETE FROM teacher WHERE teacherId="+this.teacherId+" OR username=\""+this.username+"\";");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public void loadDataFromDb(Connection dbObj , int teacherId)
    {
        try
        {
            Statement stateObj = (Statement) dbObj.createStatement();
            ResultSet set = stateObj.executeQuery("SELECT * FROM teacher WHERE teacherId="+String.valueOf(teacherId)+";");
            set.next();
            this.teacherId = set.getInt("teacherId");
            this.username = set.getString("username");
            this.email= set.getString("email");
            this.jobDescription = set.getString("jobDescription");
            this.qualification= set.getString("qualification");
            this.specialization= set.getString("specialization");
            this.name=set.getString("name");
        }catch(SQLException ex)
        {
            System.out.println(ex);
        }    
    }
    
    public void updateDataInDB(Connection dbObj) 
    {   
        try{
        Statement stateObj = (Statement) dbObj.createStatement();
        stateObj.executeUpdate("UPDATE teacher " +
                               "SET jobDescription=\""+this.jobDescription+"\", specialization=\""+this.specialization+"\" , qualification =\""+this.qualification+"\"\n" +
                               "WHERE teacherID="+String.valueOf(this.teacherId)+";");
        
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    }
    
}
