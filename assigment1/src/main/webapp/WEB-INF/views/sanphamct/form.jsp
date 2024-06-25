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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<body>

<form:form action="/sanphamct/add" method="post" modelAttribute="sanphamct">
    Id: <form:input path="id"/><br>
    <form:errors path="id"/>
    <br>
    MãSPCT:<form:input path="maSPCT"/><br>
    <form:errors path="maSPCT"/><br>
    idKT:<form:input path="idKichThuoc"/><br>
    <form:errors path="idKichThuoc"/><br>
    idSP:<form:input path="idSanPham"/><br>
    <form:errors path="idSanPham"/><br>
    Số lượng:<form:input path="soLuong"/><br>
    <form:errors path="soLuong"/><br>
    Đơn giá:<form:input path="donGia"/><br>
    <form:errors path="donGia"/><br>
    trạng thái:
    <input type="radio" name="tranhThai" checked value="true"/>có
    <input type="radio" name="trangThai" value="false"/>hết
    <br/>
    <button type="submit" class="btn btn-primary">save</button>
</form:form>
</body>
</html>