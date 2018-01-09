<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="shortcunt icon" type="/image/x-icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="/css/common.css">
    <link type="text/css" rel="stylesheet" href="/css/index.css">
    <script type="text/javascript" src="/js/jquery-1.8.2.min.js"></script>
    <script>
        <!--这里有点问题-->
        var flag = false;
        function comment(i) {
            var div = document.getElementById("commentID" + i);

            if (!flag)
                div.style.display = "block";
            else
                div.style.display = "none";
            flag = !flag;
        }

        function doComment(i) {
            var1 = $("#cnt" + i).html();
            document.getElementById("textt" + i).value = var1;
            document.getElementById("commentForm" + i).submit();
        }

        function relay(newsid) {
            var result = prompt("请输入转发内容：");
            window.location.href = "/user/relayNews?newsId=" + newsid + "&relayText=" + result;
        }
    </script>
</head>
<body>
<div class="header">
    <div class="headerbar">
        <h1 class="logo">
            <a href="index.html">FIDO</a>
        </h1>
        <div class="publish">
            <a href="javascript:void(0);">发布</a>
        </div>
        <div class="nav">
            <ul>
                <li>
                    <form action="/search" method="post">
                        <input type="text" name="search"/>
                        <input type="submit" value="搜索" style="height: 30px"/>
                    </form>
                </li>
                <li>
                    <a href="#">私信</a>
                    <div class="num">6</div>
                </li>
                <li>
                    <a href="/user/getNotice">通知</a>
                    <div class="num">14</div>
                </li>
                <li class="account">
                    <a href="/user/index">${sessionScope.user.username}</a>
                    <div class="account-panel">
                        <ul>
                            <li class="panel1"><a href="/user/setting">设置</a></li>
                            <li class="panel2"><a href="/user/logout">退出</a></li>
                            <li class="panel2"><a href="/user/changePassPage">更改密码</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

    </div>
</div>
<div class="main">
    <div class="content">
        <c:forEach items="${followNews}" var="news" varStatus="i">
            <div class="item">
                <div class="item-main">
                    <!-- 说说1 -->
                    <div class="u-info">
                            <%--<div class="item-more-ation">--%>
                            <%--<span></span>--%>
                            <%--</div>--%>
                        <div class="u-icon">
                            <img src="/photo/${news.user.userphoto}" alt="IVEN-木罐"/>
                        </div>
                        <div class="name-pub">
                            <div class="u-name">
                                <a href="">${news.user.username}</a>
                            </div>
                            <div class="u-pub">
                                    ${news.newstime}
                            </div>
                        </div>
                    </div>
                    <div class="itemcontent">
                        <c:if test="${news.newsphoto!=null}">
                            <div class="thumbnail">
                                <img src="/photo${news.newsphoto}" alt="img1">
                            </div>
                        </c:if>
                        <div class="full-text">
                            <p>
                                    ${news.newstext}</p>
                        </div>
                    </div>
                    <div class="u-list">
                        <ul>
                            <li><a class="arrow-warp" onclick="relay('${news.newsid}')"><span>转发</span>
                                <span>${news.newsrelay}</span>
                                <span class="arrow"></span>
                            </a></li>
                            <li>
                                <a onclick="comment('${i.count}')" class="arrow-warp">
                                    <span>评论</span>
                                    <span>${news.newscomment}</span>
                                    <span class="arrow"></span>
                                </a>

                            </li>
                            <li><a href="/news/like?newsid=${news.newsid}"><span>喜欢</span><span> ${news.newslike}</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- 评论盖楼 -->
                <div class="item-repeat" id="commentID${i.count}" style="display: none">
                    <!-- 评论输入 -->
                    <form id="commentForm${i.count}" method="post" action="/comment/create">
                        <div class="self-repeat">
                            <div class="repeat-inputtxt" id="cnt${i.count}" contenteditable="true"></div>
                            <input type=hidden name="commentText" id="textt${i.count}">
                            <input type=hidden name="newsId" value="${news.newsid}">
                            <button type="button" class="repeat-inputtxt-btn" onclick="doComment(${i.count})"
                            >
                                评 论
                            </button>
                        </div>
                    </form>
                    <div class="repeat-list">
                        <div class="repeat-icon">
                            <a href="javascript:void(0)">
                                <img src="./images/user3.png" alt="葵花妹" width="30px">
                            </a>
                        </div>
                        <!-- 其他用户的回复 -->
                        <c:forEach items="${news.commentList}" var="comment">
                            <div class="repeat-content">
                                <div class="repeat-content-text">
                                    <a href="javascript:void(0);">${comment.username}</a>
                                        ${comment.commenttext}
                                </div>
                                <div class="repeat-content-func">
                                    <div class="repeat-time">
                                            ${comment.commenttime}
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <!-- end -->
            </div>
        </c:forEach>
        <c:forEach items="${followRelays}" var="relays">
        <div class="item">
        <div class="item-main">
            <!-- 说说1 -->
            <div class="u-info">
                    <%--<div class="item-more-ation">--%>
                    <%--<span></span>--%>
                    <%--</div>--%>
                <div class="u-icon">
                    <img src="/photo/" alt="IVEN-木罐"/>
                </div>
                <div class="name-pub">
                    <div class="u-name">
                        <a href="">${relays.user.username}</a>
                    </div>
                    <div class="u-pub">
                            ${relays.relaytime}
                    </div>
                </div>
            </div>
            ${relays.relaytext}
            <div class="itemcontent">
                <c:if test="${relays.news.newsphoto!=null}">
                    <div class="thumbnail">
                        <img src="/photo${relays.news.newsphoto}" alt="img1">
                    </div>
                </c:if>
                <div class="full-text">
                    <p>
                            ${relays.news.newstext}</p>
                </div>
            </div>
            <%--<div class="u-list">--%>
                <%--<ul>--%>
                    <%--<li><a class="arrow-warp" onclick="relay('${news.newsid}')"><span>转发</span>--%>
                        <%--<span>${relays.news.newsrelay}</span>--%>
                        <%--<span class="arrow"></span>--%>
                    <%--</a></li>--%>
                    <%--<li>--%>
                        <%--<a onclick="comment('${i.count}')" class="arrow-warp">--%>
                            <%--<span>评论</span>--%>
                            <%--<span>${relays.news.newscomment}</span>--%>
                            <%--<span class="arrow"></span>--%>
                        <%--</a>--%>

                    <%--</li>--%>
                    <%--<li><a href="/news/like?newsid=${news.newsid}"><span>喜欢</span><span> ${news.newslike}</span></a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </div>
    </div>

    </c:forEach>
</div>
</div>
<div class="p-info">
    <div class="p-icon">
        <img src="/photo/${sessionScope.user.userphoto}" alt="picon" style="width: 100px;height: 100px">
    </div>
    <div class="p-name"><a href="homepage.html">${sessionScope.user.username}</a></div>
    <div class="p-intro">${sessionScope.user.userbrief}</div>
    <div class="p-profile">
        <ul>
            <li><a href="/relation/getFollowers?userName=${sessionScope.user.username}">
                <span>关注</span>
                <span class="p-following">14</span>
            </a></li>
            <li><a href="/relation/getFans?userName=${sessionScope.user.username}">
                <span>粉丝</span>
                <span class="p-followed">5</span>
            </a></li>
            <li><a href="/homepage/myOwn?username=${sessionScope.user.username}">
                <span>说说</span>
                <span class="p-publish">3</span>
            </a></li>
        </ul>
    </div>
</div>
</div>
<a id="gotop" href="#">回到顶部</a>
<!-- 发布布局 -->
<div class="opacity-bg" style="display:none"></div>
<div class="post" style="display:none;top:100px;left:200px;">
    <div class="post-title">说点什么</div>
    <div class="post-close">关闭</div>
    <div class="post-input">
        <form action="/news/publish" enctype="multipart/form-data" method="post">
            <textarea name="newstext"></textarea>
            <input type="file" class="file" name="photo" id="pic" accept="image/jpeg"/>
            <input type="submit" class="post-btn" name="button"/>
        </form>
    </div>
</div>

<script type="text/javascript" src="/js/publish.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
</body>
</html>
