<!--SELECT * FROM employer where id not in ( select cmp_id from status where status.emp_id='1')-->
<%-- 
    Document   : openings
    Created on : 2 May, 2017, 4:04:06 PM
    Author     : nilesh rathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
            <link rel="stylesheet" type="text/css" href="styles/main.css">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <title>Job Portal</title>
            <style>
            
            body{
                background-color: white;
            }
          </style>
    </head>
    <body>
           <div class="header">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Job Portal</a>
    </div>
    <ul class="nav navbar-nav">
      <!--<li><a href="index.jsp">Home</a></li>-->
      <li><a href="OpeningsServlet">Companies</a></li>
      <li><a href="adminLogin.jsp">Admin</a></li>
      
    </ul>
      <ul class="nav navbar-nav navbar-right">
      
      <li><a href="javascript:void(0)" onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">Register</a></li>
      <li><a href="index.jsp" >Login</a>
      <li>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          <c:if test="${pageContext.request.getSession(false) != null}">
              <a href="InvalidateSession">Logout</a> 
          </c:if>
      </li>
    </ul>
  </div>
</nav>
</div>
        
        
        <div class="message" align="center"><h4>${message}</h4></div>
    	<div class="openings_list">
    		<h2 align="center">Apply For Position</h2>
    		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <table class="table table-striped " align="center">
        	<thead>
                <tr>
                    <th><h3>Organization</h3></th>
                    <th><h3>Profile</h3></th>
                    <th><h3>Skills</h3></th>
                    <th><h3>Website</h3></th>
                    <th><h3></h3></th>
                    
                </tr>

            </thead>
            <tbody>
            <c:forEach items="${employer_list}" var="employer">
              <tr>
                <td><h4><c:out value="${employer.company}" /></h4></td>
                <td><h4><c:out value="${employer.profile}" /></h4></td>
                <td><h4><c:out value="${employer.skills}" /></h4></td>
                <td><h4><c:out value="${employer.website}" /></h4></td>
                        <td><form action="ApplyForPosition" method="get">
                               <input type="hidden" name="employerId" value="${employer.id}" />
                               <input type="submit"  class="btn btn-success" name="action" value="Apply Now"/>
                               
                            </form>
                        </td>
              </tr>
            </c:forEach>
            </tbody>
        </table>

    	</div>

    </body>
</html>

