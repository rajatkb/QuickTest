<%@page import="com.model.quickTest.teacher"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>

<% teacher obj = (teacher) request.getSession().getAttribute("teacher_data"); %>

<% if( obj == null){ %>
    
<c:redirect url="/login" />

<%}%>





<%@ include file="partials/footer.jsp" %>