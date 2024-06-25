<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form action="/order/add" method="post">
    <lab>Customer:</lab>
    <select name="customer" >
        <c:forEach items="${customer}" var="item">
            <option value="${item.id}" label="${item.name}"></option>
        </c:forEach>
    </select><br>
    <lable>note:</lable>
    <input type="text" name="note"><br>
    <lable>shippingAddress:</lable>
    <input type="text" name="shippingAddress"><br>
    <lable>total:</lable>
    <input type="text" name="total"><br>
    <button type="submit">add</button>
</form>
</body>
</html>