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
<form:form action="" method="post" modelAttribute="giangvien">
    Id: <form:input path="id" value="${giangvien.id}"/><br>
    <form:errors path="id"/>
    <br>
    Mã:<form:input path="ma" value="${giangvien.ma}"/><br>
    <form:errors path="ma"/><br>
    Tên:<form:input path="ten" value="${giangvien.ten}"/><br>
    <form:errors path="ten"/><br>
    Tuổi:<form:input path="tuoi" value="${giangvien.tuoi}"/><br>
    <form:errors path="tuoi"/><br>
    <%--    Gioi tinh: <form:radiobuttons path="gioiTinh" items="${positions}"/> <br>--%>
    Giới tính:
    <input type="radio" name="gioiTinh" ${giangvien.gioiTinh ? "checked":""}  value="true"/>Nam
    <input type="radio" name="gioiTinh" ${giangvien.gioiTinh ? "":"checked"} value="false"/>Nữ
    <br/>
    <form:errors path="gioiTinh"/><br>
    Địa chi:<form:input path="diaChi" value="${giangvien.diaChi}"/><br>
    <form:errors path="diaChi"/><br>
</form:form>
</body>
</html>