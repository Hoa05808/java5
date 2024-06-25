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

<form:form action="/sanpham/add" method="post" modelAttribute="sanpham">
    Id: <form:input path="id"/><br>
    <form:errors path="id"/>
    <br>
    Mã:<form:input path="ma"/><br>
    <form:errors path="ma"/><br>
    Tên:<form:input path="ten"/><br>
    <form:errors path="ten"/><br>
    Trạng thái:
    <input type="radio" name="trangThai" checked value="true"/>có
    <input type="radio" name="trangThai" value="false"/>hết
    <br/>
    <button type="submit" class="btn btn-primary">save</button>
</form:form>
</body>
</html>