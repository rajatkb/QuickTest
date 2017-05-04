<%@page import="com.model.quickTest.student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp" %>
<% student obj =(student) request.getSession().getAttribute("user_data"); %>
<% if(obj == null){%>
    <c:redirect url="/login" />
<%}%>
<h1>Hi <%= obj.getName() %></h1>
<%@include file="partials/footer.jsp" %>