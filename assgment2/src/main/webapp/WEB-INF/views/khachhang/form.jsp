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

<form:form action="/khachhang/add" method="post" modelAttribute="khachhang">
<%--    Id: <form:input path="id"/><br>--%>
<%--    <form:errors path="id"/>--%>
<%--    <br>--%>
    Tên:<form:input path="ten"/><br>
    <form:errors path="ten"/><br>
    Sdt:<form:input path="sdt"/><br>
    <form:errors path="sdt"/><br>
    MãKH:<form:input path="maKH"/><br>
    <form:errors path="maKH"/><br>
    trạng thái:
    <input type="radio" name="tranhThai" checked value="true"/>Hoạt động
    <input type="radio" name="trangThai" value="false"/>Ngừng hoạt động
    <br/>
    <button type="submit">Save</button>
</form:form>
</body>
</html>