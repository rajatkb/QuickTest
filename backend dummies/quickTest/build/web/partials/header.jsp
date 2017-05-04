<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Muli|Lato|Asar" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/lib/font-awesome-4.7.0/css/font-awesome.min.css" />">
        <script src="<c:url value="/assets/lib/jquery/jquery-3.2.0.min.js" />" ></script>
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/navbar_styles.css" />" />
        <script type="text/javascript" src="<c:url value="/assets/scripts/nav.js"/>"></script>
    </head>
    <body>
        <nav>
        <span class="qt">
            <span class="q">Q</span>uick Test
        </span>
        
	<span class="toggle">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
	</span>
        
        <ul class="list-item">
          <%
              if( request.getServletPath().equals("/login.jsp"))
              {      
                  out.println("<li  class=\"on-right\"><button id=\"register\" >Register</button></li>");
              }
              else
              { 
                  out.println("<li class=\"on-right\"><button><a href=\"logout\">LogOut</a></button></li>");
              }
          %>
        </ul>
            
      </nav>