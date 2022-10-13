<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Task 1 - WebShop</title>
	<link rel="stylesheet" href="css/simple.css">
</head>

<body>
	<h1>My shared list</h1>
	<form action="addItem" method="post">
	  <fieldset><legend>Add a new item to basket</legend>
	       <input type="text" name="item" />
	    <p><input type="submit" value="Add to basket" /></p>
	  </fieldset>
	</form>

	<table><tr>
		<th>Item:</th>
	</tr>
		<c:forEach var="item" items="${cart.items}"><tr>
			<td><button id="remove"></button>${item.name}</td>
		</tr></c:forEach>
	</table><br>
	<a href="${pageContext.request.contextPath}index.html">Return to index</a>
</body>

</html>