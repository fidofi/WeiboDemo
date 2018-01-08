<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>用户管理</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script>
        //冻结
        function freeze(username) {
            var result =prompt("请输入冻结原因：");
            window.location.href = "/manager/freeze?username=" + username + "&freezeresult=" + result;
        }
        //解冻
        function unfreeze(username) {
            window.location.href = "/manager/unfreeze?username=" + username;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="navbar-form navbar-left" role="search" method="post" action="/manager/finduser">
                <div class="form-group">
                    <input type="text" class="form-control" name="username"/>
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        用户名
                    </th>
                    <th>
                        性别
                    </th>
                    <th>
                        状态
                    </th>
                    <th>
                        原因
                    </th>
                    <th>
                        管理员
                    </th>
                    <th th colspan="2" style="align: center">
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="u">
                    <tr>
                        <td>
                                ${u.username}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${u.usersex==true}">男</c:when>
                                <c:otherwise>女</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${u.userstatus==true}">冻结</c:when>
                                <c:otherwise>正常</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                                ${u.freezeResult}
                        </td>
                        <td>
                                ${u.rootName}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${u.userstatus}">
                                    <button type="button" class="btn btn-sm" onclick="unfreeze('${u.username}')">解冻
                                    </button>
                                </c:when>
                                <c:otherwise>
                                    <button type="button" class="btn btn-sm" disabled>解冻</button>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${u.userstatus}">
                                    <button type="button" class="btn btn-sm" disabled>冻结</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <button type="button" class="btn btn-sm" onclick="freeze('${u.username}')">冻结</button>
                                </c:otherwise>
                            </c:choose>
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
