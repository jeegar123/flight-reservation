<%--
  Created by IntelliJ IDEA.
  User: Vinod
  Date: 4/24/2020
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Flight</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>
    <style>
        label {
            padding: 20px;
        }
    </style>
</head>
<body>
<h1 class="text-center">Search Flights</h1>

<div class="container-fluid">
    <form class="form-inline" action="${pageContext.request.contextPath}/searchFlight" method="post">
        <div>
            <label>
                From
                <input type="text" name="arrivalCity" class="form-control"/>
            </label>
        </div>
        <div>
            <label>
                To
                <input type="text" name="departureCity" class="form-control"/>
            </label>
        </div>
        <div>
            <label>
                Departure Date
                <input type="date" name="dateOfDepartment" class="form-control"/>
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
</div>
</body>
</html>
