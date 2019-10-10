<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/9/12
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <title>登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <%--suppress JSUnresolvedLibraryURL --%>
    <%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
    <script src="js/jquery-3.4.1.min.js"></script>

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <link href="<%=request.getContextPath()%>/CSS/style.css?v=20180201"  rel="stylesheet" type="text/css" />


</head>
<body>

    <div class="container">
        <form class="form-signin" action="${pageContext.request.contextPath}/loginServlet" method="post">
            <h2 class="form-signin-heading">欢迎登录！</h2>
            <br>
            <label for="username" class="sr-only" >车牌号</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="请输入您的车牌号" required autofocus>

            <label for="password" class="sr-only" >密码</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="请输入您的密码" required>

            <select name="role" style="margin-top: 1.5%">
                <option value ="user">普通用户</option>
                <option value ="administrator">管理员</option>
            </select>

            <div style="margin-top: 5%">
                <input type="text" value="" placeholder="请输入验证码（不区分大小写）" class="input-val">
                <canvas id="canvas" width="100" height="30"></canvas>
            </div>

            <br><br>
            <input  type="submit" class="btn" style="width:145px;" value="登录">
            没有账号？<a href="${pageContext.request.contextPath}/register.jsp">立即注册！</a>
        </form>

    </div>

</body>
</html>

<script>
    $(function(){
        var show_num = [];
        draw(show_num);

        $("#canvas").on('click',function(){
            draw(show_num);
        })
        $(".btn").on('click',function(){
            var val = $(".input-val").val().toLowerCase();
            var num = show_num.join("");
            if(val==''){
                alert('请输入验证码！');
                return false;
            }else if (val != num) {
                alert('验证码错误！请重新输入！');
                $(".input-val").val('');
                return false;

            } else {
                return true;
            }
        })


        //取出传回来的参数error并与yes比较
        var error ='<%=request.getParameter("error")%>';
        var result ='<%=request.getParameter("result")%>';
        if(error == 'yes'){
            alert("登录失败，用户名或密码错误！");
        }
        if(result == 'yes'){
            alert("注册成功，欢迎登录！");
        }
    })

    //生成并渲染出验证码图形
    function draw(show_num) {
        var canvas_width=$('#canvas').width();
        var canvas_height=$('#canvas').height();
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "a,b,c,d,e,f,g,h,i,j,k,m,n,p,q,r,s,t,u,v,w,x,y,z,A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度

        for (var i = 0; i < 4; i++) {  //这里的for循环可以控制验证码位数（如果想显示6位数，4改成6即可）
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            // var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
            var deg = Math.random() - 0.5; //产生一个随机弧度
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt.toLowerCase();
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";

            context.translate(x, y);
            context.rotate(deg);

            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);

            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }

    //得到随机的颜色值
    function randomColor() {
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }

</script>
<%--<script>--%>
    <%--/**生成一个随机数**/--%>
    <%--function randomNum(min,max){--%>
        <%--return Math.floor( Math.random()*(max-min)+min);--%>
    <%--}--%>
    <%--/**生成一个随机色**/--%>
    <%--function randomColor(min,max){--%>
        <%--var r = randomNum(min,max);--%>
        <%--var g = randomNum(min,max);--%>
        <%--var b = randomNum(min,max);--%>
        <%--return "rgb("+r+","+g+","+b+")";--%>
    <%--}--%>
    <%--drawPic();--%>
    <%--document.getElementById("changeImg").onclick = function(e){--%>
        <%--e.preventDefault();--%>
        <%--drawPic();--%>
    <%--}--%>

    <%--/**绘制验证码图片**/--%>
    <%--function drawPic(){--%>
        <%--var canvas=document.getElementById("canvas");--%>
        <%--var width=canvas.width;--%>
        <%--var height=canvas.height;--%>
        <%--var ctx = canvas.getContext('2d');--%>
        <%--ctx.textBaseline = 'bottom';--%>

        <%--/**绘制背景色**/--%>
        <%--ctx.fillStyle = randomColor(180,240); //颜色若太深可能导致看不清--%>
        <%--ctx.fillRect(0,0,width,height);--%>
        <%--/**绘制文字**/--%>
        <%--var str = 'ABCEFGHJKLMNPQRSTWXY123456789';--%>
        <%--for(var i=0; i<4; i++){--%>
            <%--var txt = str[randomNum(0,str.length)];--%>
            <%--ctx.fillStyle = randomColor(50,160);  //随机生成字体颜色--%>
            <%--ctx.font = randomNum(30,40)+'px SimHei'; //随机生成字体大小--%>
            <%--var x = 10+i*25;--%>
            <%--var y = randomNum(25,45);--%>
            <%--var deg = randomNum(-45, 45);--%>
            <%--//修改坐标原点和旋转角度--%>
            <%--ctx.translate(x,y);--%>
            <%--ctx.rotate(deg*Math.PI/180);--%>
            <%--ctx.fillText(txt, 0,0);--%>
            <%--//恢复坐标原点和旋转角度--%>
            <%--ctx.rotate(-deg*Math.PI/180);--%>
            <%--ctx.translate(-x,-y);--%>
        <%--}--%>
        <%--/**绘制干扰线**/--%>
        <%--for(var i=0; i<5; i++){--%>
            <%--ctx.strokeStyle = randomColor(40,180);--%>
            <%--ctx.beginPath();--%>
            <%--ctx.moveTo( randomNum(0,width), randomNum(0,height) );--%>
            <%--ctx.lineTo( randomNum(0,width), randomNum(0,height) );--%>
            <%--ctx.stroke();--%>
        <%--}--%>
        <%--/**绘制干扰点**/--%>
        <%--for(var i=0; i<30; i++){--%>
            <%--ctx.fillStyle = randomColor(0,255);--%>
            <%--ctx.beginPath();--%>
            <%--ctx.arc(randomNum(0,width),randomNum(0,height), 1, 0, 2*Math.PI);--%>
            <%--ctx.fill();--%>
        <%--}--%>
    <%--}--%>

    <%--$("#submit").on('click',function(){--%>
        <%--var val = $(".input-val").val().toLowerCase();--%>
        <%--var num = show_num.join("");--%>
        <%--if(val==''){--%>
            <%--alert('请输入验证码！');--%>
        <%--}else if(val == num){--%>
            <%--alert('提交成功！');--%>
            <%--$(".input-val").val('');--%>
            <%--// draw(show_num);--%>

        <%--}else{--%>
            <%--alert('验证码错误！请重新输入！');--%>
            <%--$(".input-val").val('');--%>
            <%--// draw(show_num);--%>
        <%--}--%>
    <%--})--%>

<%--</script>--%>



