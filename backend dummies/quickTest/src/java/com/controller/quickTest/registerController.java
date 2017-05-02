package com.controller.quickTest;

import com.model.quickTest.dbManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class registerController extends HttpServlet {

    public boolean teacherReg(HttpServletRequest request)throws ServletException , IOException
    {
        
        String username = request.getParameter("teacher_username");
        String name=request.getParameter("teacher_name");
        String jobDescription= request.getParameter("teacher_jobDescription");
        String email = request.getParameter("teacher_email");
        String specialization = request.getParameter("teacher_specialization");
        String qualification=request.getParameter("teacher_qualification");
        dbManager obj= new dbManager();
        int returnVal = obj.registerTeacher(username, name, jobDescription, email, specialization, qualification);
        if(returnVal !=0)
        {
            System.out.println("The request had succesfull entry into the db");
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("teacher_username") != null)
       {
           if(teacherReg(request))
           {
               response.sendRedirect("teacherDash");
           }
           else
           {
               response.sendRedirect("login");
           }
               
       }
       else if(request.getParameter("student_username") != null)
       {
           
       }
       else
       {
           System.out.println("nothing caught");
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
