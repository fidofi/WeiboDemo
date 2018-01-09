<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户的未读通知</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function doReadComment(commentid) {
            window.location.href = "/user/doReadComment?commentid=" + commentid;
        }

        function doReadRelay(relayid) {
            window.location.href = "/user/doReadRelay?relayid=" + relayid;
        }


    </script>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <a href="/user/index">返回主页</a>

            <h3>—未读评论列表</h3>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
                        用户
                    </th>
                    <th>
                        评论内容
                    </th>
                    <th>
                        评论时间
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${commentList}" var="comment">
                    <tr>
                        <td>
                                ${comment.username}
                        </td>
                        <td>
                                ${comment.commenttext}
                        </td>
                        <td>
                                ${comment.commenttime}
                        </td>
                        <td>
                            <button type="button" class="btn btn-sm" onclick="doReadComment('${comment.commentid}')">
                                已读
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <h3>—未读转发消息列表</h3>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
                        用户
                    </th>
                    <th>
                        转发内容
                    </th>
                    <th>
                        转发时间
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${relayList}" var="relay">
                    <tr>
                        <td>
                                ${relay.username}
                        </td>
                        <td>
                                ${relay.relaytext}
                        </td>
                        <td>
                                ${relay.relaytime}
                        </td>
                        <td>
                            <button type="button" class="btn btn-sm" onclick="doReadRelay('${relay.relayid}')">已读
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
