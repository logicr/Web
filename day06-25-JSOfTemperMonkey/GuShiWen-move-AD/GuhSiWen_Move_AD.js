// ==UserScript==
// @name         古诗文网去广告0.1.1
// @namespace    http://tampermonkey.net/
// @version      0.1.1
// @description  去除古诗文网右侧及其底部广告
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
     //去除右边的广告
     $(".right").remove();
     //删除底部标签
     //删除底部标签，这个使用了load，所以上面的remove()，无法生效，捕获后面load的广告 addEventListener() 方法用于向指定元素添加事件句柄。
     window.addEventListener ("load", removeIframe, false);
		 function removeIframe () {
		     $('iframe').remove();
		    }
})();