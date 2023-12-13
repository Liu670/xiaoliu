/*
 * @Author: xiaoliu
 * @Date: 2023-12-13 12:48:25
 * @LastEditors: xiaoliu
 * @LastEditTime: 2023-12-13 14:09:25
 * @Description: file content
 * @FilePath: /code/Java/MyWebSiteDemo/src/main/webapp/page1/js/swtich.js
 */
/*
 * @Author: xiaoliu
 * @Date: 2023-12-13 12:48:25
 * @LastEditors: xiaoliu
 * @LastEditTime: 2023-12-13 14:06:55
 * @Description: file content
 * @FilePath: /code/Java/MyWebSiteDemo/src/main/webapp/page1/js/swtich.js
 */
// 切换页面
iframe = document.getElementById("iframe");
aList = document.querySelectorAll("#sidebar a");
// 根据网址栏判断是否点击哪一个
for (const i of aList) {
    i.addEventListener("click", function () {
        href = i.getAttribute("href").split("#")[1];
        iframe.src = href + ".html";
    });
}
function toggleSidebar() {
    $(".sidebar").toggleClass("active");
}
