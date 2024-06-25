<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Login</h1>
<form action="/trangchu/login" method="post">
    <%--    <lable>Tên Đăng Nhâp:</lable>--%>
    <%--    <input  name="username"><br>--%>
    <%--    <lab>passworld:</lab>--%>
    <%--    <input  name="pass"><br>--%>
    <div class="form-floating mb-3">
        <label for="floatingInput">Tên Đăng Nhập</label>
        <input type="text" class="form-control" name="username" id="floatingInput" placeholder="nhập tên đăng nhập">

    </div>
    <div class="form-floating">
        <label for="floatingPassword">Password</label>
        <input type="password" name="pass" class="form-control" id="floatingPassword" placeholder=" nhập Password">

    </div>
<%--    <div><input type="checkbox" name="remember">remember</div>--%>
    <button>Login</button>
</form>
</body>
</html>