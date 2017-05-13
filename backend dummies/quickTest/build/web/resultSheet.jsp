<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.quickTest.dbManager"%>
<%@page import="com.model.quickTest.test"%>
<%@page import="com.model.quickTest.student"%>
<%@include file="partials/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/styles/marksheet.css" />" />
<%
student studobj =(student) request.getSession().getAttribute("user_data");
if(studobj == null){%>
        <c:redirect url="/login" />
<%}
  int studentId = studobj.getStudentId();
  int testId =Integer.parseInt( request.getParameter("testId"));
  dbManager dbObj = new dbManager();
  test testobj = dbObj.getTest(testId);
  ResultSet set = dbObj.getPerforma(studentId, testId);
  set.next();
  String answerScript = testobj.getAnswerScript();
  String responseString = set.getString("response");
%>



<div class=marksheet>YOUR MARKS PERFORMA</div>
        <div class="table">
            <table>
              <tr>
                <th>QUESTION NO</th>
                <th>CORRECT ANSWER</th>
                <th>YOUR RESPONSE</th>
              </tr>
              <%for(int i=0; i< answerScript.length();i++){ %>
                <tr>
                  <td style="font-size: 20px"><%= (i+1)%></td>
                  <td style="font-size: 20px"><%= answerScript.charAt(i) %></td>
                  <% if(responseString.charAt(i) == 'e'){ %>
                    <td style="font-size: 20px">nill</td>
                  <% }else{ %>
                    <td style="font-size: 20px"><%= responseString.charAt(i)  %></td>
                  <% } %>
                </tr>
              <% } %>
            </table>

        
        </div>
        <button type="button" class="pdf">Save as PDF</button>

        <div class="row">
            <div class="eight columns">
                <div class="score-holder"> <span class="score "><strong>YOUR SCORE:  </strong><%= set.getString("marks") %></span><br><br>
                    
                    <span class="score"><strong>REMARKS: </strong> <%= set.getString("remark") %></span>
                </div>
            
            
            </div>
            <div class ="four columns score">
                <span class="marks"><strong>FULL MARKS: </strong> <%= testobj.getTotalMarks() %> </span><br>
                <span class="marks"><strong>PASS MARKS:  </strong> <%= testobj.getPassMarks() %> </span>
            </div>
        
        
        </div>
<%@include file="partials/footer.jsp" %>        