<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập Nhật</title>
<link rel="stylesheet" type="text/css" href="./styles/CSS/StyleDangKy.css">

</head>
<c:set var="SinhVien" value="${sessionScope.hocsinh}" />
<%
String sid = (String) session.getAttribute("sid");
String thongbaoloi=request.getAttribute("thongbaoloi")+"";
if (sid != null  ) {
	session.removeAttribute("sid");	
} else {

	sid = "";
}
if(session.getAttribute("hocsinh")!=null)
{
	session.invalidate();

}
thongbaoloi=(thongbaoloi.equals("null")?"":thongbaoloi);
%>
<body>
	<h2 class="form-heading">Form Update</h2>
	<form action="CapNhatSV" method="post" class="registration-form">
		<label for="id" class="form-label">ID*: <%=sid %></label> <input
			type="text" id="id" name="id" required class="form-input"
			value="${SinhVien.mssv}"> <br> <br> <label
			for="fullname" class="form-label">Full Name:</label> <input
			type="text" id="fullname" name="fullname" class="form-input"
			value="${SinhVien.name}"><br> <br> <label
			for="address" class="form-label">Address:</label> <input type="text"
			id="address" name="address" class="form-input"
			value="${SinhVien.address}"><br> 
 			<p class="p-thongbao"><%=thongbaoloi %></p>
 			<br>
 			<input
			type="submit" value="Update" class="form-button"> <input
			type="button" value="Cancel"
			onclick="window.location.href='ListSinhVien'" class="form-button">
	</form>
</body>
</html>