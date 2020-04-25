<%--
  Created by IntelliJ IDEA.
  User: Vinod
  Date: 4/24/2020
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>
</head>
<body>
    <div class="alert-success">
        ${msg}
    </div>
    <div class="container-fluid">
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="form-group">
                <label>Username</label>
                <input name="email" type="email" class="form-control">
            </div>
            <div class="form-group">
                <label>Username</label>
                <input name="password" type="password" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">login</button>
        </form>
    </div>
</body>
</html>
