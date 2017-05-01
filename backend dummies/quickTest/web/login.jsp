<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/login_styles.css" />" />
 <script type="text/javascript" src="<c:url value="/assets/scripts/login_script.js"/>"></script>

<div class="form-container">
        <div class="login-main-container">
            <form method="post" id="login-teacher-form">
                <input name="login_tch[username]" type="text" placeholder="Username or email ID" /><br>
                <input name="login_tch[password]" type="password" placeholder="Password"><br>
                <button id="login-teacher">Login as teacher</button>
            </form>
            <form method="post" id="login-student-form">
                <input name="login_stu[username]" type="text" placeholder="Username or email ID" /><br>
                <input name="login_stu[password]" type="password" placeholder="Password"><br>
                <button id="login-student">Login as student</button>
            </form>
        </div>
        <div class="register-main-container">
                <form method="post" id="register-teacher-form">
                    <input name="reg_tch[name]" type="text" placeholder="Name" /><br>
                    <input name="reg_tch[email]" type="text" placeholder="Email ID" /><br>
                    <input name="reg_tch[username]" type="text" placeholder="Username" /><br>
                    <input name="reg_tch[password]" type="password" placeholder="Password"><br>
                    <input name="reg_tch[cnf_pass]" type="password" placeholder="Confirm password"><br>
                    <input name="reg_tch[desg]" type="text" placeholder="Designation" /><br>
                    <input name="reg_tch[qual]" type="text" placeholder="Qualification" /><br>
                    <input name="reg_tch[specs]" type="text" placeholder="Specialization" /><br>
                    <button id="register-teacher">Register as teacher</button>
                </form>
                <form method="post" id="register-student-form">
                    <input name="reg_stu[name]" type="text" placeholder="Name" /><br>
                    <input name="reg_stu[email]" type="text" placeholder="Email ID" /><br>
                    <input name="reg_stu[username]" type="text" placeholder="Username" /><br>
                    <input name="reg_stu[password]" type="password" placeholder="Password"><br>
                    <input name="reg_stu[cnf_pass]" type="password" placeholder="Confirm password"><br>
                    <input name="reg_stu[roll_no]" type="text" placeholder="Roll number" /><br>
                    <input name="reg_stu[batch]" type="text" placeholder="Batch year" /><br>
                    <input name="reg_stu[dept]" type="text" placeholder="Department" /><br>
                    <button id="register-student">Register as student</button>
                </form>
        </div>
    </div>

<%@ include file="partials/footer.jsp"%>    

