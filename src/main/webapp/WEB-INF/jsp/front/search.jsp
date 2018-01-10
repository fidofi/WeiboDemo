<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索界面</title>
    <link rel="stylesheet" type="text/css" href="/css/font/font_3xfq2v964oyldi.css">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_7uqodo1etsp2e29.css">
    <!-- 需要联网的网络字体图标。也可下载到本地服务器直接调用，把路径引对即可 -->
    <link rel="stylesheet" type="text/css" href="/css/commone.css">
    <link rel="stylesheet" type="text/css" href="/css/popupBox.css">
    <link rel="stylesheet" type="text/css" href="/css/animation.css">
    <link rel="stylesheet" type="text/css" href="/jqueryBanner/css/bannerList.css">
    <link rel="stylesheet" type="text/css" href="/css/zsgc.css">
    <link rel="stylesheet" type="text/css" href="/css/search.css">
    <script>
        function follow(username) {
            window.location.href = "/relation/follow?secondUser=" + username;
        }
    </script>
</head>
<body>
<section class="featureShow_Wrapper">
    <h4 class="featureShow_breadcrumb"><a href="/user/index">返回主页</a></h4>
    <div class="featureShow_content">
        <ul>
            <c:forEach items="${userList}" var="u">
                <li class="featureItem">
                    <a href="#" style="text-decoration:none" ;>
                        <img src="/photo/${u.user.userphoto}" width="50px" height="50px" class="imgWrap">
                        <h4>${u.user.username}</h4>
                    </a>
                    <div>
                        <c:choose>
                            <c:when test="${u.follow}">
                                <button name="username">已关注</button>
                            </c:when>
                            <c:otherwise>
                                <button name="username" onclick="follow('${u.user.username}')"
                                >关注
                                </button>
                            </c:otherwise>
                        </c:choose>
                        <p>${u.user.userbrief}dsfsdfsfsfds</p>
                    </div>
                    <div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>
<section class="knowledgeSquare">
    <!-- 卡片式文章（有图片） -->
    <article>
        <div class="knowledgeSquareWrapper">
            <c:forEach items="${newsList}" var="news">
                <article>
                    <div class="knowledgeSquareContent">
                        <div class="imgWrap user-icon"><a href="#"><img src="/photo/${news.user.userphoto}" alt="用户个人头像" style="height:60px;width: 60px"></a></div>
                        <div class="article-title">
                            <h4 class="article-content-title">${news.user.username}</h4>
                            <p class="user-editInfo">发表于&nbsp;&nbsp;<span
                                    class="user-editTime">${news.newstime}</span></p>
                        </div>
                        <div class="article-content">
                            <p>
                                <!-- 图片 -->
                            <div class="article-content-img">
                            <img  src="/photo/${news.newsphoto}" alt="文章配图" style="height: 100px;width: 100px" />
                        </div>
                            <%--<img  src="/photo/${news.newsphoto}" alt="文章配图"--%>
                                 <%--style="border:10px solid #66CCFF; position: absolute; left:16em; top:50%; transform: translateY(-50%); z-index: 99; display: none;">--%>
                            <!-- 文字内容 -->
                            <p>${news.newstext} </p>
                        </div>
                        <div class="article-operate">
                            <div class="article-operate-item-wrap">
                                <div class="article-operate-item">
                                <span class="collect"><i class="iconfont icon-star"></i><span
                                        class="article-operate-item-txt">转发</span></span>
                                </div>
                            </div>
                            <div class="hr-line"></div>
                            <div class="article-operate-item-wrap">
                                <div class="article-operate-item">
                                <span class="share"><i class="iconfont icon-fenxiang1"></i><span
                                        class="article-operate-item-txt">喜欢</span></span>
                                </div>
                            </div>
                            <div class="hr-line"></div>
                            <div class="article-operate-item-wrap">
                                <div class="article-operate-item">
                                <span class="comment"><i class="iconfont icon-pinglun"></i><span
                                        class="article-operate-item-txt">评论</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </div>
    </article>
    </div>
    </article>
</section>
</body>
</html>
