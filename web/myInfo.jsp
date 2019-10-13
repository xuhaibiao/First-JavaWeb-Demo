<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/9/14
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

    <style>
        td,tr{
            text-align: center;
        }
    </style>
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
            <a class="navbar-brand" href="#">
                <%
                    String username =(String)request.getAttribute("username");
                    out.write(username);
                %>
                ，欢迎您！
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li role="presentation"><a href="${pageContext.request.contextPath}/userInfoServlet">我的停车信息</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/getNullServlet">空停车位查询</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/changePassword.jsp">更改密码</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/help.jsp">用户手册</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">钱包<span class="caret"></span></a>
                    <ul  class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/addMoney.jsp">充值</a></li>
                        <li id="pay"><a href="${pageContext.request.contextPath}/payServlet">缴费</a></li>
                    </ul>
                </li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div class="col-md-6 col-md-offset-3">
    <table class="table table-bordered table-hover">
        <tr>
            <td>所停车位号码</td>
            <td>车牌号</td>
            <td>驶入时间</td>
            <td>停车时长</td>
            <td>所需费用</td>
            <td>卡内余额</td>
        </tr>
        <c:forEach items="${myInfo}" var="myInfo">
        <tr>
            <td>${myInfo.get(0).getId()}</td>
            <td>${myInfo.get(0).getCarNumber()}</td>
            <td>${myInfo.get(0).getTime()}</td>
            <td>${myInfo.get(1)}</td>
            <td>${myInfo.get(2)}</td>
            <td>${myInfo.get(3)}</td>
        </tr>
        </c:forEach>

</div>
</table>

</body>
</html>

<script>
    var result ='<%=request.getParameter("result")%>';
    var error = '<%=request.getParameter("payError")%>'

    if(result == 'yes'){
        alert("密码更改成功！");
    }
    if (error == 'yes') {
        alert("缴费失败！余额不足");
    } else if (error == 'no') {
        alert("缴费成功！");
    }else if (error == 'noCar') {
        alert("没有停车，无需缴费!");
    }

</script>


