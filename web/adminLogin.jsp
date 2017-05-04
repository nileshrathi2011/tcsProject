<%-- 
    Document   : adminLogin
    Created on : 2 May, 2017, 9:07:03 PM
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
          
          <div class="col-sm-4 login">
  	
  	<div class="login_employee">
  	<div class="wrapper">
    <form class="form-signin" method="post" action="AdminLogin">       
      <h2 class="form-signin-heading">Login Admin</h2>
      <p align="center">${message}</p>
      <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/> 

			  
			     
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                
    </form>
  </div>
  </div>

  <br>

  </div>

    </body>
</html>
