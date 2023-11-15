<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang Chủ</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
	<script>
  // Function to show the modal and pass product details
  function showQuantityModal(productId, productName) {
    // Set the product details in the modal
    document.getElementById('productModalTitle').innerHTML = productName;
    document.getElementById('productIdInput').value = productId;

    // Show the modal
    $('#quantityModal').modal('show');
  }
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	
	<!-- banner -->
<!-- Wrap the carousel in a container to center it -->
<div class="container">
    <div id="bannerCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://th.bing.com/th/id/OIP.H1swOIs49D4poz0GfzuDPgHaDs?w=334&h=180&c=7&r=0&o=5&pid=1.7" class="d-block w-100" alt="Banner 1">
            </div>
            <div class="carousel-item">
                <img src="https://th.bing.com/th/id/OIP.VkyBthhSZXltVvQVx_rsJgHaDW?w=323&h=158&c=7&r=0&o=5&pid=1.7" class="d-block w-100" alt="Banner 2">
            </div>
            <!-- Add more carousel items as needed -->
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#bannerCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#bannerCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>



	<!-- Content Container -->
	<br>
	<div class="container mt-10">
		<h1 class="mb-4 mt-10">Hàng Mới</h1>
		<div class="row">
			<!-- Product Cards -->
			<c:forEach items="${listSP}" var="sp">
				<div class="col-md-4 mb-4">
					<div class="card">
						<img src="/WWW_BTL/assets/${sp.getListImage().get(0)}"
							class="card-img-top" alt="Sản phẩm 1">
						<div class="card-body">
							<h5 class="card-title">${sp.getNameProduct()}</h5>
							<p class="card-text">${sp.getMotasp()}</p>
							<a href="/WWW_BTL/product?id=${sp.getIdProduct()}"
								class="btn btn-primary">Xem chi tiết</a> 
								<a href="#" data-bs-toggle="modal" data-bs-target="#quantityModal" onclick="showQuantityModal('${sp.getIdProduct()}', '${sp.getNameProduct()}')" class="btn btn-primary">Thêm Giỏ hàng</a>
								
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="container">
    <!-- Content above pagination goes here -->
    
    <!-- Pagination -->
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="/WWW_BTL/trangchu?num=${numprd+1}">${numprd+1}</a></li>
            <li class="page-item"><a class="page-link" href="/WWW_BTL/trangchu?num=${numprd+2}">${numprd+2}</a></li>
            <li class="page-item"><a class="page-link" href="/WWW_BTL/trangchu?num=${numprd+3}">${numprd+3}</a></li>
            <li class="page-item"><a class="page-link" href="/WWW_BTL/trangchu?num=${numprd+4}">${numprd+4}</a></li>
            <!-- Add more page items as needed -->
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    <div class="modal fade" id="quantityModal" tabindex="-1" role="dialog" aria-labelledby="quantityModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="quantityModalLabel">
							Nhập số lượng cho sản phẩm <span id="productModalTitle"></span>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Add a form to enter quantity -->
						<form action="/WWW_BTL/addCart" method="get">
							<input type="hidden" name="id" id="productIdInput" value="">
							<div class="form-group">
								<label for="quantityInput">Số lượng:</label> <input
									type="number" class="form-control" id="quantityInput"
									name="quantity" required>
							</div>
							<br> <br>
							<button type="submit" class="btn btn-primary mt-10">Thêm
								vào giỏ hàng</button>
						</form>
					</div>
				</div>
			</div>
			<!-- Content below pagination goes here -->
</div>
	
</body>
</html>
