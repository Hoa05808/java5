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
<form:form action="/kichthuoc/add" method="post" modelAttribute="kichthuoc">
<%--    Id: <form:input path="id"/><br>--%>
<%--    <form:errors path="id"/>--%>
    <br>
    Mã:<form:input path="ma"/><br>
    <form:errors path="ma"/><br>
    Tên:<form:input path="ten"/><br>
    <form:errors path="ten"/><br>
    trạng thái:
    <input type="radio" name="tranhThai" checked value="true"/>có
    <input type="radio" name="trangThai" value="false"/>hết
    <br/>
    <button type="submit">Save</button>
</form:form>
</body>
</html>