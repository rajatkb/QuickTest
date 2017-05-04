package com.controller.quickTest;

import com.businessLogic.quickTest.authenticator;
import com.model.quickTest.dbManager;
import com.model.quickTest.student;
import com.model.quickTest.teacher;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      authenticator obj = new authenticator();
      dbManager dobj = new dbManager();
     
     String teacher_username = request.getParameter("teacher_username");
     String student_username = request.getParameter("student_username");
     
     if(teacher_username != null)
     {
         String password= request.getParameter("teacher_password");
         int teacherId =obj.authenticateTeacher(teacher_username, password);
         if(teacherId == 0)
         { 
             request.getSession().setAttribute("warn","USER NOT FOUND , REGISER FIRST");
             response.sendRedirect("login");
         }
         else if(teacherId < 0)
         {
             request.getSession().setAttribute("warn","WRONG PASSWORD, CHECK USERNAME & PASSWORD");
             response.sendRedirect("login");
         }
         else
         {
             teacher tobj = dobj.teacher_search(teacherId);
             request.getSession().setAttribute("user_data", tobj);
             response.sendRedirect("teacherDash");
         }
     }
     else if(student_username != null)
     {
         String password = request.getParameter("student_password");
         int studentId = obj.authenticateStudent(student_username, password);
         if(studentId ==0)
         {    
             request.getSession().setAttribute("warn","USER NOT FOUND, REGISTER FIRST");
             response.sendRedirect("login");
         }
         else if(studentId < 0 )
         {
             request.getSession().setAttribute("warn","WRONG PASSWORD, CHECK USERNAME & PASSWORD");
             response.sendRedirect("login");
         }
         else
         {
             student sobj = dobj.student_search(studentId);
             request.getSession().setAttribute("user_data", sobj);
             response.sendRedirect("studentDash");
         }
     }
     else
     {
         response.sendRedirect("login.jsp");
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
    }// </editor-fold>

}
