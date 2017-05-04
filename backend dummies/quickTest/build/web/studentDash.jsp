<%@page import="com.model.quickTest.student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/upcoming_page.css" />" />
<script type="text/javascript" src="<c:url value="/assets/scripts/upcoming_page.js"/>"></script>

<% student obj =(student) request.getSession().getAttribute("user_data"); %>
<% if(obj == null){%>
    <c:redirect url="/login" />
<%}%>

<div class="containerdiv up-test">
        <span class="text">UPCOMING TESTS</span>
        <div class="row">
            <div class="four columns test "><div>Test 1</div>
                    <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br> 
                    </div>
                    
            </div>
                <div class="four columns test ">Test 2
                   <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br>
                    
                    
                    </div>
                     
            </div>
            <div class="four columns test ">Test 3
                    <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br>
                </div>
                    
            </div>
            
            </div>
            <div class="row">
                <div class="four columns test ">Test 3
                    <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br>
                </div>
                    
            </div>
            
            <div class="four columns test ">Test 3
                    <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br>
                </div>
                    
            </div>
            
            <div class="four columns test">Test 3
                    <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br>
                </div>
                    
            </div>
            </div>    
        </div>
        
<div class="containerdiv prev-test">
        <span class="text">PREVIOUS TESTS</span>
        <div class="row">
                <div class="four columns test test2">Test 1
                    <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br>
                </div>
                    
            </div>
                <div class="four columns test test2">Test 1
                    <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br>
                </div>
            </div>
            <div class="four columns test test2">Test 1
                    <div class="db">
                        Date of Test: 00/00/0000<br>
                        Name of the teacher: Aaaaaa aaaaaa<br>
                        Full Marks: 000<br>
                        Pass Marks: 00<br>
                </div>
            
            </div>
</div>



<%@include file="partials/footer.jsp" %>