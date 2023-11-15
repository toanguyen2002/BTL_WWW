<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Your Page Title</title>
<!-- Add necessary CSS and JavaScript references here -->
</head>
<body>
		<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container">
		<h1 class="mt-5">Thông tin cá nhân</h1>
		<div class="row mt-4">
			<div class="col-md-6">
				<div class="form-group">
					<label for="firstName">Họ và tên đệm:</label> <input type="text"
						class="form-control" id="firstName" placeholder="Họ và tên đệm">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="lastName">Tên:</label> <input type="text"
						class="form-control" id="lastName" placeholder="Tên">
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="email">Email:</label> <input type="email"
				class="form-control" id="email" placeholder="Email">
		</div>
		<div class="form-group">
			<label for="address">Địa chỉ:</label> <input type="text"
				class="form-control" id="address" placeholder="Địa chỉ">
		</div>
		<div class="form-group">
			<label for="phone">Số điện thoại:</label> <input type="tel"
				class="form-control" id="phone" placeholder="Số điện thoại">
		</div>
		<button type="submit" class="btn btn-primary">Lưu thông tin</button>
	</div>
</body>
</html>
