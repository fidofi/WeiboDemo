//获得scrolltop
function getScrollTop() {
    var scrollTop = 0;
    if (document.documentElement && document.documentElement.scrollTop) {
        scrollTop = document.documentElement.scrollTop;
    }
    else if (document.body) {
        scrollTop = document.body.scrollTop;
    }
    return scrollTop;
}
//获取body的总高度
function getScrollHeight() {
    return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
}

//以下函数可以实现不断加载
// window.onscroll = function () {
//     if (getScrollTop() + getScreenSize()[1] == getScrollHeight()) {
//         console.log("到达底部,加载");
//
//         //到达底部调用ajax
//         var content = document.getElementsByClassName("content")[0];
//
//         // var item = document.createElement("div");
//         // item.className="item";
//         // item.innerHTML="<a>123</a>"
//         // content.appendChild(item);
//
//         //这里从php获取数组。
//         //每个数组元素要求包含
//         //用户头像路径、用户名、发布日期、图片路径、文本内容、（点赞数、评论暂时不用）
//
//         //
//         // additem("images/user4.png", "Fstar", "今天 15:21", "images/img2.png", "你值得拥有。");
//         // additem("images/user4.png", "Fstar", "今天 15:21", "images/img2.png", "你值得拥有。");
//         // additem("images/user4.png", "Fstar", "今天 15:21", "images/img2.png", "你值得拥有。");
//         // additem("images/user4.png", "Fstar", "今天 15:21", "images/img2.png", "你值得拥有。");
//         // additem("images/user4.png", "Fstar", "今天 15:21", "images/img2.png", "你值得拥有。");
//
//         // //用户头像路径、用户名、发布日期、图片路径、文本内容、（点赞数、评论暂时不用）
//         // //其次还要改说说的id号（主键）
//         // function additem(usericon, username, date, imgsrc, text){
//         //     console.log("滚动到底部，加载5条消息");
//         //     var str = '<div class="item-main"><div class="u-info"><div class="u-icon"><img src="images/user3.png" alt="葵花妹" /></div><div class="name-pub"><div class="u-name"><a href="">葵花妹</a></div><div class="u-pub">今天 09:18</div></div></div><div class="itemcontent"><div class="thumbnail"><img src="images/img1.png" alt="img1"></div><div class="full-text"><p>你们是我走过的路…</p></div></div><div class="u-list"><ul><li><a href="#"><span>分享</span></a></li><li><a href="#"><span>评论</span><span>6</span></a></li><li><a href="#"><span>喜欢</span><span>124</span></a></li></ul></div></div>'
//         //
//         //     var item = document.createElement("div");
//         //     var content = document.getElementsByClassName("content")[0];
//         //     item.className = "item";
//         //     item.innerHTML= str;
//         //     content.appendChild(item);
//         //
//         // }
//     }
// }
