<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>关注人列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/font/font_3xfq2v964oyldi.css">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_7uqodo1etsp2e29.css">
    <!-- 需要联网的网络字体图标。也可下载到本地服务器直接调用，把路径引对即可 -->
    <link rel="stylesheet" type="text/css" href="/css/commone.css">
    <link rel="stylesheet" type="text/css" href="/css/popupBox.css">
    <link rel="stylesheet" type="text/css" href="/css/animation.css">
    <link rel="stylesheet" type="text/css" href="/jqueryBanner/css/bannerList.css">
    <link rel="stylesheet" type="text/css" href="/css/zsgc.css">
    <link rel="stylesheet" type="text/css" href="/css/search.css">
</head>
<script>
    function remoteFollower(secondUser) {
        window.location.href = "/relation/unfollow?secondUser=" + secondUser;
    }

</script>
<body>
<section class="featureShow_Wrapper">
    <h4 class="featureShow_breadcrumb"><a href="/user/index">返回主页</a></h4>
    <div class="featureShow_content">
        关注列表
        <ul>
            <c:choose>
                <c:when test="${followers==null}">
                    <div class="alert alert-dismissable alert-info">
                        <h4>
                            暂无关注的用户
                        </h4>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${followers}" var="f">
                        <li class="featureItem">
                            <a href="/homepage/myOwn?username=${f.username}" style="text-decoration:none" ;>
                                <img src="/photo/${f.userphoto}" width="50px" height="50px" class="imgWrap">
                                <h4>${f.username}</h4>
                            </a>
                            <div>
                                <button onclick="remoteFollower('${f.username}')">取消关注</button>
                                <p>${f.userbrief}dsfsdfsfsfds</p>
                            </div>
                            <div>
                            </div>
                        </li>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</section>
</body>
</html>
