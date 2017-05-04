<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register As Employee</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

<div class="container">
  <h2>Employer Registration</h2>
   <p>${message}</p>
  <form method="post" action="RegistrationEmployer">
    <div class="form-group">
	<label for="name">Name:</label>
      <input type="name" class="form-control" name="name" placeholder="Name">
    </div>
	<div class="form-group">
	<label for="college name">Compony Name:</label>
      <input type="name" class="form-control" name="cmpname" placeholder="Compony Name">
    </div>
    <div class="form-group">
	<label for="email">Email:</label>
      <input type="email" class="form-control" name="email" placeholder="Enter Email">
    </div>
	<div class="form-group">
	<label for="compony website">Compony Website:</label>
      <input type="url" class="form-control" name="cmpweb" placeholder="Compony Website">
    </div>
	<div class="form-group">
	<label for="job profile">Job Profile:</label>
      <input type="name" class="form-control" name="jp" placeholder="Job Profile">
    </div>
	<div class="form-group">
	<label for="Skills Reuired">Skills Required</label>
     <textarea class="form-control" row="10" name="skills"placeholder="Skills Required"></textarea>
	 </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="pwd" placeholder="Enter password">
    </div>
	<div class="form-group">
      <label for="pwd">Confirm Password:</label>
      <input type="password" class="form-control" name="cnfpwd" placeholder="Confirm password">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
  </form>
</div>

</body>
</html>
