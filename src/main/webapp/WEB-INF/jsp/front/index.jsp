<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="shortcunt icon" type="/image/x-icon" href="/images/favicon.ico">
    <link rel="stylesheet" href="/css/common.css">
    <link type="text/css" rel="stylesheet" href="/css/index.css">
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
                        <input type="submit" value="搜索"/>
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
<div class="main">
    <div class="content">
        <!-- 说说1 -->
        <div class="item">
            <div class="item-main">
                <div class="u-info">
                    <div class="item-more-ation">
                        <span></span>
                    </div>
                    <div class="u-icon">
                        <img src="/images/user1.png" alt="IVEN-木罐"/>
                    </div>
                    <div class="name-pub">
                        <div class="u-name">
                            <a href="">IVEN-木罐</a>
                        </div>
                        <div class="u-pub">
                            今天 09:21
                        </div>
                    </div>
                </div>
                <div class="itemcontent">
                    <div class="thumbnail">
                        <img src="/images/img2.png" alt="img1">
                    </div>
                    <div class="full-text">
                        <p>
                            另一个关于眼睛的研究结果是……眼睛大不大应该更多取决于眼皮的覆盖程度而与眼球或黑眼珠关系不大，我测量过以眼睛巨大著称的我老婆，实际尺寸与我没有多大差别，当然也有可能有和不同体积脑袋的比例差异产生的错觉。</p>
                    </div>
                </div>
                <div class="u-list">
                    <ul>
                        <li><a href="#"><span>分享</span></a></li>
                        <li>
                            <a href="#" class="arrow-warp">
                                <span>评论</span>
                                <span> 6</span>
                                <span class="arrow"></span>
                            </a>

                        </li>
                        <li><a href="#"><span>喜欢</span><span> 124</span></a></li>
                    </ul>
                </div>
            </div>

            <!-- 评论盖楼 -->
            <div class="item-repeat">
                <!-- 评论输入 -->
                <div class="self-repeat">

                    <div class="repeat-inputtxt" contenteditable="true"></div>
                    <button type="button" class="repeat-inputtxt-btn">
                        评 论
                    </button>
                </div>
                <div class="repeat-list">
                    <div class="repeat-icon">
                        <a href="javascript:void(0)">
                            <img src="./images/user3.png" alt="葵花妹" width="30px">
                        </a>
                    </div>
                    <!-- 其他用户的回复 -->
                    <div class="repeat-content">
                        <div class="repeat-content-text">
                            <a href="javascript:void(0);">葵花妹</a>
                            ：哇，里面有双鞋我以前穿过，还不错呢。
                        </div>
                        <div class="repeat-content-func">
                            <div class="repeat-time">
                                5月13日 23:30
                            </div>
                            <div class="repeat-handler">
                                <a href="">回复</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 回复2 -->
                <div class="repeat-list">
                    <div class="repeat-icon">
                        <a href="javascript:void(0)">
                            <img src="./images/user3.png" alt="葵花妹" width="30px">
                        </a>
                    </div>
                    <div class="repeat-content">
                        <div class="repeat-content-text">
                            <a href="javascript:void(0);">葵花妹</a>
                            ：哇，里面有双鞋我以前穿过，还不错呢。（做个试验，div能够自适应的试验，结果还是不错的嘿嘿嘿嘿嘿。）
                        </div>
                        <div class="repeat-content-func">
                            <div class="repeat-time">
                                5月13日 23:30
                            </div>
                            <div class="repeat-handler">
                                <a href="">回复</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 回复3 -->
                <div class="repeat-list">
                    <div class="repeat-icon">
                        <a href="javascript:void(0)">
                            <img src="./images/user4.png" alt="葵花妹" width="30px">
                        </a>
                    </div>
                    <div class="repeat-content">
                        <div class="repeat-content-text">
                            <a href="javascript:void(0);">Fstar</a>
                            回复
                            <a href="javascript:void(0);">葵花妹</a>
                            ：我觉得还行。
                        </div>
                        <div class="repeat-content-func">
                            <div class="repeat-time">
                                5月13日 23:30
                            </div>
                            <div class="repeat-handler">
                                <a href="">回复</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end -->
        </div>
    </div>
    <div class="p-info">
        <div class="p-icon">
            <img src="/images/person-icon.png" alt="picon">
        </div>
        <div class="p-name"><a href="homepage.html">${user.username}</a></div>
        <div class="p-intro">绘画|设计爱好者</div>
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
                <li><a href="#">
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
<script type="text/javascript" src="/js/index.js">
</script>
</body>
</html>
