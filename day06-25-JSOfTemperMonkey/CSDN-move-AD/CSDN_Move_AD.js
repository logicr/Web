// ==UserScript==
// @name         古诗文网去广告1.1
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       Logicr
// @match        https://so.gushiwen.org
// @match        *://so.gushiwen.org/*
// @match        *://so.gushiwen.org/

// @grant        none
// ==/UserScript==

(function() {
    'use strict';
    //$(document).ready(function(){
     $('#btn-readmore').click();
     //获取当前链接
    var url = location.href;
    var gushi = /so.gushiwen.org/;
    if(gushi.test(url)){
        //去除右边的广告
        $(".right").remove();
        //删除底部标签
        $("#_w2islx3rkm").remove();
        $("#pic_container.pic_container").remove();
        $("li .line").remove();
        $("a").remove(".line.left");
        $("li").remove(".line");
        $("div").remove(".ic_container#pic_containerp");
        $("div").remove(".s-hl-content");
        $("li").filter(".line").remove();
        $("#wrapper").remove();
        $("iframe").remove();

        //删除底部标签，这个使用了load，所以上面的remove()，无法生效。
        window.addEventListener ("load", removeIframe, false);
		    function removeIframe () {
		        $('iframe').remove();

		    }
        }
})();