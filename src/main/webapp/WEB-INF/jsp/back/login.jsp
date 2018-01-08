<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>选课系统管理员登录界面</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                微博后台登录界面
            </h3>
            <div style="width: 250px;margin: 100px auto">
                <form class="form-horizontal" role="form" action="/manager/index" method="post"
                      style="text-align: center;margin: 0 auto">
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> 用户名:</label><input type="text" class="form-control" name="rootname"
                                                       placeholder="请输入用户名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> 密码:</label> <input type="password" class="form-control" name="rootpassword"
                                                       placeholder="请输入密码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label><input type="checkbox" name="remember"/>记住密码</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">登录</button>
                        </div>
                    </div>
                </form>
                <c:if test="${loginMesg!=null}">
                    <div class="alert alert-dismissable alert-warning">
                        <h4>
                            注意!
                        </h4>
                            ${loginMesg}
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</body>
</html>
