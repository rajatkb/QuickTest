package com.controller.quickTest;

import com.model.quickTest.dbManager;
import com.model.quickTest.teacher;
import com.model.quickTest.test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class testInteract extends HttpServlet {

    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("AJAX receved for new test");
        if( String.valueOf(request.getSession().getAttribute("user_data").getClass().getSimpleName()).equals("teacher")) 
        {
            dbManager obj = new dbManager();
            int testId = obj.addTest(request, response);
            response.getWriter().print(String.valueOf(testId));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("AJAX receved for deleting test");
        if( String.valueOf(request.getSession().getAttribute("user_data").getClass().getSimpleName()).equals("teacher")) 
        {
            
            dbManager obj = new dbManager();
            try{
                int testId = Integer.parseInt(request.getParameter("testId"));
                System.out.println(testId);

                obj.deleteTest(testId);
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            
        }
        
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
