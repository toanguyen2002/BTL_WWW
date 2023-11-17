<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${loginFailed == 'false'}">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="/WWW_BTL">SQA</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">HOME</a></li>
						<li class="nav-item"><a class="nav-link" href="#">NEW</a></li>
						<li class="nav-item"><a class="nav-link" href="#">BEST</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> MORE </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item"
									href="/WWW_BTL/danhsachsanpham?num=0&gt=boy">ĐỒ CHO NAM</a></li>
								<li><a class="dropdown-item" href="#">ĐỒ CHO NỮ</a></li>
							</ul></li>
							<li class="nav-item"><a class="nav-link" href="/WWW_BTL/cart">Giỏ Hàng</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-primary" type="submit">Search</button>
					</form>
					
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="#">Đăng
								nhập</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</c:when>
	<c:otherwise>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="/WWW_BTL">SQA</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">HOME</a></li>
						<li class="nav-item"><a class="nav-link" href="#">NEW</a></li>
						<li class="nav-item"><a class="nav-link" href="#">BEST</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> MORE </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item"
									href="/WWW_BTL/danhsachsanpham?num=0&gt=all">TẤT CẢ SẢN
										PHẨM</a> <a class="dropdown-item"
									href="/WWW_BTL/danhsachsanpham?num=0&gt=new">SẢN PHẨM MỚI</a></li>
								<li><a class="dropdown-item"
									href="/WWW_BTL/danhsachsanpham?num=0&gt=sale">SẢN PHẨM SALE</a></li>
							</ul></li>
							<li class="nav-item"><a class="nav-link" href="/WWW_BTL/cart">Giỏ Hàng</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-primary" type="submit">Search</button>
					</form>
					
					<ul class="navbar-nav">
						<!-- User dropdown menu -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"
							id="accountDropdown"> Tài khoản của tôi </a> <!-- Conditional menu items based on userSecurity -->
							<c:choose>
								<c:when test="${userSecurity == 'false'}">
									<ul class="dropdown-menu" aria-labelledby="accountDropdown">
										<li><a class="dropdown-item"
											href="/WWW_BTL/productController?num=0">Quản Lý Sản Phẩm</a></li>
										<li><a class="dropdown-item"
											href="/WWW_BTL/userController">Quản Lý User</a></li>
											<li><a class="dropdown-item"
												href="/WWW_BTL/categories/list">Quản Lý Danh Mục</a></li>
												<li><a class="dropdown-item"
												href="/WWW_BTL/order/orderController">Quản Lý Hóa đơn</a></li>
										<li><a class="dropdown-item" href="#">Đăng xuất</a></li>
									</ul>
								</c:when>
								<c:otherwise>
									<ul class="dropdown-menu" aria-labelledby="accountDropdown">
										<li><a class="dropdown-item"
											href="/WWW_BTL/productController">Thông Tin Cá Nhân</a></li>
										<li><a class="dropdown-item" href="/WWW_BTL/userController">Lịch Sử Mua Hàng</a></li>
										<li><a class="dropdown-item" href="#">Đăng xuất</a></li>
									</ul>
								</c:otherwise>
							</c:choose></li>
					</ul>
				</div>
			</div>
		</nav>
	</c:otherwise>
</c:choose>
