package com.controller.quickTest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class registerController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("teacher_username") != null)
       {
           System.out.println(request.getParameter("teacher_username"));
       }
       else if(request.getParameter("student_username") != null)
       {
           System.out.println(request.getParameter("student_username"));
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
