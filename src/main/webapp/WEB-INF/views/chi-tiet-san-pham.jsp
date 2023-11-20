<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.nameProduct}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<div class="container">
		<h1>Chi tiết sản phẩm</h1>
		<div class="row">
			<div class="col-md-6">
				<img style="width: 100%"
					src="/WWW_BTL/assets/${product.getListImage().get(0)}"
					alt="Sản phẩm 1">
				<div>
					<div class="row">
						<c:forEach items="${product.getListImage()}" var="item">
							<div class="col-md-2">
								<img style="width: 100%" src="/WWW_BTL/assets/${item}"
									alt="Sản phẩm 1">
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<h2>${product.nameProduct}</h2>
				<p>${product.motasp}</p>
				<p>Giá Tiền: ${product.price}</p>
				<p>Size: ${product.size}</p>
				<p>Tin Về Sản Phẩm: ${product.motasp}</p>
				<c:if test="${product.inStock == true}">
					<p style="color:green">Còn hàng</p>
				</c:if>
				<c:if test="${product.inStock == false}">
					<p style="color:red">Hết hàng</p>
				</c:if>
				<button class="btn btn-primary">Mua ngay</button>
			</div>
		</div>
	</div>
	<br>
	<br>
		<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>