<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Task 1 - WebShop</title>
	<link rel="stylesheet" href="css/styles.css">
</head>

<body>
	<h1>Cart</h1>
	<form action="addItem" method="post">
	  <fieldset><legend>Add a new item to cart</legend>
	       <input type="text" name="item" />
	    <p><input type="submit" value="Add to cart" /></p>
		  <span style="color:red">${redirectMessage}</span>
	  </fieldset>
	</form>

	<table><tr>
		<th>Item:</th>
	</tr>
		<c:forEach var="item" items="${cart.items}"><tr>
			<td><button id="remove">Delete</button>${item.name}</td>
		</tr></c:forEach>
	</table><br>
	<a href="${pageContext.request.contextPath}index.html">Return to index</a>
</body>

</html>