<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Restaurants</title>
</head>
<body>
	<table>
		<c:forEach var="res" items="${restaurants}">
			<tr>
				<td style="color:red;"><c:out value="${res.restaurantName}" /></td>
				<td><c:out value="${res.managerName}" /></td>
				<td><c:out value="${res.phoneNumber}" /></td>
				<td><c:out value="${res.address}" /></td>
				<td><img src="<c:url value='/RestaurantData/Campus_${res.campusId}/RestaurantLogo/${res.id}.jpg' />" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>