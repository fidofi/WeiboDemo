<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>管理员后台首页</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:if test="${powerMesg!=null}">
    <div class="alert alert-dismissable alert-warning">
        <h4>
            注意!
        </h4>
            ${powerMesg}
    </div>
</c:if>
</body>
</html>
