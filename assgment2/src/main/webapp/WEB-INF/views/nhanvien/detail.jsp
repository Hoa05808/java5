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
<form:form action="" method="post" modelAttribute="nhanvien">
    Id: <form:input path="id" value="${nhanvien.id}"/><br>
    <form:errors path="id"/>
    <br>
    Tên:<form:input path="ten" value="${nhanvien.ten}"/><br>
    <form:errors path="ten"/><br>
    MãNV:<form:input path="maNV" value="${nhanvien.maNV}"/><br>
    <form:errors path="maNV"/><br>
    Tên đăng nhập:<form:input path="tenDangNhap" value="${nhanvien.tenDangNhap}"/><br>
    <form:errors path="tenDangNhap"/><br>
    Mật khẩu:<form:input path="matKhau" value="${nhanvien.matKhau}"/><br>
    <form:errors path="matKhau"/><br>
    Trạng thái:
    <input type="radio" name="trangThai" ${nhanvien.trangThai ? "checked":""}  value="true"/>Hoạt động
    <input type="radio" name="trangThai" ${nhanvien.trangThai ? "":"checked"} value="false"/>không
    <br/>
</form:form>
</body>
</html>