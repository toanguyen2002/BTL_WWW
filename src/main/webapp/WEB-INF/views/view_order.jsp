<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Order</title>
</head>
<body>
    <h2>Order Details</h2>

    <c:if test="${not empty order}">
        <p>
            <b>Order ID:</b> ${order.id}<br>
            <b>Order Date:</b> ${order.orderDate}<br>
            <!-- Add more details as needed -->
        </p>
    </c:if>
	<%@include file="/WEB-INF/views/footer.jsp"%>

    <!-- Add more details as needed -->

    <p><a href="/WWW_BTL/order/orderController">Back to List</a></p>
</body>
</html>
