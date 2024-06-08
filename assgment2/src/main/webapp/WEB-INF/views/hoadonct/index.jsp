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
<form action="/hoadonct/search">
    ID HDCT: <input name="id"/>
    <button type="submit">Search</button>
</form>
<%--<br/>--%>
<%--<a href="/hoadonct/view-add"><button type="button" class="btn btn-info">Add</button></a>--%>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>ID </th>
        <th>ID HOA DON</th>
        <th>ID SPCT</th>
        <th>SỐ LƯỢNG</th>
        <th>ĐƠN GIÁ</th>
        <th>TRẠNG THÁI</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="st" varStatus="i">
        <tr>
            <td>${i.index + 1} </td>
            <td>${st.id} </td>
            <td>${st.idHoaDon}</td>
            <td>${st.idSPCT}</td>
            <td>${st.soLuong}</td>
            <td>${st.donGia}</td>
            <td>${st.trangThai?"Đã thanh toán":"Chưa thanh toán"}</td>
            <td>
                <a href="/hoadonct/view-update?id=${st.id}"><button type="button" class="btn btn-primary">Update</button></a>
                <a href="/hoadonct/delete/${st.id}"><button type="button" class="btn btn-danger">Remove</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
