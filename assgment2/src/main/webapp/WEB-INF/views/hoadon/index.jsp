<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
    <title>Dashboard</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<body>
<form action="/hoadon/search">
   ID hóa đơn: <input name="id"/>
    <button type="submit">Search</button>
</form>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>ID HÓA ĐƠN</th>
        <th>ID KHÁCH HÀNG</th>
        <th>NGÀY MUA</th>
        <th>TRẠNG THÁI</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list}" var="st" varStatus="i">
        <tr>
            <td>${i.index + 1} </td>
            <td>${st.id} </td>
            <td>${st.idNV}</td>
            <td>${st.idKhachHang}</td>
            <td>${st.ngayMuaHang}</td>
            <td>${st.trangThai?"Đã thanh toán":"Chưa thanh toán"}</td>
            <td><a href="/hoadon/view-update?id=${st.id}"><button type="button" class="btn btn-success">update</button></a>
                <a href="/hoadon/delete/${st.id}"><button type="button" class="btn btn-primary">delete</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
