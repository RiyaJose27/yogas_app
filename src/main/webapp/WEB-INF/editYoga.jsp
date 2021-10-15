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
<h1>Hot Yoga</h1>


<form:form action="/editingYoga/${yoga.id}" method="post" modelAttribute="yoga">
	<input type="hidden" name="_method" value="put">
	<form:hidden path="user" value="${yoga.user.id}"/>
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="week">Day of Week</form:label>
        <form:errors path="week"/>
        <form:textarea path="week"/>
    </p>
        <p>
        <form:label path="price">Drop-in-Price</form:label>
        <form:errors path="price"/>
        <form:input  type="number" path="price"/>
    </p>
 
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:input  path="description"/>
    </p>
      
      
     
      <p><a href="/dashboard">Cancel</a></p>
      <p><a href="/destroy/${id}">Delete</a></p>
      
    <input type="submit" value="Submit"/>
</form:form> 



</body>
</html>