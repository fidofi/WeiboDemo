<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>weibo登录</title>
    <link rel="shortcunt icon" type="image/x-icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="/css/signin.css">
    <link rel="stylesheet" href="/css/jquery-labelauty.css">
</head>
<body>
<div class="wrap">
    <div class="logo">
        <h1>FIDOWEIBO</h1>
        <h2>与朋友一起，分享你的生活</h2>
    </div>
    <div class="box">
        <ul>
            <li>注册</li>
            <li class="selected">登录</li>

        </ul>
        <!-- sign up注册 -->
        <form id="signup" style="display:none" method="post" action="/user/register">
            <div class="mail-inputbox inputbox">
                <input type="text" name="username" placeholder="用户名"/>
            </div>
            <div class="pw-inputbox inputbox">
                <input type="password" name="userpassword" placeholder="密码"/>
            </div>
            <div>
                <ul class="dowebok">
                    <li><input type="radio" name="usersex" value="0"/>男</li>
                    <li><input type="radio" name="usersex" value="1"/>女</li>
                </ul>
            </div>
            <div class="pwc-inputbox inputbox">
                <input type="password" name="confirmpassword" placeholder="确认密码"/>
            </div>
            <input type="submit" name="up-btn" class="up-btn" value="注册">
            <div style="margin-top: 10px">
                <h4>
                    ${registerMesg}
                </h4>
            </div>
        </form>
        <!-- 登录 -->
        <form id="signin" action="/user/index" method="post">
            <div class="mail-inputbox inputbox">
                <input type="text" name="username" id="username" placeholder="用户名"/>
            </div>
            <div class="pw-inputbox inputbox">
                <input type="password" name="userpassword" id="password" placeholder="密码"/>
            </div>
            <input type="submit" name="up-btn" class="up-btn" value="登录">
            <div style="margin-top: 10px">
                <h4>
                    ${loginMesg}
                </h4>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        // 选项表切换
        var box = document.getElementsByClassName('box')[0];
        var u = box.getElementsByTagName('li')[0];
        var i = box.getElementsByTagName('li')[1];
        i.onclick = function () {
            i.className = "selected";
            u.className = "";
            document.forms[0].style.display = "none";
            document.forms[1].style.display = "block";

        }
        u.onclick = function () {
            u.className = "selected";
            i.className = "";
            document.forms[1].style.display = "none";
            document.forms[0].style.display = "block";
        }
    </script>
</div>
</body>
</html>
