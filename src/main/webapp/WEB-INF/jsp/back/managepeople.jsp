<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>人员管理</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function create() {
            window.location.href="/manager/createPage";
        }
    </script>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <button type="button" class="btn btn-default" style="float: right;margin: 10px" onclick="create()">
                新增管理员
            </button>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        管理员名字
                    </th>
                    <th>
                        权限
                    </th>
                    <th style="align: center">
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${managerList}" var="m">
                    <tr>
                        <td>
                                ${m.rootname}
                        </td>
                        <td>
                            <c:choose>
                                <%--<c:when test="${m.rootpower==0}">超级管理员</c:when>‘--%>
                                <c:when test="${m.rootpower==1}">用户管理员</c:when>
                                <c:otherwise>资讯管理员</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <button type="button" class="btn btn-sm" onclick="deleteManager('${m.rootname}')">删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
