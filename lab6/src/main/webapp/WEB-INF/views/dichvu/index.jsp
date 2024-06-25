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
        <th>loaiDV id</th>
        <th>loaiDV moTa</th>
        <th>loaiDV tenLDV</th>
        <th>loaiDV trangThai</th>
        <th>donGia</th>
        <th>donViTien</th>
        <th>donViTinh</th>
        <th>moTa</th>
        <th>tenDV</th>
        <th>trangThai</th>
        <th> action</th>
    </tr>
    <c:forEach items="${dichvu}" var="item">
         <tr>
             <td>${item.id}</td>
             <td>${item.loaiDichVu.id}</td>
             <td>${item.loaiDichVu.moTa}</td>
             <td>${item.loaiDichVu.tenLDV}</td>
             <td>${item.loaiDichVu.trangThai}</td>
             <td>${item.donGia}</td>
             <td>${item.donViTien}</td>
             <td>${item.donViTinh}</td>
             <td>${item.moTa}</td>
             <td>${item.tenDV}</td>
             <td>${item.trangThai}</td>
             <td>
                 <a href="/dichvu/viewadd">add</a>
                 <a href="/order/detail/${item.id}">detail</a>
             </td>
         </tr>
    </c:forEach>
</table>
</body>
</html>