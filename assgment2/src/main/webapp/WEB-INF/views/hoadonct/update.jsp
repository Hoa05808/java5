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
<form:form action="/hoadonct/update" method="post" modelAttribute="hoadonct">
    Id: <form:input path="id" value="${hoadonct.id}"/><br>
    <form:errors path="id"/>
    <br>
    idHóa đon:<form:input path="idHoaDon" value="${hoadonct.idHoaDon}"/><br>
    <form:errors path="idHoaDon"/><br>
    id SPCT:<form:input path="idSPCT" value="${hoadonct.idSPCT}"/><br>
    <form:errors path="idSPCT"/><br>
    Số lượng:<form:input path="soLuong" value="${hoadonct.soLuong}"/><br>
    <form:errors path="soLuong"/><br>
    Đơn giá:<form:input path="donGia" value="${hoadonct.donGia}"/><br>
    <form:errors path="donGia"/><br>
    Trạng thái:
    <input type="radio" name="trangThai" ${hoadonct.trangThai ? "checked":""}  value="true"/>đã thanh toán
    <input type="radio" name="trangThai" ${hoadonct.trangThai ? "":"checked"} value="false"/>chưa thanh toán
    <br/>
    <button type="submit">Update</button>
</form:form>
</body>
</html>