<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/login_styles.css" />" />
<script type="text/javascript" src="<c:url value="/assets/scripts/login_script.js"/>"></script>

<div class="mega-container">
        <div class="login-main-container">
            <form method="post" id="login-teacher-form">
                <input name="login_tch[username]" type="text" placeholder="Username or email ID" /><br>
                <input name="login_tch[password]" type="password" placeholder="Password"><br>
				<button type="button" class="login-teacher">Login as teacher <span class="fa fa-arrow-right"></span></button>
            </form>
            <form method="post" id="login-student-form">
                <input name="login_stu[username]" type="text" placeholder="Username or email ID" /><br>
                <input name="login_stu[password]" type="password" placeholder="Password"><br>
                <button type="button" class="login-student">Login as student <span class="fa fa-arrow-right"></span></button>
            </form>
        </div>
       <div class="register-main-container">
                <form method="post" action="registerController" id="register-teacher-form">
                    <input name="teacher_name" type="text" placeholder="Name" /><br>
                    <input name="teacher_email" type="text" placeholder="Email ID" /><br>
                    <input name="teacher_username" type="text" placeholder="Username" /><br>
                    <input name="teacher_password" type="password" placeholder="Password"><br>
                    <input name="teacher_jobDescription" type="text" placeholder="JobDescription" /><br>
                    <input name="teacher_qualification" type="text" placeholder="Qualification" /><br>
                    <input name="teacher_specialization" type="text" placeholder="Specialization" /><br>
					<button class="register-teacher">Register as teacher <span class="fa  fa-angle-right"></span> </button>
                </form>
                <form method="post" action="registerController" id="register-student-form">
                    <input name="student_name" type="text" placeholder="Name" /><br>
                    <input name="student_email" type="text" placeholder="Email ID" /><br>
                    <input name="student_username" type="text" placeholder="Username" /><br>
                    <input name="student_password" type="password" placeholder="Password"><br>
                    <input name="student_rollno" type="text" placeholder="Roll number" /><br>
                    <input name="student_batchYear" type="text" placeholder="Batch year" /><br>
                    <select name="student_depCode">
                        <option vlaue="1">C.S.E</option>
                        <option value="2">ETE</option>
                        <option value="3">ME</option>
                        <option value="4">EE</option>
                        <option value="5">CE</option>
                        <option value="6">CHE</option>
                        <option value="7">IP</option>
                    </select><br>
                    <button class="register-student">Register as student <span class="fa  fa-angle-right"></span> </button>
                </form>
        </div>
  </div>	

<%@ include file="partials/footer.jsp"%>    

