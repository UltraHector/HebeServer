<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Restaurant</title>
</head>
<body>
	<h3 style="color:red;">Create A New Restaurant</h3>
	<form action="createNewRestaurant" method="POST" enctype="multipart/form-data">
	<table>
		<tr><td>Restauant Name:</td><td> <input type="text" name="restaurantName" /></td></tr>
		<tr><td>Manager Name:</td><td> <input type="text" name="managerName" /> </td></tr>
		<tr><td>Phone Number: </td><td> <input type="text" name="phoneNumber" /></td> </tr>
		<tr><td>Address:</td><td> <input type="text" name="address" /></td> </tr>
		<tr><td>Notes: </td><td> <input type="text" name="notes" /> </td></tr>
		<tr><td>Logo Upload</td><td><input type="file" name="logo" /></td></tr>
		<tr><td>Description:</td><td> <textarea  name="description" /></textarea></td> </tr>
		<tr><td><td><input type="submit" /></td></tr>
	</table>
	</form>
</body>
</html>