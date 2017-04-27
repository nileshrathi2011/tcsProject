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
  <h2>Employer Registration</h2>
  <form>
    <div class="form-group">
	<label for="name">Name:</label>
      <input type="name" class="form-control" id="name" placeholder="Name">
    </div>
	<div class="form-group">
	<label for="college name">Compony Name:</label>
      <input type="name" class="form-control" id="cmpname" placeholder="Compony Name">
    </div>
    <div class="form-group">
	<label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter Email">
    </div>
	<div class="form-group">
	<label for="compony website">Compony Website:</label>
      <input type="url" class="form-control" id="cmpweb" placeholder="Compony Website">
    </div>
	<div class="form-group">
	<label for="job profile">Job Profile:</label>
      <input type="name" class="form-control" id="jp" placeholder="Job Profile">
    </div>
	<div class="form-group">
	<label for="Skills Reuired">Skills Required</label>
     <textarea class="form-control" row="10" id="Skills Required"placeholder="Skills Required"></textarea>
	 </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
	<div class="form-group">
      <label for="pwd">Confirm Password:</label>
      <input type="password" class="form-control" id="cnfpwd" placeholder="Confirm password">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>
