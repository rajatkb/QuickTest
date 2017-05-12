
package com.businessLogic.quickTest;

import com.model.quickTest.test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class performa extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(String.valueOf(request.getSession().getAttribute("user_data").getClass().getSimpleName()).equals("student"))
        {
            try{
            String responseText = request.getParameter("answerScript");
            int testId = Integer.parseInt((String)request.getSession().getAttribute("testId"));
            test testObj = (test)getServletContext().getAttribute(String.valueOf(testId));
            request.getSession().removeAttribute("testId");
            utility util = new utility();
            float marks = util.calcMarks( testObj.getAnswerScript() , responseText, testObj.getMarksPerQuestion() );
            
            
            }
            catch(Exception ex)
            {
                System.out.println("performa error:"+ ex);
            }
            
        }
        else{
            response.sendRedirect("login");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
