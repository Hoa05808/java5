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

<form:form action="/giangvien/add" method="post" modelAttribute="giangvien">
<%--    Id: <form:input path="id"/><br>--%>
<%--    <form:errors path="id"/>--%>
<%--    <br>--%>
    Mã:<form:input path="ma"/><br>
    <form:errors path="ma"/><br>
    Tên:<form:input path="ten"/><br>
    <form:errors path="ten"/><br>
    Tuổi:<form:input path="tuoi"/><br>
    <form:errors path="tuoi"/><br>
<%--    Gioi tinh: <form:radiobuttons path="gioiTinh" items="${positions}"/> <br>--%>
    Giới tính:
    <input type="radio" name="gioiTinh" checked value="true"/>Nam
    <input type="radio" name="gioiTinh" value="false"/>Nữ
    <br/>
    <form:errors path="gioiTinh"/><br>
    Địa chi:<form:input path="diaChi"/><br>
    <form:errors path="diaChi"/><br>
    <button type="submit">Save</button>
</form:form>
</body>
</html>