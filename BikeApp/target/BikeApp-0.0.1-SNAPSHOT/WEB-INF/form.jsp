<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bike</title>
<style type="text/css">
a {
	color: red;
}

table, th, td {
	border: 1px solid black;
	margin-left: auto;
	margin-right: auto;
}

body {
	text-align: center;
	background: gray;
}
</style>
</head>
<body>
	<form action="readForm.bike" method="post">
		<ul type="none">
			<li><label><h1>Bike List</h1></label></li>
			<li><label>Enter Bike Name</label> <input type="text"
				name="bikeName"></li>
			<a>${errorName}</a>
			<li><label>Enter Bike Color</label> <input type="text"
				name="bikeColor"></li>
			<a>${errorColor}</a>
			<li><label>Enter Bike Brand</label> <input type="text"
				name="bikeBrand"></li>
			<a>${errorBrand}</a>
			<li><label>Enter Bike Cost</label> <input type="text"
				name="bikeCost"></li>
			<a>${errorCost}</a>
			<li><label>Enter Bike Type</label> <input type="text"
				name="bikeType"></li>
			<a>${errorType}</a>
			<li><input type="submit" value="submit">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="reset"></li>
		</ul>
	</form>
	<br>
	<label>Enter bike name to get details </label>
	<a>${ErrorBikeName}</a>
	<form action="searchBike.bike" method="post">
		<input type="text" name="bikeName" placeholder="enter bike name.."><input
			type="submit" value="Search">
	</form>
	<table>
		<tr>
			<th>bike_Name</th>
			<th>bike_color</th>
			<th>bike_brand</th>
			<th>bike_cost</th>
			<th>bike_type</th>
		</tr>
		<tr>
			<td>${bikeName}</td>
			<td>${bikeColor}</td>
			<td>${bikeBrand}</td>
			<td>${bikeCost}</td>
			<td>${bikeType}</td>
		</tr>
	</table>
	<br>
	<label>Enter bike name to delete details </label>
	<a>${deleteBike}</a>
	<form action="deleteBikeByName.bike" method="post">
		<input type="text" name="bikeName" placeholder="enter bike name.."><input
			type="submit" value="Delete">
	</form>

	<br>
	<a href="getAllBikes.bike" style="color: blue;">get all bike information </a>
	<table>
		<tr>
			<th>bike_Name</th>
			<th>bike_color</th>
			<th>bike_brand</th>
			<th>bike_cost</th>
			<th>bike_type</th>
		</tr>

		<c:forEach items="${getAllBike}" var="t">
			<tr>
				<td>${t.bikeName}</td>
				<td>${t.bikeColor}</td>
				<td>${t.bikeBrand}</td>
				<td>${t.bikeCost}</td>
				<td>${t.bikeType}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a>${ERRORUPDATE}</a>
		<form action="updateFormByBikeName.bike" method="post">
		<ul type="none">
			<li><label><h3>Upd Bike By Bike Name</h3></label></li>
			<li><label>Enter Bike Name</label> <input type="text"
				name="bikeName" value="${errorName}"></li>
			<li><label>Enter Bike Color</label> <input type="text"
				name="bikeColor" value="${errorColor}"></li>
			<li><label>Enter Bike Brand</label> <input type="text"
				name="bikeBrand" value="${errorBrand}"></li>
			<li><label>Enter Bike Cost</label> <input type="text"
				name="bikeCost" value="${errorCost}"></li>
			<li><label>Enter Bike Type</label> <input type="text"
				name="bikeType" value="${errorType}"></li>
			<li><input type="submit" value="update">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="reset"></li>
		</ul>
	</form>
</body>
</html>