<%@page import="com.businessLogic.quickTest.utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.quickTest.dbManager"%>
<%@page import="com.model.quickTest.teacher"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/dashboard_teacher_mobile.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/dashboard_teacher_styles.css" />" />
<script type="text/javascript" src="<c:url value="/assets/scripts/dashboard_teacher_scripts.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/scripts/new_test_scripts.js"/>"></script>
<% teacher obj = (teacher) request.getSession().getAttribute("user_data"); 
   dbManager dbObj =new dbManager(); 
   utility util = new utility();
%>

<% if( obj == null){ %>
    
<c:redirect url="/login" />

<%}%>


<div class="ultra-container">
        <div class="main-container">
            <div class="teacher-info">
                    <h3 id="teacher-name"><%= obj.getName() %></h3>
                    <span id="username"><%= obj.getUsername() %></span><br>
                    <span id="email"><%= obj.getEmail() %></span><br><br>
                    <span id="job-desc"><%= obj.getJobDescription() %></span><br>
                    <span id="qualification"><%= obj.getQualification() %></span><br>
                    <span id="specs"><strong>Specialization: </strong><%= obj.getSpecialization() %></span><br>
                    <div class="profile-controls">
                        <button class="form-button" id="update-info-button">Update your info</button>
                    </div>
            </div>
             <div class="update-info-form">
                 <form method="get" action="registerController" id="update-info-form">
                    <h4 id="teacher-name"><%= obj.getUsername() %></h4>
                    <span><%= obj.getEmail() %></span><br><br>
                    <div class="row">
                        <span class="update-info-labels">Name: </span><input type="text" name="new_name" value="<%= obj.getName() %>"><br>
                            <span class="update-info-labels">Designation: </span><input type="text" name="new_desg" value="<%= obj.getJobDescription() %>"><br>
                            <span class="update-info-labels">Qualification: </span><input type="text" name="new_qual" value="<%= obj.getQualification() %>"><br>
                            <span class="update-info-labels">Specialization: </span><input type="text" name="new_specs" value="<%= obj.getSpecialization() %>"><br>
                    </div>
                    <button type="submit" class="form-button" id="save-info-button" style="background: #8D6E63">Save</button>
                </form>
            </div>
            <button class="new-test" id="new-test-button">                
                <h5>organize a new test</h5>
                <i id="plus-circle" class="fa fa-3x fa-plus-circle" style="margin: 4px"></i>
            </button>
            <div class="test-list">
                <% ResultSet set = dbObj.getAllTest( obj.getID() );
                   while(set.next()){ %>
                        <% if(set.getBoolean("finished")){%>
                            <div class="test-list-item test-conducted" id="test<%= set.getString("testId") %>">
                        <% } else { %>       
                            <div class="test-list-item test-submitted" id="test<%= set.getString("testId") %>">
                        <% } %>    
                            <div class="test-title">
                                <h5> <%= set.getString("title") %> </h5>
                            </div>
                            <div class="test-info">
                                <p> <%= set.getString("description") %> </p>
                                <span class="test-info-labels">Scheduled date of examination: </span><span> <%= set.getString("scheduledDate") %></span> <br>
                                <span class="test-info-labels">Department: </span><span> <%= util.mapDepCode( set.getInt("depCode"))  %></span> <br>
                                <span class="test-info-labels">Batch: </span><span><%= set.getString("batchYear") %></span> <br>
                                <span class="test-info-labels">Maximum marks: </span><span><%= set.getString("totalMarks") %> </span> <br>
                            </div>
                            <div class="controls">
                                <% if(set.getBoolean("finished")){%>
                                    <button class="get-test-review"><i class="fa fa-3x fa-hourglass-start"></i>Get test review</button>
                                <% } else { %>       
                                    <button class="start-test"><i class="fa fa-3x fa-hourglass-start"></i>Start now</button>
                                <% } %>
                                <button class="delete-test"><i class="fa fa-3x fa-trash-o"></i>Delete</button>
                            </div>        
                        </div>
                <% }%>
                
            </div>
            <div class="ongoing-test-info">
                <div class="test-title"><h5 id="ongoing-test-title">Test title</h5></div>
                <span id="ongoing-test-desc">This test has been described by you as this</span><br>
                <strong>Department: </strong><span id="ongoing-test-dept">CSE</span><br>
                <strong>Semester: </strong><span id="ongoing-test-sem">IV</span><br>
                <strong>Full marks: </strong><span id="ongoing-test-full-marks">100</span><br>
                <strong>Passing marks: </strong><span id="ongoing-test_pass-marks">30</span><br>
                <strong>Duration: </strong><span id="ongoing-test_duration">3 hours</span><br>
                <strong>Time left: </strong><h1 id="ongoing-test-time-left">3:00:00</h1>
                <div class="close-this"><button type="button" class="form-button escape-start-test"><i class="fa fa-window-close"></i>Close</button></div>
            </div>
            <div class="delete-test-conf">
                <h5>Are you sure you want to delete this test?</h5>
                <button class="delete-test-yes"><i class="fa fa-2x fa-check-square"></i>Yes</button>
                <button class="delete-test-no"><i class="fa fa-2x fa-window-close"></i>No</button>
            </div>
        </div>
        <div class="grand-container">
        </div>
        <div class="dummy-grand">
            <div class="new-test-form">
                <div class="row" style="padding-bottom: 5px">
                    <div class="eight columns"><span style="font-size: 30px; vertical-align: middle">You're about to organize a new test:</span></div>
                    <div class="four columns close-this"><button type="button" class="form-button escape-test-form-button"><i class="fa fa-window-close"></i>Close</button></div>
                </div>
                
            <form method="post">
                <input type="text" class="form-item" id="test_title" name="newtest_title" placeholder="Title for the test" required/>
                <textarea class="form-item" name="newtest_description" placeholder="Add a description" required></textarea>
                <hr>
                <div class="row">
                    <div class="six columns">
                        <input pattern="(?:20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" type="text" class="form-item" name="newtest_date" placeholder="Scheduled date (yyyy-mm-dd)" required/>
                    </div>
                    <div class="six columns">
                        <input type="number" min="1" id="test_duration" class="form-item" name="newtest_duration" placeholder="Duration (in minutes)" required/>
                    </div>
                </div>
                <div class="row">
                    <div class="six columns">
                        <select class="form-item" name="newtest_department" required>
                            <option value="" disabled selected hidden>Department</option>
                            <option value="6">Chemical</option>
                            <option value="5">Civil</option>
                            <option value="1">Computer Science</option>
                            <option value="4">Electrical</option>
                            <option value="2">Electronics & Telecommunications</option>
                            <option value="7">Industry & Production</option>
                            <option value="3">Mechanical</option>
                        </select>
                    </div>
                    <div class="six columns">
                        <select class="form-item" name="newtest_batch_year" required>
                            <option value="" disabled selected hidden>Batch year</option>
                            <option value="14">2014</option>
                            <option value="15">2015</option>
                            <option value="16">2016</option>
                            <option value="17">2017</option>
                        </select>
                    </div>
                </div>       
                <div class="row">
                    <div class="six columns">
                        <input type="number" min="1" class="form-item" id="test_full_marks" name="newtest_full_marks" placeholder="Full marks" required/>
                    </div>
                    <div class="six columns">
                        <input type="number" min="1" class="form-item" id="test_pass_marks" name="newtest_pass_marks" placeholder="Passing marks" required/>
                    </div>
                </div>
                <hr>
                <div class="question" id="question1">
                    <input class="form-item qs_title" name="qs_1" placeholder="Enter question 1" required/>
                    <div class="row">
                        <div class="six columns">
                            <input class="form-item" name="qs_1_choice_1" placeholder="A" required/>
                        </div>
                        <div class="six columns">
                            <input class="form-item" name="qs_1_choice_2" placeholder="B" required/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="six columns">
                            <input class="form-item" name="qs_1_choice_3" placeholder="C" required/>
                        </div>
                        <div class="six columns">
                            <input class="form-item" name="qs_1_choice_4" placeholder="D" required/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="six columns">
                            <select class="form-item" name="answer" required>
                                <option value="" disabled selected hidden>Correct choice</option>
                                <option value="a">A</option>
                                <option value="b">B</option>
                                <option value="c">C</option>
                                <option value="d">D</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="more-qs-container"></div>
                <hr>
                <div class="row ques-iterators">
                    <div class="three columns prev-ques"><button type="button" class="form-button prev-qs-button" id="prev-qs-btn"><i class="fa fa-arrow-circle-left"></i> Previous </button></div>
                    <div class="six columns goto-ques" style="text-align: center">
                        <input type="text" id="search-ques" placeholder="Go to question number">
                        <button id="search-ques-button" type="button"><i class="fa fa-arrow-circle-right"></i></button>
                    </div>
                    <div class="three columns next-ques"><button type="button" class="form-button next-qs-button" id="next-qs-btn"><i class="fa fa-arrow-circle-right"></i> Next </button><br></div>
                </div>
                <div style="text-align: center"><button type="button" class="form-button more-qs-button" id="add-qs-btn">Add more questions <i class="fa fa-plus-circle"></i></button></div>
                <hr>
                <div class="form-controls">
                    <button type="button" class="form-button submit-button" id="submit-new-test">Submit</button>
                </div>
            </form>
        </div>
        </div>        
        </div>
</div>




<%@ include file="partials/footer.jsp" %>