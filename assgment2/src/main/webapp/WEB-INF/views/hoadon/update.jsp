<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
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
<h3>${message}</h3>
<form:form action="/hoadon/update" method="post" modelAttribute="hoadon">
    Id: <form:input path="id" value="${hoadon.id}"/><br>
    <form:errors path="id"/>
    <br>
    ID NV:<form:input path="idNV" value="${hoadon.idNV}"/><br>
    <form:errors path="idNV"/><br>
    ID KH:<form:input path="idKhachHang" value="${hoadon.idKhachHang}"/><br>
    <form:errors path="idKhachHang"/><br>
    Ngày mua:<form:input path="ngayMuaHang" value="${hoadon.ngayMuaHang}"/><br>
    <form:errors path="ngayMuaHang"/><br>
    Trạng Thái:
    <input type="radio" name="trangThai" ${hoadon.trangThai ? "checked":""}  value="true"/>đã thanh toán
    <input type="radio" name="trangThai" ${hoadon.trangThai ? "":"checked"} value="false"/>chưa thanh toán
    <br>
    <button type="submit">Update</button>
</form:form>
</body>
</html>