package com.controller.quickTest;

import com.model.quickTest.dbManager;
import com.model.quickTest.teacher;
import com.model.quickTest.test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class testInteract extends HttpServlet {

    
    
    //USED FOR GETTING THE TIME OF THE INDIVIDUAL TEST
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(String.valueOf(request.getSession().getAttribute("user_data").getClass().getSimpleName()).equals("teacher"))
        {
            int time;
            ServletContext testLoad = getServletContext();
            int testId = Integer.parseInt(request.getParameter("testId"));
            if(testLoad.getAttribute(String.valueOf(testId)) == null)
            {
                dbManager obj = new dbManager();
                test tobj = obj.getTest(testId);
                time = tobj.getTimeInSeconds();
                
            }else{
                test tobj = (test) testLoad.getAttribute(String.valueOf(testId));
                time = tobj.getTimeInSeconds();
            }
            response.getWriter().print(time);
            
        }
        else
        {    
            response.sendRedirect("login");
        }   
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("AJAX receved for new test");
        if( String.valueOf(request.getSession().getAttribute("user_data").getClass().getSimpleName()).equals("teacher")) 
        {
            dbManager obj = new dbManager();
            int testId = obj.addTest(request, response);
            obj.insertTestForAllStudents(testId);
            System.out.println("Commiteing test with index:"+testId);
            response.getWriter().print(testId);
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
