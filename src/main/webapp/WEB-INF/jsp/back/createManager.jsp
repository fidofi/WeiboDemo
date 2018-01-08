<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>新增管理员</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h2 class="text-center">
                录入管理员信息
            </h2>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/manager/createManager" method="post" style="margin-left: 400px;margin-top: 80px;">
                <div class="form-group">
                    <label>管理员用户名：</label><input type="text" class="form-control" name="rootname"
                                                 style="width:160px;display: inline-block"/>
                </div>
                <div class="form-group">
                    <label>密码：</label><input type="password" class="form-control" name="rootpassword"
                                             style="width:100px;display: inline-block"/>
                </div>
                <div class="from-group">
                    <label>权限：</label>
                    <input type="radio" name="rootpower" value="1"/> 用户管理员
                    <input type="radio" name="rootpower" value="2"/> 资讯管理员
                </div>
                <button type="submit" class="btn btn-default" style="text-align: center">增加</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
