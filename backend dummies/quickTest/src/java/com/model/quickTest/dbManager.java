package com.model.quickTest;
import java.io.*;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        performa perObj = new performa();
        pobj.createDB(dbObj);
        tobj.createDB(dbObj);
        sobj.createDB(dbObj);
        qobj.createDB(dbObj);
        tsobj.createDB(dbObj);
        perObj.createDB(dbObj);
        return 1;
    }
    /////////////TEACHER MANAGERIAL PART ///////////
    
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
    
    public int updateTeacher( teacher obj , HttpServletRequest request)
    {
        try
        {
            System.out.println(request.getParameterMap());
            String name = request.getParameter("new_name");
            String jobDescription = request.getParameter("new_desg");
            String specialization = request.getParameter("new_qual");
            String qualification = request.getParameter("new_specs");
            obj.setUpdateData(name, jobDescription, specialization, qualification);
            obj.updateDataInDB(dbObj);
            return 1;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
        
    }
    
    ///////////// STUDENT MANAGERIAL PART//////////////
    
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
        obj.viewData();
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
    ///// test routines  for db /////////////////
    //this inserts the test for all the students in the perform for those students the test belongs to
    public int insertTestForAllStudents(int testId)
    {
        try
        {
            Statement state = this.dbObj.createStatement();
            state.execute("insert into performa(studentId , testId)\n" +
                               "select studentId , testId \n" +
                               "from student s\n" +
                               "inner join test t on (s.depCode = t.depCode and  s.batchYear = t.batchYear and t.testId="+String.valueOf(testId)+" );\n" +
                               "");
            return 1;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    public int addTest(HttpServletRequest request, HttpServletResponse response )
    {
        try{
            
            String title = request.getParameter("title");
            String description = request.getParameter("desc");
            int depCode = Integer.parseInt(request.getParameter("dept"));
            int batchYear = Integer.parseInt(request.getParameter("batch"));
            int totalMarks = Integer.parseInt(request.getParameter("fullMarks"));
            int passMarks = Integer.parseInt(request.getParameter("passMarks"));
            int teacherId = ((teacher)request.getSession().getAttribute("user_data")).getID();
            int allotedTime = Integer.parseInt(request.getParameter("duration"));
            String scheduledDate = request.getParameter("date");
            String answerScript = request.getParameter("answers");
            test tobj = new test();
            tobj.setData(title, description, depCode, batchYear, totalMarks, passMarks, teacherId, allotedTime, scheduledDate, answerScript);
            int testId = tobj.insertIntoDB(dbObj);
            int noOfQuestion = Integer.parseInt(request.getParameter("total_ques"));
            question qobj = new question();            
            String questionNo="";
            String[] questionOptions =new String[4] ;
            for(int i = 0 ;i < noOfQuestion ; i++)
            {
                questionNo = "question"+String.valueOf(i+1);
                for(int j = 1 ; j <= 4 ; j++)
                {
                    questionOptions[j-1] = request.getParameter(questionNo+"_opt"+String.valueOf(j));
                }
                questionNo= request.getParameter(questionNo);
                qobj.putQuestion(testId, questionNo, questionOptions);
                qobj.insertIntoDB(dbObj);
            }
            return testId;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    public int deleteTest(int testId)
    {
        try
        {
            test obj = new test();
            obj.loadFromDB(dbObj, testId);
            return obj.deleteFromDB(dbObj);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
        
    }
    
    public ResultSet getAllTest(int teacherId) // for teacher
    {
        try{
            Statement state = this.dbObj.createStatement();
            ResultSet set = state.executeQuery("select * from test where teacherId="+String.valueOf(teacherId)+" order by testId desc;");
            return set;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return null;
        }
    }
    
    public ResultSet getAllTest(int depCode , int batchYear)
    {
        try
        {
            Statement state = this.dbObj.createStatement();
            ResultSet set = state.executeQuery("select * from test where depCode="+String.valueOf(depCode)+" and batchYear="+String.valueOf(batchYear)+";");
            return set;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return null;
        }
    }
    ///////////////FOR MNAGING TEST AND PURPOSES//////////////////////////
    
    public test getTest(int testId )
    {
        
        test obj= new test();
        obj.loadFromDB(dbObj, testId);
        return obj;
    }
    
}
