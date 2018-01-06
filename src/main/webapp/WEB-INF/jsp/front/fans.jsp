<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>粉丝列表</title>
</head>
<body>
<c:forEach items="${fans}" var="f">
    ${f.username}
</c:forEach>
</body>
</html>
