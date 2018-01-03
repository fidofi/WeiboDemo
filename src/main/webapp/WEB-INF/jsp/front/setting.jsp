<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户个人资料设置</title>
    <link rel="shortcunt icon" type="/image/x-icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="/css/common.css">
    <link type="text/css" rel="stylesheet" href="/css/setting.css">
</head>
<body>
<div class="header">
    <div class="headerbar">
        <h1 class="logo">
            <a href="index.html">PIIO</a>
        </h1>
        <div class="publish">
            <a href="javascript:void(0);">发布</a>
        </div>
        <div class="nav">
            <ul>
                <li><a href="#">私信</a></li>
                <li><a href="#">通知</a></li>
                <li class="account">
                    <a href="homepage.html">Fstar</a>
                    <div class="account-panel">
                        <ul>
                            <li><a href="setting.html">设置</a></li>
                            <li><a href="signin.html">退出</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

    </div>
</div>
<div></div>
    <div class="settingbox">
        <div class="s-title">账号设置</div>
        <div class="imgbox">
            <img src="/images/setting-icon.png" alt="头像">
            <div class="icon-bg"></div>
            <span class="txt-changeicon">更换头像</span>
        </div>
        <!--更改资料表单-->
        <div class="txtbox">
            <form action="/user/updateUser" method="post">
                <div class="s-nick">
                    <label>名称</label>
                    <input type="text" name="username" value="${updateUser.username}" readonly/>
                </div>
                <div class="s-sex" style="margin-top: 15px">
                    <label>性别</label>
                    <c:choose>
                        <c:when test="${updateUser.usersex}">
                            <select name="usersex">
                                <option value="true" selected>男</option>
                                <option value="false">女</option>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <select name="usersex">
                                <option value="true">男</option>
                                <option value="false" selected>女</option>
                            </select>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="s-sign" style="margin-top: 15px">
                    <label class="l-sign">签名</label>
                    <textarea class="txt-sign" name="userbrief">${updateUser.userbrief}</textarea>
                </div>
                <button class="s-submit">保存</button>
            </form>
        </div>
    </div>
</body>
</html>

