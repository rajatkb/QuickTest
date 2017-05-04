/*
     
*/

package com.model.quickTest;

import java.sql.*;
import java.io.*;

public class question{
        private int questionId;
        private int testId;
        private String question;
        private String dummyAnswers[] = new String[4];
         
        public void putQuestion(int testId, String question, String dummyAnswers[])
        {
            this.testId = testId;
            this.question = question;
            this.dummyAnswers = dummyAnswers;
        }
        
        public void seeQuestion()
        {
            System.out.println(this.testId);
            System.out.println(this.question);
            for (String dummyAnswer : this.dummyAnswers) {
                System.out.println(dummyAnswer);
            }
            System.out.println(this.questionId);
        }
        
        public int createDB(Connection dbObj)
        {
            try
            {
                Statement state = (Statement) dbObj.createStatement();
                state.execute("CREATE TABLE IF NOT EXISTS question(\n" +
                              "questionId  INT NOT NULL UNIQUE AUTO_INCREMENT ,\n" +
                              "testId      INT NOT NULL , \n" +
                              "question    VARCHAR(100) NOT NULL , \n" +
                              "dummy1      VARCHAR(50) NOT NULL ,\n" +
                              "dummy2      VARCHAR(50) NOT NULL ,\n" +
                              "dummy3      VARCHAR(50) NOT NULL ,\n" +
                              "dummy4      VARCHAR(50) NOT NULL ,\n" +
                              "FOREIGN KEY(testID) REFERENCES test(testId)\n" +
                              "ON DELETE CASCADE );");
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
                Statement state =(Statement) dbObj.createStatement();
                state.execute("INSERT INTO question(testId , question, dummy1, dummy2 , dummy3 , dummy4)" +
                              "VALUES ("+this.testId+" , \""+this.question+"\" , \""+this.dummyAnswers[0]+"\",\""+this.dummyAnswers[1]+"\", \""+this.dummyAnswers[2]+"\", \""+this.dummyAnswers[3]+"\");");
                ResultSet set = state.executeQuery("SELECT LAST_INSERT_ID() as id FROM question");
                set.next();
                this.questionId = set.getInt("id");
                return 1;
            }
            catch(Exception ex)
            {
                System.out.println(ex);
                return 0;
            }
        }
        
        public int loadFromDB(Connection dbObj , int questionId)
        {
            try
            {
                Statement state =(Statement) dbObj.createStatement();
                ResultSet set = state.executeQuery("SELECT * FROM question WHERE questionId="+String.valueOf(questionId)+" ;");
                set.next();
                this.questionId = questionId;
                this.question= set.getString("question");
                this.testId = set.getInt("testId");
                this.dummyAnswers = new String[4];
                this.dummyAnswers[0]= set.getString("dummy1");
                this.dummyAnswers[1]= set.getString("dummy2");
                this.dummyAnswers[2]= set.getString("dummy3");
                this.dummyAnswers[3]= set.getString("dummy4");
                return 1;
            }
            catch(Exception ex)
            {
                System.out.println(ex);
                return 0;
            }
        
        }
        
        public int updateIntoDB(Connection dbObj)
        {
            try
            {
                Statement state =(Statement) dbObj.createStatement();
                state.executeUpdate("UPDATE question SET question=\""+this.question+"\" testId=\""+String.valueOf(testId)+"\" dummy1=\""+this.dummyAnswers[0]+"\" dummy2=\""+this.dummyAnswers[1]+"\" dummy3=\""+this.dummyAnswers[2]+"\" dummy4=\""+this.dummyAnswers[0]+"\" WHERE questionId="+String.valueOf(this.questionId)+" ;");
                return 1;
            }
            catch(Exception ex)
            {
                System.out.println(ex);
                return 0;
            }
                
        }
                
        
        
   }
