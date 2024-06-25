<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form action="/order/add" method="post">
    <lab>loaiDichVu:</lab>
    <select name="loaiDichVu" >
        <c:forEach items="${list}" var="item">
            <option value="${item.id}" label="${item.tenLDV}"></option>
        </c:forEach>
    </select><br>
    <lable>donGia:</lable>
    <input type="text" name="donGia"><br>
    <lable>donViTien:</lable>
    <input type="text" name="donViTien"><br>
    <lable>donViTinh:</lable>
    <input type="text" name="donViTinh"><br>
    <lable>donViTinh:</lable>
    <input type="text" name="donViTinh"><br>
    <lable>moTa:</lable>
    <input type="text" name="moTa"><br>
    <lable>tenDV:</lable>
    <input type="text" name="tenDV"><br>
    <lable>trangThai:</lable>
    <input type="text" name="trangThai"><br>
    <button type="submit">add</button>
</form>
</body>
</html>