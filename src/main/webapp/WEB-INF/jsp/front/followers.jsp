<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>关注人列表</title>
</head>
<body>
<c:forEach items="${followers}" var="follow">
    ${follow.username}
</c:forEach>
</body>
</html>
