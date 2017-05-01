/*
    THE TEST DB MODULE IS DONE
    *setNewData /sets data for first time by programmer
    *setUpdateData / Updates the 
    *getId / allows to get the teacher ID whenever necessary
    *viewData / allows to view the data inside the object
    *insertDataIntoDB / allows for inserting data into the db that is insie the object
    *loadDataFromDB/ loads the entire data from teh db to the application
    *deleteDataFromDB / deletes that particular dataset that is loaded using loadFromDB 
*/
package com.model.quickTest;

import com.mysql.jdbc.Connection;
import java.sql.*;

public class test {
    private int testId;
    private int teacherId;
    private String title;
    private String description;
    private int depCode;
    private int batchYear;
    private int totalMarks;
    private int passMarks;
    private int allotedTime;
    private int marksPerQuestion;
    private String scheduledDate;
    private String startDate;
    private String startTime;
    private String endTime;
    private boolean canBeUpdated; 
    private boolean yetToStart;
    private boolean running;
    private boolean finished;
    private String answerScript;
    
    public int setData( 
                         String title,
                         String description,
                         int depCode, 
                         int batchYear,
                         int totalMarks,
                         int passMarks ,
                         int marksPerQuestion,
                         int teacherId ,
                         int allotedTime ,
                         String scheduledDate,
                         String answerScript
                         )
    {
        this.title=title;
        this.marksPerQuestion = marksPerQuestion;
        this.scheduledDate = scheduledDate;
        this.description = description;
        this.depCode= depCode;
        this.batchYear = batchYear;
        this.totalMarks = totalMarks;
        this.passMarks = passMarks;
        this.teacherId = teacherId;
        this.allotedTime= allotedTime;
        this.answerScript = answerScript;
        return testId;
    }
    
    public void viewData()
    {
        System.out.println(this.scheduledDate);
        System.out.println(this.title);
        System.out.println(this.description);
        System.out.println(this.depCode);
        System.out.println(this.batchYear);
        System.out.println(this.totalMarks);
        System.out.println(this.passMarks);
        System.out.println(this.teacherId);
        System.out.println(this.allotedTime);
        System.out.println(this.startTime);
        System.out.println(this.endTime);
        System.out.println(this.canBeUpdated);
        System.out.println(this.yetToStart);
        System.out.println(this.running);
        System.out.println(this.finished);
        System.out.println(this.answerScript);
        System.out.println(this.testId);
        System.out.println(this.startDate);
        System.out.println(this.marksPerQuestion);
    }
    
    public int getBatchAndDep()
    {
        return Integer.valueOf(String.valueOf(this.batchYear)+String.valueOf(this.depCode));
    }
    
    public int getTestId()
    {
        return this.testId;
    }
    
    public String getAnswerScript()
    {
        return this.answerScript;
    }
    
    public int getPassMark()
    {
        return this.passMarks;
    }
    /*
        The DB mangement starts here
    */
    
    public int createDB(Connection dbObj)
    {
        try
        {
            Statement state = (Statement) dbObj.createStatement();
            state.execute("CREATE TABLE IF NOT EXISTS test( " +
                          "    testId          INT NOT NULL UNIQUE AUTO_INCREMENT," +
                          "    teacherId       INT NOT NULL ," +
                          "    title           VARCHAR(50) NOT NULL," +
                          "    description     VARCHAR(50) NOT NULL," +
                          "    depCode         INT NOT NULL , " +
                          "    batchYear       INT NOT NULL , " +
                          "    totalMarks      INT NOT NULL , " +
                          "    passMarks       INT NOT NULL , " +
                          "    marksPerQuestion INT NOT NULL , "+
                          "    allotedTime     INT NOT NULL , " +
                          "    scheduledDate   DATE NOT NULL , "+
                          "    startDateTime   TIMESTAMP NULL , " +
                          "    endDateTime     TIMESTAMP NULL , " +
                          "    canBeUpdated    INT NOT NULL DEFAULT 1 , " +
                          "    yetToStart      INT NOT NULL DEFAULT 1 , " +
                          "    running         INT NOT NULL DEFAULT 0 , " +
                          "    finished        INT NOT NULL DEFAULT 0 , " +
                          "    answerScript    VARCHAR(100) NOT NULL  , " +
                          "    CHECK (passMarks < (totaMarks/2)) , "+
                          "    PRIMARY KEY(testId) , " +
                          "    FOREIGN KEY(teacherId) REFERENCES teacher(teacherId) " +
                          ");");
            return 1;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    public int insertIntoDB(Connection dbObj)
        {
            try
            {
                Statement state = (Statement) dbObj.createStatement();
                state.execute("INSERT INTO test(teacherId , title , description , depCode , batchYear ,totalMarks , passMarks ,marksPerQuestion , allotedTime , scheduledDate,answerScript )\n" +
                              "VALUES ("+String.valueOf(this.teacherId)+" ,\""+this.title+"\" , \""+this.description+"\","+String.valueOf(this.depCode)+","+String.valueOf(this.batchYear)+","+String.valueOf(this.totalMarks)+" ,"+ String.valueOf(this.passMarks) +" ,"+String.valueOf(this.marksPerQuestion)+","+String.valueOf(this.allotedTime)+", \""+this.scheduledDate+"\" ,\""+this.answerScript+"\");");
                ResultSet set = state.executeQuery("SELECT testId FROM test WHERE answerScript=\""+this.answerScript+"\" AND description=\""+this.description+"\" AND title=\""+this.title+"\";");
                set.next();
                this.testId = set.getInt("testId");
                return 1;
            }
            catch( Exception ex)
            {
                System.out.println(ex);
                return 0;
            }
        }
    public int loadFromDB(Connection dbObj , int testId)
    {
        try{
            Statement state= (Statement) dbObj.createStatement();
            ResultSet set = state.executeQuery("SELECT * FROM test WHERE testId="+String.valueOf(testId)+";");
            set.next();
            this.testId = set.getInt("testId");
            this.teacherId = set.getInt("teacherId");
            this.title = set.getString("title");
            this.description = set.getString("description");
            this.depCode = set.getInt("depCode");
            this.batchYear = set.getInt("batchYear");
            this.totalMarks = set.getInt("totalMarks");
            this.passMarks = set.getInt("passMarks");
            this.allotedTime = set.getInt("allotedTime");
            this.marksPerQuestion = set.getInt("marksPerQuestion");
            this.scheduledDate = set.getString("scheduledDate");
            this.startDate = String.valueOf(set.getDate("startDateTime"));
            this.startTime = String.valueOf(set.getTime("startDateTime"));
            this.endTime = String.valueOf(set.getTime("endDateTime"));
            this.canBeUpdated = set.getBoolean("canBeUpdated");
            this.yetToStart = set.getBoolean("yetToStart");
            this.running = set.getBoolean("running");
            this.finished = set.getBoolean("finished");
            this.answerScript = set.getString("answerScript");
            
            return 1;   
        }catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    public int updateIntoDB(Connection dbObj)
        {
            try
            {
                Statement state = (Statement) dbObj.createStatement();
                state.execute("UPDATE test " +
                              "SET title=\""+this.title+"\" , description=\""+this.description+"\", depCode="+String.valueOf(this.depCode)+" , batchYear="+String.valueOf(this.batchYear)+", totalMarks="+String.valueOf(this.totalMarks)+" , passMarks="+ String.valueOf(this.passMarks) +" , marksPerQuestion="+String.valueOf(this.marksPerQuestion)+" , allotedTime="+String.valueOf(this.allotedTime)+" , scheduledDate=\""+this.scheduledDate+"\" , answerScript=\""+this.answerScript+"\""+
                              "WHERE testId="+String.valueOf(this.testId)+";");
                return 1;
            }
            catch( Exception ex)
            {
                System.out.println(ex);
                return 0;
            }
        }
    
    public int deleteFromDB(Connection dbObj)
    {
        try
        {
            Statement state = (Statement) dbObj.createStatement();
            state.execute("DELETE FROM test WHERE testId="+String.valueOf(this.testId)+";");
            return 1;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    
    }
            
    
    
}
