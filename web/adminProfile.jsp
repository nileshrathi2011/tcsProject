<%-- 
    Document   : adminProfile
    Created on : 2 May, 2017, 10:27:06 PM
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
          
          <div class="employee_list">
              <h4>Employees List</h4>
              <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <table class="table table-striped " align="center">
        	<thead>
                <tr>
                    <th><h3>Id</h3></th>
                    <th><h3>Name</h3></th>
                    <th><h3>College</h3></th>
                    
                    <th><h3></h3></th>
                    
                </tr>

            </thead>
            <tbody>
            <c:forEach items="${employeeList}" var="employee">
              <tr>
                <td><h4><c:out value="${employee.id}" /></h4></td>
                <td><h4><c:out value="${employee.name}" /></h4></td>
                <td><h4><c:out value="${employee.college}" /></h4></td>
                
                        <td><form action="DeleteProfile" method="get">
                               <input type="hidden" name="id" value="${employee.id}" />
                               <input type="hidden" name="table" value="employee" />
                               <input type="submit"  class="btn btn-danger" name="action" value="Delete"/>
                            </form>
                        </td>
              </tr>
            </c:forEach>
            </tbody>
        </table>
          </div>
        
         <div class="employer_list">
              <h4>Employers List</h4>
             
        <table class="table table-striped " align="center">
        	<thead>
                <tr>
                    <th><h3>Id</h3></th>
                    <th><h3>Name</h3></th>
                    <th><h3>Company Name</h3></th>
                    <th><h3>Profile</h3></th>
                    
                    <th><h3></h3></th>
                    
                </tr>

            </thead>
            <tbody>
                
            <c:forEach items="${employerList}" var="employer">
              <tr>
                <td><h4><c:out value="${employer.id}" /></h4></td>
                <td><h4><c:out value="${employer.name}" /></h4></td>
                <td><h4><c:out value="${employer.company}" /></h4></td>
                <td><h4><c:out value="${employer.profile}" /></h4></td>
                
                        <td><form action="DeleteProfile" method="get">
                               <input type="hidden" name="id" value="${employer.id}" />
                                 <input type="hidden" name="table" value="employer" />
                               <input type="submit"  class="btn btn-danger" name="action" value="Delete"/>
                              
                            </form>
                        </td>
              </tr>
            </c:forEach>
            </tbody>
        </table>
          </div>
          
    </body>
</html>
