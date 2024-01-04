/*
 * @Author: xiaoliu
 * @Date: 2024-01-04 02:03:31
 * @LastEditors: xiaoliu
 * @LastEditTime: 2024-01-04 20:08:45
 * @Description: file content
 * @FilePath: /code/省考/js.js
 */
// 生成随机RGB颜色值
function getRandomColor() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgba(" + r + ", " + g + ", " + b + ",.4" + ")";
}

// 将随机颜色应用于CSS样式
var elements = document.querySelectorAll("a");
elements.forEach(function (element) {
    var randomColor = getRandomColor();
    // element.style.backgroundColor = randomColor;
    element.addEventListener("mouseover", changeColor); // 鼠标进入元素时调用changeColor函数
    element.addEventListener("mouseout", resetColor); // 鼠标离开元素时调用resetColor函数
});

// JavaScript部分
function changeColor() {
    // 这里可以替换为其他选择器，例如：document.querySelectorAll("p")
    var randomColor = getRandomColor();
    // this.style.background = "red"; // 将背景颜色改为红色
    this.style.background = `linear-gradient(to right,${getRandomColor()},${getRandomColor()})`;
    // element.style.backgroundColor = randomColor;
}

function resetColor() {
    this.style.background = ""; // 重置背景颜色为默认值（空字符串）
}

function smoothScroll() {
    // 获取所有导航菜单项的链接元素
    const navLinks = document.querySelectorAll("li a");

    // 注册点击事件处理程序
    for (let i = 0; i < navLinks.length; i++) {
        const link = navLinks[i];

        // 监听点击事件
        link.addEventListener("click", function (event) {
            event.preventDefault(); // 防止默认的链接跳转行为

            // 获取目标元素的id值
            const targetId = this.getAttribute("href").slice(1);

            // 查找目标元素
            const targetElement = document.getElementById(targetId);

            if (!targetElement) return; // 若未找到目标元素则返回

            // 计算目标元素与视口顶部之间的距离
            const distanceFromTop =
                targetElement.offsetTop - window.innerHeight / 4;

            // 平滑滚动到目标位置
            window.scrollTo({ top: distanceFromTop, behavior: "smooth" });
        });
    }
}
smoothScroll();
