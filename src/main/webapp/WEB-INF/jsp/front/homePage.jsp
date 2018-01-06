<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的主页 PIIO</title>
    <link rel="shortcunt icon" type="/image/x-icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/homepage.css">
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
//            $("textt" + i).val(var1);
            document.getElementById("textt" + i).value = var1;
            document.getElementById("commentForm" + i).submit();
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
                    <a href="#">通知</a>
                    <div class="num">14</div>
                </li>
                <li class="account">
                    <a href="homepage.html">${user.username}</a>
                    <div class="account-panel">
                        <ul>
                            <li class="panel1"><a href="/user/setting">设置</a></li>
                            <li class="panel2"><a href="/user/logout">退出</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

    </div>
</div>

<div class="banner">
    <div class="p-info">
        <div class="p-icon">
            <img src="images/person-icon.png" alt="picon">
        </div>
        <div class="p-name"><a href="homepage.html">${currentUser.username}</a></div>
        <div class="p-intro">${currentUser.userbrief}</div>
        <div class="p-profile">
            <ul>
                <li><a href="#">
                    <span>关注</span>
                    <span class="p-following">14</span>
                </a></li>
                <li><a href="#">
                    <span>粉丝</span>
                    <span class="p-followed">5</span>
                </a></li>
                <!--    <li><a href="#">
                        <span>说说</span>
                        <span class="p-publish">3</span>
                    </a></li>-->
            </ul>
        </div>
    </div>
</div>
<div class="main">
<div class="content">
    <c:forEach items="${newsList}" var="news" varStatus="i">
        <div class="item">
            <div class="item-main">
                <!-- 说说1 -->
                <div class="u-info">
                        <%--<div class="item-more-ation">--%>
                        <%--<span></span>--%>
                        <%--</div>--%>
                    <div class="u-icon">
                        <img src="/images/user1.png" alt="IVEN-木罐"/>
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
                            <img src="/images/img2.png" alt="img1">
                        </div>
                    </c:if>
                    <div class="full-text">
                        <p>
                                ${news.newstext}</p>
                    </div>
                </div>
                <div class="u-list">
                    <ul>
                        <li><a href="#" class="arrow-warp"><span>转发</span>
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
                        <li><a href="#"><span>喜欢</span><span> ${news.newslike}</span></a></li>
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
                                <a href="javascript:void(0);">葵花妹</a>
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
</div>
</div>

<a id="gotop" href="#">回到顶部</a>
<!-- 发布布局 -->
<div class="opacity-bg" style="display:none"></div>
<div class="post" style="display:none;top:100px;left:200px;">
    <div class="post-title">说点什么</div>
    <div class="post-close">关闭</div>
    <div class="post-input">
        <textarea name="post-txt"></textarea>
    </div>

    <a class="add-img" href="javascript:void(0)">添加图片</a>
    <button type="button" class="post-btn" name="button">发布</button>
</div>
<script type="text/javascript" src="js/publish.js"></script>
</body>
</html>
