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
    <h1>Namaste, ${user.fname }</h1>
    <p>Course Schedule </p>
     <p><a href="/logout">Logout</a>
     <p><a href="/newYoga">+ new course</a>
    
    <table class="table table-dark table-striped table-hover table-bordered">
			<thead >
				<tr >
					
					<th class="align-middle" scope="col">Class Name</th>
					<th class="align-middle" scope="col">Instructor</th>
					<th class="align-middle" scope="col">Weekday</th>
					<th  class="align-middle" scope="col">Time</th>
						<th class="align-middle" scope="col">Price</th>
				</tr>
			</thead>	
				<tbody>
					<c:forEach  var="i" items="${allYogas}" >
						<tr class=" table-secondary ">
						
							<td> <a href="/oneYoga/${i.id}">  <c:out value="${i.name}"></c:out></a>
							
							<c:choose>
									<c:when test="${i.user.id == user.id}">
									    <a href="/editYoga/${i.id }">Edit</a>
									
									</c:when>
									</c:choose></td>
													
							
							
							
			
						   <td><c:out value="${i.user.fname}"></c:out></td>
							<td> <c:out value="${i.week}"></c:out> </td>
							<td>$ <c:out value="${i.price}"></c:out> </td>
					
							
						</tr>
					</c:forEach>
				</tbody>
		</table>

</body>
</html>