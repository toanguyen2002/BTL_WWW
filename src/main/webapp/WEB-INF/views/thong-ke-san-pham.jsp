<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top 10 Sản Phẩm Được Bán Nhiều Nhất</title>
<style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

    
</head>
<body>
	<%@include file="/WEB-INF/views/menu.jsp"%>
	<table>
		<tr>
			<th>
				Sản Phẩm 
			</th>
			<th>
				Số lượng Bán
			</th>
			<th>
				Thu Nhập
			</th>
		</tr>
		<c:forEach items="${listtk}" var="tk">
			<tr>
			<th>
				${tk.product.nameProduct}
			</th>
			<th>
				${tk.quantity}
			</th>
			<th>
				${tk.price}
			</th>
		</tr>
		</c:forEach>
	</table>
</body>
</html>