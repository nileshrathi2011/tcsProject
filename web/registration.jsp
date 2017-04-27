<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register As Student</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
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
      
    </ul>
  </div>
</nav>
</div>
<body>

<div class="container">
  <h2>Student Registration</h2>
  <p>${message}</p>
  <br>
  <form method="post" action="RegistrationEmployee">
    <div class="form-group">
	<label for="name">Nam:</label>
      <input type="name" class="form-control" name="name" placeholder="Name">
    </div>
	 <div class="form-group">
	<label for="dob">DOB:</label>
      <input type="dob" class="form-control" name="dob" placeholder="DD/MM/YYYY">
    </div>
	<div class="form-group">
	<label for="college name">College Name:</label>
      <input type="name" class="form-control" name="clgname" placeholder="College Name">
    </div>
    <div class="form-group">
	<label for="email">Email:</label>
      <input type="email" class="form-control" name="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="pwd" placeholder="Enter password">
    </div>
	<div class="form-group">
      <label for="pwd">Confirm Password:</label>
      <input type="password" class="form-control" name="cnfpwd" placeholder="Confirm password">
    </div>
	<div class="form-group">
      <label for="resume">Upload Resume:</label>
      <input type="url" class="form-control" name="upldrsm" placeholder="Upload Resume">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>
