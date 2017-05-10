<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.quickTest.dbManager"%>
<%@page import="com.model.quickTest.student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/upcoming_page.css" />" />
<script type="text/javascript" src="<c:url value="/assets/scripts/upcoming_page.js"/>"></script>

<% 
    dbManager dbObj = new dbManager();
    student obj =(student) request.getSession().getAttribute("user_data");
    if(obj == null){%>
    <c:redirect url="/login" />
<%}%>

 <div id="profile" class="profile" style="display:none">
    <div id="sem"><strong>Name:</strong><%= obj.getName() %></div>
     <div id="sem"><strong>BatchYear:</strong> <%= obj.getBatchYear() %></div>
    <div id="branch"><strong>Branch:</strong> <%= obj.getDepartment() %> </div>
    <div id="roll"><strong>Roll No:</strong> <%= obj.getBatchYear() %>/<%= obj.getRollNo() %> </div>
</div>

<div class="containerdiv up-test">
        <span class="text">UPCOMING TESTS</span>
        <% ResultSet set = dbObj.getAllTest( obj.getDepCode() , obj.getBatchYear()); %>
        <div class="row">
            <% while( set.next() ){ if( ! set.getBoolean("finished") ){ %>
            <div class="four columns test ">
                <div><%= set.getString("title") %></div>
                    <div class="db">
                        Date of Test: <%= set.getString("scheduledDate")%><br>
                        Alloted Time: <%= set.getString("allotedTime")%> Minutes<br>
                        Full Marks: <%= set.getString("totalMarks")%> <br>
                        Pass Marks: <%= set.getString("passMarks") %> <br> 
                    </div>
            </div>
            <% } } %>
            </div>
            <div class="row"></div>    
        </div>
        
<div class="containerdiv prev-test">
        <span class="text">PREVIOUS TESTS</span>
        <div class="row">
        
            <% while( set.next() ){ if( set.getBoolean("finished") ){ %>
            <div class="four columns test ">
                <div><%= set.getString("title") %></div>
                    <div class="db">
                        Date of Test: <%= set.getString("scheduledDate")%><br>
                        Alloted Time: <%= set.getString("allotedTime")%> Minutes<br>
                        Full Marks: <%= set.getString("totalMarks")%> <br>
                        Pass Marks: <%= set.getString("passMarks") %> <br> 
                    </div>
            </div>
            <% } } %>
        
        
        </div>



<%@include file="partials/footer.jsp" %>