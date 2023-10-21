<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Danh sách học sinh</title>
<link rel="stylesheet" type="text/css" href="./templates/CSS/styles.css">
</head>
<script type="text/javascript"
	src="./templates/JavaScript/XacThucXoa.js"></script>
</head>
<%
String thongbaodk = (String) session.getAttribute("thongbaodk");
String thongbaocn = (String) session.getAttribute("thongbaocn");
String thongbaoxoa = (String) session.getAttribute("thongbaox");
if (thongbaocn != null) {
    session.removeAttribute("thongbaocn");
} else {
    thongbaocn = "";
}
if (thongbaoxoa != null) {
    session.removeAttribute("thongbaox");
} else {
    thongbaoxoa = "";
}
if (thongbaodk != null) {
    session.removeAttribute("thongbaodk");
} else {
    thongbaodk = "";
}
%>

<body>

	<h1 class="main-heading">Danh sách học sinh</h1>
	<form action="hienthi" method="post">
		<table class="student-table">
			<tr>
				<th>Id</th>
				<th>Full Name</th>
				<th>Address</th>
				<th>Options</th>
			</tr>
			<c:forEach var="student" items="${dsHocSinh}">
				<tr>
					<td><c:out value="${student.mssv}" /></td>
					<td><c:out value="${student.name}" /></td>
					<td><c:out value="${student.address}" /></td>
					<td class="container-action"><a
						class="action-buttons edit-button"
						href="CapNhatSV?mssv=${student.mssv}">Edit</a> <a
						class="action-buttons delete-button"
						onclick="testConfirmDialog(${student.mssv})">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a class="add-button" href="DangKySV">Add</a>
		<div class="container">
			<p class="p-thongbao"><%=thongbaodk%></p>
			<p class="p-thongbao"><%=thongbaocn%></p>
			<p class="p-thongbao"><%=thongbaoxoa%></p>
		</div>
	</form>
</body>
</html>
