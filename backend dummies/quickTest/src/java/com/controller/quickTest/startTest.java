package com.controller.quickTest;

import com.model.quickTest.dbManager;
import com.model.quickTest.test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class startTest extends HttpServlet {
    
    dbManager obj = new dbManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(String.valueOf(request.getSession().getAttribute("user_data").getClass().getSimpleName()).equals("teacher"))
        {
            ServletContext testLoad = getServletContext();
            int testId = Integer.parseInt(request.getParameter("testId"));
            if(testLoad.getAttribute(String.valueOf(testId)) == null)
            {   
                test tobj = obj.getTest(testId);
                testLoad.setAttribute(String.valueOf(testId), tobj);
                tobj.startTimer(testLoad);
                response.getWriter().print("ok");
            }    
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
