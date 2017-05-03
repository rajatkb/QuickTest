package com.controller.quickTest;

import com.model.quickTest.dbManager;
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
            teacher tobj = obj.teacher_search(id);
            request.getSession().setAttribute("teacher_data", id );
            response.sendRedirect("teacherDash.jsp");
       }
       else if(student_username != null)
       {
       
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
    }

}
