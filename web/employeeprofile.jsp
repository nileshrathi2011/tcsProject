<%-- 
    Document   : employeeprofile
    Created on : 24 Apr, 2017, 6:32:41 PM
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
            .employee_profile
            {
             background-color: #ffffff;    
            }
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

   <div class="employee_profile">
    <div class="employee_basic_ profile container" >
         <h2>Welcome ${emp.name}</h2>
        
            <h3>Nam: <small>${emp.name}</small></h3>
            <h3>DOB: <small>${emp.dob}</small></h3>
            <h3>College: <small>${emp.college}</small></h3>
            <h3>E-mail: <small>${emp.email}</small></h3>
            <h3>Resume: <small><a href=${emp.resume}>${emp.resume}</a></small></h3>
            
    </div>
            <div align="right">
                <a href="editEmployee.jsp" class="btn btn-primary" role="button">Edit Profile</a>
            </div>

    <div calss="employee_application_status container">
        
        <h2 align="center">
           Applications 
        </h2>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <table class="table table-striped " align="center">
            <thead>
                <tr>
                    <th><h3>Company Name</h3></th>
                    <th><h3>Application Status</h3></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${empStatList}" var="empStat">
              <tr>
                <td><h4><c:out value="${empStat.companyName}" /></h4></td>
                <td><h4><c:out value="${empStat.status}" /></h4></td>
              </tr>
            </c:forEach>
            </tbody>
        </table>
    
    </div>
   </div>
        
    </body>
</html>
