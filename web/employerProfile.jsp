<%-- 
    Document   : employerProfile
    Created on : 28 Apr, 2017, 3:14:58 PM
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
            .employer_profile
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


    <div class="employer_profile">
    <div class="employer_basic_ profile container" >
         <h2>Welcome ${employer.name}</h2>
        
            <h3>Name: <small>${employer.name}</small></h3>
            <h3>Comapny Name: <small>${employer.company}</small></h3>
            <h3>Job Profile: <small>${employer.profile}</small></h3>
            <h3>Skills: <small style = "white-space:PRE" >${employer.skills}</small>
            <h3>Company Website: <small>${employer.website}</small></h3>
            <h3>E-mail: <small>${employer.email}</small></h3>
            
    </div>
            <div align="right">
                <a href="editEmployer.jsp" class="btn btn-primary" role="button">Edit Profile</a>
            </div>

    <div calss="applicant_list container">
        
        <h2 align="center">
           Applications 
        </h2>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <table class="table table-striped " align="center">
            <thead>
                <tr>
                    <th><h3>Name</h3></th>
                    <th><h3>College</h3></th>
                    <th><h3>Resume</h3></th>
                    <th><h3>Status</h3></th>
                    <th><h3>Action</h3></th>
                    
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${applicantList}" var="applicant">
              <tr>
                <td><h4><c:out value="${applicant.name}" /></h4></td>
                <td><h4><c:out value="${applicant.college}" /></h4></td>
                <td><h4><c:out value="${applicant.resume}" /></h4></td>
                <td><h4><c:out value="${applicant.status}" /></h4></td>
                        <td><form action="ChangeStatus" method="get">
                               <input type="hidden" name="applicantId" value="${applicant.employeeId}" />
                               <input type="submit"  class="btn btn-success" name="action" value="shortlist"/>
                               <input type="submit"  class="btn btn-danger" name="action" value="reject"/>
                            </form>
                        </td>
              </tr>
            </c:forEach>
            </tbody>
        </table>
    
    </div>
   </div>


    </body>
</html>
