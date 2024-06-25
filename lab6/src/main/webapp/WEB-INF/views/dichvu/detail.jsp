<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form >
    <lable>id:</lable>
    <input type="text" name="id" value="${order.id}"><br>
    <lable>customer id:</lable>
    <input type="text" name="customer" value="${order.customer.id}"><br>
    <lable>customer name:</lable>
    <input type="text" name="customer" value="${order.customer.name}"><br>
    <lable>customer address:</lable>
    <input type="text" name="customer" value="${order.customer.address}"><br>
    <lable>note:</lable>
    <input type="text" name="note" value="${order.note}"><br>
    <lable>shippingAddress:</lable>
    <input type="text" name="shippingAddress" value="${order.shippingAddress}"><br>
    <lable>total:</lable>
    <input type="text" name="total" value="${order.total}"><br>
</form>
</body>
</html>