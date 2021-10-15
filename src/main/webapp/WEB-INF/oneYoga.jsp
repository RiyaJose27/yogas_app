<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page isErrorPage="true" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

      
 <p><a href ="/dashboard">back to the dashboard</a>
<h1>${yoga.name} with ${yoga.user.fname}</h1>
<p>Day: ${yoga.week} </p>
<p>Cost: $${yoga.price}</p>

<p>A gentle evening stretch.Focus is on</p>
<p>breathing and stress release</p>



</body>
</html>