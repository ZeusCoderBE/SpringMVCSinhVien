<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link rel="stylesheet" type="text/css" href="./styles/CSS/StyleDangKy.css">
</head>
<%
String thongbaoloi=request.getAttribute("thongbaoloi")+"";
thongbaoloi=(thongbaoloi.equals("null"))?"":thongbaoloi;
%>
<body>
	<h2 class="form-heading">Form Sign Up</h2>
	<form action="DangKySV" method="post" class="registration-form">
		<label for="id" class="form-label">ID*:</label> <input type="text"
			id="id" name="id" required class="form-input"> <br> <br>
		<label for="fullname" class="form-label">Full Name:</label> <input
			type="text" id="fullname" name="fullname" required class="form-input"><br>
		<br> <label for="address" class="form-label">Address:</label> <input
			type="text" id="address" name="address" required class="form-input"><br>
		<br>
		<p class="p-thongbao"><%=thongbaoloi%></p>
		 <input type="submit" value="Sign up" class="form-button">
		<input type="button" value="Cancel"
			onclick="window.location.href='ListSinhVien'" class="form-button">
	</form>
</body>
</html>