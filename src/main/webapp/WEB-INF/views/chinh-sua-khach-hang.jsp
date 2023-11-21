<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<title>Đăng Ký Tài Khoản</title>
</head>
<body>

	<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container">
		<h1 class="mt-5">Chỉnh sửa khách hàng</h1>
		<form:form modelAttribute="user" method="post" action="updateUser">
			<form:hidden path="id" />
			<!-- Đoạn mã HTML đã chỉnh sửa -->
			<div class="form-group">
				<form:input class="form-control" path="username"
					placeholder="Tên người dùng"/>
				
			</div>

			<div class="form-group">
				<form:input class="form-control" path="hoTen"
					placeholder="Họ và tên" />
				
			</div>
			<div class="form-group">
				<form:input class="form-control" path="sdt"
					placeholder="Số điện thoại" />
			
			</div>
			<div class="form-group">
				<form:input class="form-control" path="password" id="password"
					placeholder="Mật khẩu" />
				
			</div>
			<div class="form-group">
				<label for="role">Vai trò:</label>
				<form:select path="role" class="form-control" id="role">
					<form:option value="customer">Khách hàng</form:option>
					<form:option value="admin">Quản trị viên</form:option>
				</form:select>
			</div>
			<button type="submit" class="btn btn-primary">Sửa</button>
		</form:form>
	</div>
	<br>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	
</body>
</html>
