//获得窗口的高度和长度
function getScreenSize(){
    var pageWidth = window.innerWidth,
        pageHeight = window.innerHeight;
    if (typeof pageWidth != "number"){
        if (document.compatMode == "CSS1Compat"){
            pageWidth = document.documentElement.clientWidth;
            pageHeight = document.documentElement.clientHeight;
        } else {
            pageWidth = document.body.clientWidth;
            pageHeight = document.body.clientHeight;
        }
    }
    return [pageWidth, pageHeight];
}

//点击右上角发布按钮显示发布框。
var p = document.getElementsByClassName("post")[0];
var p_btn = document.getElementsByClassName("publish")[0];
var bg = document.getElementsByClassName("opacity-bg")[0];
var p_txt = document.getElementsByTagName("textarea")[0];
p_btn.onclick=function(){
    //计算发布框的左偏移left和上偏移top
    var screenSize = getScreenSize();
    console.log(screenSize[0], screenSize[1]);
    var offleft = Math.floor( (screenSize[0]-460)/2 );
    var offtop = Math.floor( (screenSize[1]-209)/2 );

    p.style.left=offleft+"px";
    p.style.top=offtop+"px";
    bg.style.display = "block";
    p.style.display = "block";
}
var close = document.getElementsByClassName("post-close")[0];
close.onclick= function(){
    p_txt.value="";
    bg.style.display = "none";
    p.style.display = "none";
}
