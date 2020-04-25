<%--
  Created by IntelliJ IDEA.
  User: Vinod
  Date: 4/24/2020
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>
</head>
<body>
<div class="container-fluid">


    <div class="container-fluid">
        <h3 class="text-center">User Registartion</h3>
        <div class="alert-danger">
            ${msg}
        </div>
        <form action="${pageContext.request.contextPath}/saveUser" method="post">
            <div class="row form-group">
                <div class="col-1">Name</div>
                <div class="col"><input type="text" name="firstName" placeholder="FirstName" class="form-control"
                                        required></div>
                <div class="col"><input type="text" name="lastName" placeholder="LastName" class="form-control"
                                        required></div>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" placeholder="enter email" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="enter password" class="form-control" required>
            </div>

            <div class="form-group">
                <label>Confirm Password</label>
                <input type="password" name="password" placeholder="enter password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>

</div>
</body>
</html>
