<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/login_styles.css" />" />
<script type="text/javascript" src="<c:url value="/assets/scripts/login_script.js"/>"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/warning.css" />" />
<script type="text/javascript" src="<c:url value="/assets/scripts/warning.js"/>"></script>
<div class="mega-container">
    <% String warn = String.valueOf(request.getSession().getAttribute("warn"));
       if(warn != "null"){%>
        <div class="message-container">
            <span><%= warn %></span>
        </div>
    <%}%>
        <div class="login-main-container">
            <form method="post" action="loginController"i d="login-teacher-form">
                <input name="teacher_username" type="text" placeholder="Username or email ID" /><br>
                <input name="teacher_password" type="password" placeholder="Password"><br>
                <button type="submit" class="login-teacher">Login as teacher <span class="fa fa-arrow-right"></span></button>
            </form>
            <form method="post" action="loginController" id="login-student-form">
                <input name="student_username" type="text" placeholder="Username or email ID" /><br>
                <input name="student_password" type="password" placeholder="Password"><br>
                <button type="submit" class="login-student">Login as student <span class="fa fa-arrow-right"></span></button>
            </form>
        </div>
       <div class="register-main-container">
                <form method="post" action="registerController" id="register-teacher-form">
                    <input required name="teacher_name" type="text" placeholder="Name" /><br>
                    <input required name="teacher_email" type="text" placeholder="Email ID" /><br>
                    <input required name="teacher_username" type="text" placeholder="Username" /><br>
                    <input required name="teacher_password" type="password" placeholder="Password"/><br>
                    <input required name="teacher_jobDescription" type="text" placeholder="JobDescription"/><br>
                    <input required name="teacher_qualification" type="text" placeholder="Qualification" /><br>
                    <input required name="teacher_specialization" type="text" placeholder="Specialization" /><br>
		    <button class="register-teacher">Register as teacher <span class="fa  fa-angle-right"></span> </button>
                </form>
                <form method="post" action="registerController" id="register-student-form">
                    <input required name="student_name" type="text" placeholder="Name" /><br>
                    <input required name="student_email" type="text" placeholder="Email ID" /><br>
                    <input required name="student_username" type="text" placeholder="Username" /><br>
                    <input required name="student_password" type="password" placeholder="Password"><br>
                    <input required name="student_rollno" type="number" placeholder="Roll number" /><br>
                    <input required name="student_batchYear" type="number" placeholder="Batch year" /><br>
                    <select required name="student_depCode">
                        <option>Select Department</option>
                        <option value="2"> ETE </option>
                        <option value="3"> ME  </option>
                        <option value="1"> CSE </option>
                        <option value="4"> EE  </option>
                        <option value="5"> CE  </option>
                        <option value="6"> CHE </option>
                        <option value="7"> IP  </option>
                        
                    </select><br>
                    <button class="register-student">Register as student <span class="fa  fa-angle-right"></span> </button>
                </form>
        </div>
  </div>	

<%@ include file="partials/footer.jsp"%>    

