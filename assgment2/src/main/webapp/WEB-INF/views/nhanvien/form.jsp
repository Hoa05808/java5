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
<h3>${message}</h3>

<form:form action="/nhanvien/add" method="post" modelAttribute="nhanvien">
<%--    Id: <form:input path="id"/><br>--%>
<%--    <form:errors path="id"/>--%>
    <br>
    Tên:<form:input path="ten"/><br>
    <form:errors path="ten"/><br>
    MãNV:<form:input path="maNV"/><br>
    <form:errors path="maNV"/><br>
    Tên đăng nhập:<form:input path="tenDangNhap"/><br>
    <form:errors path="tenDangNhap"/><br>
    Mật khẩu:<form:input path="matKhau"/><br>
    <form:errors path="matKhau"/><br>
    Trạng thái:
    <input type="radio" name="trangThai" checked value="true"/>Admin
    <input type="radio" name="trangThai" value="false"/>Nhân viên
    <br/>
    <button type="submit" class="btn btn-info">Add</button>
</form:form>
</body>
</html>