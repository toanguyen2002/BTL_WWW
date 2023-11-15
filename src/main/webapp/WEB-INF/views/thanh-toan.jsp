<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
		<%@include file="/WEB-INF/views/menu.jsp"%>
    <div class="container">
        <h1>Thanh toán</h1>
        <form>
            <div class="form-group">
                <label for="name">Tên của bạn</label>
                <input type="text" class="form-control" id="name" placeholder="Nhập tên của bạn">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" placeholder="Nhập địa chỉ email của bạn">
            </div>
            <div class="form-group">
                <label for="card">Số thẻ thanh toán</label>
                <input type="text" class="form-control" id="card" placeholder="Nhập số thẻ thanh toán">
            </div>
            <div class="form-group">
                <label for="exp-date">Ngày hết hạn</label>
                <input type="text" class="form-control" id="exp-date" placeholder="MM/YY">
            </div>
            <div class="form-group">
                <label for="cvv">Mã CVV</label>
                <input type="text" class="form-control" id="cvv" placeholder="Nhập mã CVV">
            </div>
            <div class="form-group">
                <label>Phương thức thanh toán</label>
                <select class="form-control">
                    <option>Thẻ tín dụng</option>
                    <option>Chuyển khoản ngân hàng</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Xác nhận thanh toán</button>
        </form>
    </div>
</body>
</html>