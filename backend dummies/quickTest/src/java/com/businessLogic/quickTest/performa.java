
package com.businessLogic.quickTest;

import com.model.quickTest.dbManager;
import com.model.quickTest.student;
import com.model.quickTest.test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class performa extends HttpServlet {

    dbManager dbObj = new dbManager();
    
    // FOR TEACHERDASH PAGE
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String toBeSent="";
        toBeSent+= dbObj.getPerforma(Integer.parseInt(request.getParameter("testId")));
        System.out.println(toBeSent);
        response.getWriter().print(toBeSent);
    }

    // FOR STUDENT MARKSHEET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(String.valueOf(request.getSession().getAttribute("user_data").getClass().getSimpleName()).equals("student"))
        {
            try{
            String responseText = request.getParameter("answerScript");
            test testObj = (test)request.getSession().getAttribute("test");
            student studObj = (student)request.getSession().getAttribute("user_data");
            System.out.println("Answer by"+ studObj.getName()+":"+responseText);
            int testId = testObj.getTestId();
            int studentId = studObj.getStudentId();
            utility util = new utility();
            float marks = util.calcMarks( testObj.getAnswerScript() , responseText, testObj.getMarksPerQuestion());
            String remark = marks >= testObj.getPassMarks() ? "PASS":"FAIL";
            dbObj.setPerforma(responseText, marks, remark, studentId, testId);
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
