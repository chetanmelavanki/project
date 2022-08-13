<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<label><h1>Mail sender app</h1></label>
	<a style="color: red">${errorMail}</a>
	<form action="readEmailDetails.bike" method="post">
		<label>To</label> <input type="email" name="toEmail"> <br>
		<label>subject</label><input type="text" name="subject"> <br>
		<label>add a text</label> <input type="text" name="textBody"> <br>
		<input type="submit" value="send">

	</form>
</body>
</html>