<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<body>
<table class="table table-striped">
    <form action="/sanphamct/search">
        Mã SPCT: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <a href="/sanphamct/view-add"><button type="button" class="btn btn-info">Add</button></a>

    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>MÃ SPCT</th>
        <th>ID KT</th>
        <th>ID MS</th>
        <th>ID SP</th>
        <th>SỐ LƯỢNG</th>
        <th>GIÁ BÁN</th>
        <th>TRẠNG THÁI</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list}" var="st" varStatus="i">
        <tr>
            <td>${i.index + 1} </td>
            <td>${st.id} </td>
            <td>${st.maSPCT}</td>
            <td>${st.idKichThuoc}</td>
            <td>${st.idMauSac}</td>
            <td>${st.idSanPham}</td>
            <td>${st.soLuong}</td>
            <td>${st.donGia}</td>
            <td>${st.trangThai?"có":"hết"}</td>
            <td><a href="/sanphamct/detail?id=${st.id}"><button type="button" class="btn btn-success">Detail</button></a>
                <a href="/sanphamct/view-update?id=${st.id}"><button type="button" class="btn btn-primary">Edit</button></a>
                <a href="/sanphamct/delete?id=${st.id}"><button type="button" class="btn btn-danger">Remove</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
