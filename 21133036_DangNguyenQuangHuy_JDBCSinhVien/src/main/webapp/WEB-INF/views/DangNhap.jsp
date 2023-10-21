<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="./styles/CSS/StyleDangKy.css">
</head>
<%
String thongbao = request.getAttribute("thongbaodnsai") + "";
thongbao=(thongbao.equals("null")?"":thongbao);
%>
<body>
	<h2 class="form-heading">Form Sign In</h2>
	<form action="dang-nhap" method="post"
		class="registration-form">
		<label for="id" class="form-label">Username:</label> <input
			type="text" id="username" name="username" required class="form-input">
		<br> <br> <label for="fullname" class="form-label">Password:</label>
		<input type="text" id="password" name="password" required
			class="form-input"><br><p class="p-thongbao"><%=thongbao %></p> <br> <input type="submit" value="Sign In"
			class="form-button"> <input type="button" value="Cancel"
			onclick="window.location.href='../ListSinhVien'" class="form-button">
	</form>
</body>
</html>