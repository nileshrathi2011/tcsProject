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
     <link rel="stylesheet" type="text/css" href="style.css">
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
          <a class="navbar-brand" href="#">Job Portal</a>
        </div>
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">Companies</a></li>
          <li><a href="#">Colleges</a></li>
          
      <!--  </ul>
          <ul class="nav navbar-nav navbar-right">
          
          <li><a href="javascript:void(0)" onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">Register</a></li>
        </ul> -->
      </div>
    </nav>
    </div>

   
    <div class="employee_basic_ profile container">
         <h2>Welcome ${emp.name}</h2>
        
            <h3>Name: <small>${emp.name}</small></h3>
            <h3>DOB: <small>${emp.dob}</small></h3>
            <h3>College: <small>${emp.college}</small></h3>
            <h3>E-mail: <small>${emp.email}</small></h3>
            <h3>Resume: <small>${emp.resume}</small></h3>
            
    </div>

    <div calss="employee_application_status">
    
    </div>>

    </body>
</html>
