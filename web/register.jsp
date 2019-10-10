<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/9/12
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <link href="<%=request.getContextPath()%>/CSS/style.css?v=20180201"  rel="stylesheet" type="text/css" />


    <%--<script>--%>
        <%--window.onload = function () {--%>

            <%--document.getElementById("form").onsubmit = function () {--%>
                <%--return checkUsername() && checkPassword();--%>
            <%--}--%>


            <%--document.getElementById("username").onblur = function () {--%>
                <%--checkUsername();--%>
            <%--}--%>
            <%--document.getElementById("password").onblur = function () {--%>
                <%--checkPassword();--%>
            <%--}--%>

            <%--function checkUsername() {--%>
                <%--var username = document.getElementById("username").value;--%>
                <%--var reg = /^\w{6,12}$/;--%>
                <%--var tag = reg.test(username);--%>
                <%--if (tag) {--%>
                    <%--document.getElementById("s_username").innerHTML = "✔";--%>
                <%--} else {--%>
                    <%--document.getElementById("s_username").innerHTML = "❌";--%>
                <%--}--%>
                <%--return tag;--%>
            <%--}--%>

            <%--function checkPassword() {--%>
                <%--var password = document.getElementById("password").value;--%>
                <%--var reg = /^\w{6,12}$/;--%>
                <%--var tag = reg.test(password);--%>
                <%--if (tag) {--%>
                    <%--document.getElementById("s_password").innerHTML = "✔";--%>
                <%--} else {--%>
                    <%--document.getElementById("s_password").innerHTML = "❌";--%>
                <%--}--%>
                <%--return tag;--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>

</head>
<body>
<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/registerServlet" onsubmit="return checkFrom()" method="post">
        <h2 class="form-signin-heading">欢迎注册！</h2>
        <br>

        <label for="username" class="sr-only" >车牌号</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="请输入您的车牌号" onblur="checkUsername()"  required autofocus>
        <span id="s_username"></span>
        <br>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="请输入6~12位密码" onblur="checkPassword()" required>
        <span id="s_password"></span>

        <br><br>
        <input type="submit" class="btn" style="width:145px;display:inline-block" value="注册">
        <input type="button" class="btn" style="width:145px;display:inline-block" onclick="javascript:history.back(-1);" value="返回">
    </form>

</div>

<script>
    function checkFrom() {
        if (!(checkUsername() && checkUsername())) {
            alert("请规范输入！");
            return false;
        }
    }

    function checkUsername() {
        var username = document.getElementById("username").value;
        var reg =  /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        var tag = reg.test(username);
        if (tag) {
            document.getElementById("s_username").innerHTML = "✔";
        } else {
            document.getElementById("s_username").innerHTML = "❌";
        }
        return tag;
    }

    function checkPassword() {
        var password = document.getElementById("password").value;
        var reg = /^\w{6,12}$/;
        var tag = reg.test(password);
        if (tag) {
            document.getElementById("s_password").innerHTML = "✔";
        } else {
            document.getElementById("s_password").innerHTML = "❌";
        }
        return tag;
    }
</script>

</body>
</html>
