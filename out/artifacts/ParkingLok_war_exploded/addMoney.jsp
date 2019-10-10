<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/9/14
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值</title>

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <link href="CSS/style.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/addMoneyServlet" method="post">
        <h2 class="form-signin-heading">欢迎充值！</h2>
        <br>
        <label for="money" class="sr-only" >充值金额</label>
        <input type="text" id="money" name="money" class="form-control" placeholder="请输入您的充值金额" required autofocus>
        <br><br>
        <input type="submit" class="btn" style="width:145px;display:inline-block" value="充值">
        <input type="button" class="btn" style="width:145px;display:inline-block" onclick="javascript:history.back(-1);" value="返回">
    </form>

</div>

</body>
</html>
