<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<h1>Update Page</h1>
	<form action="update">
		<label for="id">Enter the Employee_ID to update : </label> <input type="text" name="id"> <br/>
		<button type="submit">Update</button>
	</form>

</body>
</html>