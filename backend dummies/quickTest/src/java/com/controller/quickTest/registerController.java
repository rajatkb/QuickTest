package com.controller.quickTest;

import com.model.quickTest.dbManager;
import com.model.quickTest.student;
import com.model.quickTest.teacher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class registerController extends HttpServlet {

        
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
       String teacher_username = request.getParameter("teacher_username");
       String student_username = request.getParameter("student_username");
       if(teacher_username != null)
       {
            String name = request.getParameter("teacher_name") ;
            String jobDescription =request.getParameter("teacher_jobDescription");
            String mail = request.getParameter("teacher_email");
            String specialization = request.getParameter("teacher_specialization");
            String qualification = request.getParameter("teacher_qualification");
            String password = request.getParameter("teacher_password");
            dbManager obj = new dbManager();
            int id=obj.registerTeacher(teacher_username, name, jobDescription, mail, specialization, qualification, password);
            if( id == 0)
            {   
                response.sendRedirect("login"); // When REGITRATION FAILS DUE TO SAME DATA EXSITING
            }
            else{
                teacher tobj = obj.teacher_search(id);
                request.getSession().setAttribute("teacher_data", tobj ); // When ts succeds
                response.sendRedirect("teacherDash");
            }
       }
       else if(student_username != null)
       {
           int rollNo = Integer.parseInt(request.getParameter("student_rollno"));
           int batchYear = Integer.parseInt(request.getParameter("student_batchYear"));
           String name = request.getParameter("student_name");
           System.out.println(request.getParameter("student_depCode"));
           int depCode = Integer.parseInt(request.getParameter("student_depCode"));
           String email = request.getParameter("student_email");
           String password = request.getParameter("student_password");
           dbManager obj = new dbManager();
           
           int insertedId = obj.studentRegister(email, rollNo, batchYear, name, student_username, depCode, password);
           if( insertedId == 0)
           {
               response.sendRedirect("login");
           }
           else
           {    
               
               student sobj = obj.student_search(insertedId);
               request.getSession().setAttribute("student_data", sobj );
               response.sendRedirect("studentDash");
           }
       }
       else
       {
           response.sendRedirect("login.jsp");
       }
       }
       catch(Exception ex)
       {
           System.out.println("error at register point"+ex);
           
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
