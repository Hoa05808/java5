<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>customer id</th>
        <th>customer name</th>
        <th>customer address</th>
        <th>note</th>
        <th>shippingAddress</th>
        <th> total</th>
        <th> action</th>
    </tr>
    <c:forEach items="${order}" var="item">
         <tr>
             <td>${item.id}</td>
             <td>${item.customer.id}</td>
             <td>${item.customer.name}</td>
             <td>${item.customer.address}</td>
             <td>${item.note}</td>
             <td>${item.shippingAddress}</td>
             <td>${item.total}</td>
             <td>
                 <a href="/order/create">add</a>
                 <a href="/order/detail/${item.id}">detail</a>
             </td>
         </tr>
    </c:forEach>
</table>
</body>
</html>