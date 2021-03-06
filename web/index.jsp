<!DOCTYPE html>
<html style="height: 100%">
<head>
 <meta charset="utf-8">
 <link rel="stylesheet" type="text/css" href="styles/main.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Job Portal</title>
</head>


<body style="height: 100%">

<div class="background-image" style="height: 100%" > </div>
<div class="conten" style="height: 100%">

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


<div class="row">
  <div class="col-sm-8 content">
  <h1>Get A job!</h1>
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
  quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
  consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
  cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
  proident, sunt in culpa qui officia deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
  quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
  consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
  cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
  proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
  Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
  quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
  consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
  cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
  proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
  	
  </div>
  <div class="col-sm-4 login">
  	
  	<div class="login_employee">
  	<div class="wrapper">
    <form class="form-signin" method="post" action="LoginServlet">       
      <h2 class="form-signin-heading">Login Employee</h2>
      <p>${message}</p>
      <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/> 

			      <div class="checkbox">
			  <label><input type="checkbox" value="" name="employerLogin">Login as Employer</label>
			</div>
			     
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                
    </form>
  </div>
  </div>

  <br>

  </div>
  
</div>

<!-- yaha part pop up waala code hai-->
<div id="light" class="white_content"><a class="pull-right" href="javascript:void(0)" onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">Close</a>
	<div style="text-decoration-line: inherit;" class="wrapper_white_content_buttons">
		 <a href="registration.jsp" class="btn btn-success btn-lg" role="button">Employee</a>
		 
		 <a href="registration_employer.jsp" class="btn btn-success btn-lg" role="button">Employer</a>

	</div>

 </div>

<div id="fade" class="black_overlay"></div>
</div>

</body>
</html>