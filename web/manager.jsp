<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/9/9
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <link href="<%=request.getContextPath()%>/CSS/style.css?v=20180201"  rel="stylesheet" type="text/css" />

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">ParkingLok</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li role="presentation" class="active"><a href="#">首页</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/plInfoListServlet">车辆分布情况查看</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/login.jsp">客户端登录</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/driveInServlet" method="post">
        <br>
        <label for="carNumberIn" class="sr-only">车牌号码</label>
        <input type="text" class="form-control" name="carNumberIn" id="carNumberIn" placeholder="请输入车牌号..." required autofocus>
        <label for="id" class="sr-only">停车位号码</label>
        <input type="text" class="form-control" name="id" id="id" placeholder="停车位号码..." required>
        <br><br>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="驶入">

    </form>
</div>


<br>
<br>
<hr>
<br>
<br>

<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/driveOutServlet" method="post">
        <br>
        <label for="carNumberOut" class="sr-only">车牌号码</label>
        <input type="text" class="form-control" name="carNumberOut" id="carNumberOut" placeholder="请输入车牌号..." required autofocus>
        <br><br>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="驶出">
    </form>
</div>

</body>
</html>

<script>

    var inResult ='<%=request.getAttribute("inResult")%>';
    var outResult ='<%=request.getAttribute("outResult")%>';

    if(inResult == 'yes'){
        alert("驶入成功！");
    }
    if(outResult == 'yes'){
        alert("驶出成功！");
    }
</script>

