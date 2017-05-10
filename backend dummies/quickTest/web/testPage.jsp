<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/test_page.css" />" />
<script type="text/javascript" src="<c:url value="/assets/scripts/test_page.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/scripts/testPageTimer.js"/>"></script>

<% int time = 10;%>

<div class="row">
            
                <div class="eight columns test random-class">
                    <div id="<%= time %>" class="00"></div>
                    <div id="time">
                            <span id="hour" class="num">00</span>
                            <span id="colon">:</span>
                            <span id="minutes" class="num">00</span>
                            <span id="colon">:</span>
                            <span id="seconds" class="num">00</span>

                        </div>
        
                    <div id="slider">
                    <a href="#" class="control_next"><i class="fa fa-chevron-right right" style="font-size:60px;color:black;"></i></a>
                    <a href="#" class="control_prev"><i class="fa fa-chevron-left left" style="font-size:60px;color:black;"></i></a></div>
            <form>
                <div class="questions">
                    <div class="question" style="display:none;">    
                        <span class="bm bm1" ><i class="fa fa-bookmark " id="bm"></i></span><br>
                        <div class="question-content">Q1. </div>
                        <input type="radio" name="option1" value="a"> a) <br>
                        <input type="radio" name="option1" value="b" > b) <br>
                        <input type="radio" name="option1" value="c"> c) <br>
                        <input type="radio" name="option1" value="d"> d) <br>
                        <input type="radio" name="option1" value="e" style="display:none;" checked>
                    </div>
                    </form>
                    <div class="question" style="display:none;">
                       
                        
                        <span class="bm bm1" ><i class="fa fa-bookmark " id="bm"></i></span><br>
                        <div class="question-content">Q2. </div>
                        <input type="radio" name="option2" value="a"> a) <br>
                        <input type="radio" name="option2" value="b" > b) <br>
                        <input type="radio" name="option2" value="c"> c) <br>
                        <input type="radio" name="option2" value="d"> d) <br>
                        <input type="radio" name="option2" value="e" style="display:none;" checked>
                    </div>
                    
                    <div class="question" style="display:none;">
                       
                        
                        <span class="bm bm1" ><i class="fa fa-bookmark " id="bm"></i></span><br>
                        <div class="question-content">Q3. </div>
                        <input type="radio" name="option3" value="a"> a) <br>
                        <input type="radio" name="option3" value="b" > b) <br>
                        <input type="radio" name="option3" value="c"> c) <br>
                        <input type="radio" name="option3" value="d"> d) <br>
                        <input type="radio" name="option3" value="e" style="display:none;" checked>
                    </div>
                </div>
            
                <div class="ques-iterators">
                    
                    <div class="goto-ques" style="text-align: center">
                        <input type="text" class="search-ques" placeholder="Go to question number">
                        <button id="search-ques-button" type="button"><i class="fa fa-arrow-circle-right"></i></button>
                    </div>
                    
                </div>
             
                </div>
                <div class="four columns test right-side" >
                    
                    <div class="another-random-class">
                    
                        <div class=" row answer-panel">
                            <strong>NAME : </strong>AAAA AAAA <br>
                            <strong>ROLL NUMBER. : </strong>15/313 <br>
                            <strong>SEMESTER:</strong> THIRD <br>
                            <strong>BRANCH: </strong>CSE <br>
                            
                            
                           
                            
                            
                        </div>
                    
                       
                    </div>
                    <br>
                    <div class="side" id="color_panel">
                    
                        <strong>SUBJECT: </strong>FLAT
                        
                    </div>
    
                    <div><br><br><br>
                        <button id="submit" class="on-right submit">Submit</button>
                        


                    </div>
            </div>
            
            </div>

<%@include file="partials/footer.jsp" %>