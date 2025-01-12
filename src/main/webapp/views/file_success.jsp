<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Image</h1>
<h2>${path} he ye</h2>
<c:forEach var="item" items="${path}">
	 +
	<img alt="image" src="images/${item}" style="width:300px; height:200px; object-fit:contains">
</c:forEach>
<!-- <img alt="Hey here image" src="images/rohan-NtY9zY4o2gA-unsplash.jpg"  /> -->
</body>
</html>