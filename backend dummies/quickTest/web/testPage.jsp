<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.quickTest.test"%>
<%@page import="com.model.quickTest.student"%>
<%@page import="com.model.quickTest.dbManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/test_page.css" />" />
<script type="text/javascript" src="<c:url value="/assets/scripts/test_page.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/scripts/testPageTimer.js"/>"></script>



<% 
    dbManager dbObj = new dbManager();
    student obj =(student) request.getSession().getAttribute("user_data");
    if(obj == null){%>
        <c:redirect url="/login" />      
<%  }
    ServletContext serv = getServletContext();
    if(serv.getAttribute(request.getParameter("testId"))== null ){
    %>
       <h1 style="text-align: center; padding-top: 50px;">('._.) TEST YET TO START</h1>
<% } else{ %>
<% 
  test tobj =(test)serv.getAttribute(request.getParameter("testId"));      
  int time = tobj.getTimeInSeconds();%>
<div class="row">
            
                <div class="eight columns test random-class">
                    <div id="<%= time %>" class="00"></div>
                    <div id="time">
                            <span id="hour" class="num">00</span>
                            <span id="colon">:</span>
                            <span id="minutes" class="num">00</span>
                            <span id="colon">:</span>
                            <span id="seconds" class="num">00</span>

                        </div>
        
                    <div id="slider">
                    <a href="#" class="control_next"><i class="fa fa-chevron-right right" style="font-size:60px;color:black;"></i></a>
                    <a href="#" class="control_prev"><i class="fa fa-chevron-left left" style="font-size:60px;color:black;"></i></a></div>
                    <% ResultSet set = dbObj.getAllQuestion(tobj.getTestId()); int i=0;%> 
                <div class="questions">
                    <% while(set.next()){ i++; %>
                    <div class="question" style="display:none;">    
                        <span class="bm bm1" ><i class="fa fa-bookmark " id="bm"></i></span><br>
                        <div class="question-content">Q<%= i %>.<%= set.getString("question") %> </div>
                        <input type="radio" name="option1" value="a"> a) <%= set.getString("dummy1") %> <br>
                        <input type="radio" name="option1" value="b" >b)<%= set.getString("dummy2") %> <br>
                        <input type="radio" name="option1" value="c"> c)<%= set.getString("dummy3") %> <br>
                        <input type="radio" name="option1" value="d"> d)<%= set.getString("dummy4") %> <br>
                        <input type="radio" name="option1" value="e" style="display:none;" checked>
                    </div>
                  <% } %>
                </div>
                <div class="ques-iterators">
                    <div class="goto-ques" style="text-align: center">
                        <input type="text" class="search-ques" placeholder="Go to question number">
                        <button id="search-ques-button" type="button"><i class="fa fa-arrow-circle-right"></i></button>
                    </div>
                    
                </div>
             
                </div>
                <div class="four columns test right-side" >
                    <div class="another-random-class">
                        <div class=" row answer-panel">
                            <strong>NAME : </strong> <%=obj.getName() %> <br>
                            <strong>ROLL NUMBER. : </strong> <%= obj.getBatchYear() %>/<%= obj.getRollNo() %> <br>
                            <strong>Batch Year:</strong> <%= obj.getBatchYear() %> <br>
                            <strong>BRANCH: </strong> <%= obj.getDepartment() %> <br>
                        </div>
                    </div>
                    <div class="side" id="color_panel">
                        <strong>Title:</strong> <%= tobj.getTitle()%><br>
                        <strong>Marks:</strong> <%= tobj.getTotalMarks()%><br>
                        <strong>PassMarks:</strong><%= tobj.getPassMarks() %><br>
                        
                    </div>
    
                    <div><br><br><br>
                        <button id="submit" class="on-right submit">Submit</button>
                        


                    </div>
            </div>
            
            </div>
<% } %>
<%@include file="partials/footer.jsp" %>