/*
 * @Author: xiaoliu
 * @Date: 2023-12-13 21:37:48
 * @LastEditors: xiaoliu
 * @LastEditTime: 2023-12-14 01:41:39
 * @Description: file content
 * @FilePath: /code/Java/MyWebSiteDemo/src/main/webapp/pages/js/app.js
 */
// 用于导航中心的跳转

// 找到每个box，并监听鼠标点击事件
var boxList = document.querySelectorAll(".box");
for (const box of boxList) {
    box.addEventListener("click", () => {
        // 判断是否满足包含test的class类名
        if (box.className.indexOf("test") != -1) {
            window.location.href = "test.html";
        } else {
        }
    });
}
