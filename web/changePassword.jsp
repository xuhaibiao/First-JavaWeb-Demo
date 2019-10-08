<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/9/16
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改密码</title>

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <link href="CSS/style.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/changePasswordServlet" method="post">
        <h2 class="form-signin-heading">更改密码！</h2>
        <br>
        <label for="old" class="sr-only" >原密码</label>
        <input type="password" id="old" name="old" class="form-control" placeholder="请输入您的原密码" required autofocus>
        <label for="new" class="sr-only" >新密码</label>
        <input type="password" id="new" name="new" class="form-control" placeholder="请输入您的新密码" required>
        <br><br>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="确定更改">
    </form>

</div>

</body>
</html>

<script>
    //取出传回来的参数error并与yes比较
    var error ='<%=request.getParameter("error")%>';
    if(error == 'yes') {
        alert("更改失败，请输入正确的原密码！");
    }
</script>
