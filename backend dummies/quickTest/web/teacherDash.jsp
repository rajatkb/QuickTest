<%@page import="com.model.quickTest.teacher"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>

<% if(request.getSession().getAttribute("teacher_data") == null){ %>
    
<c:redirect url="/login.jsp" />

<%}%>

<%@ include file="partials/footer.jsp" %>