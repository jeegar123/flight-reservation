<%--
  Created by IntelliJ IDEA.
  User: Vinod
  Date: 4/24/2020
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>
</head>
<body>
<diV class="container w-50 ">
    <h2>Flight Details</h2>
    Flight Id:<h5>${flight.id}</h5><br>
    Arrival City:<h5>${flight.arrivalCity}</h5><br>
    Departure City:<h5>${flight.departureCity}</h5><br>
    Arrival Date:<h5>${flight.dateOfDepartment}</h5><br>
    Arrival Time:<h5>${flight.estimateDepartmentTime}</h5><br>
    <form action="${pageContext.request.contextPath}/completeReservation" method="post">
        <div class="h2 text-center">Passenger Details</div>
        <div class="form-group row">
            <div class="col-1"><label>Name</label></div>
            <div class="col"><input type="text" name="firstName" class="form-control" placeholder="first name"/></div>
            <div class="col"><input type="text" name="lastName" class="form-control" placeholder="last name"/></div>
        </div>
        <input type="hidden" name="flightId" value="${flight.id}">
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Phone</label>
            <input type="text" name="phone" pattern="[\d]{10}" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-outline-primary">Submit</button>
    </form>

    <div>
        Payment Through Paytm
    </div>
</diV>

</body>
</html>
