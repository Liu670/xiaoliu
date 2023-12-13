timer = setTimeout(function () {
    if (location.href.includes("#register")) {
        // 注册框显示,登录框隐藏
        $(".login-box").addClass("none");
        $(".reg-box").removeClass("none");
    } else if (location.href.includes("#login")) {
        $(".login-box").removeClass("none");
        $(".reg-box").addClass("none");
    } else {
        clearInterval(timer);
    }
}, 100);

$(".pwd")
    .focusin(function () {
        // 密码框选中
        $(".login-box").addClass("up");
        $(".eye-white").addClass("offeye");
    })
    .focusout(function () {
        // 密码框非选中
        $(".login-box").removeClass("up");
        $(".eye-white").removeClass("offeye");
    });

// 鼠标位置移动 眼睛跟着动
$(document).on("mousemove", function (e) {
    let dw = $(document).width() / 20;
    let dh = $(document).height() / 15;
    let x = e.pageX / dw;
    let y = e.pageY / dh;
    // console.log(e.pageX, e.pageY);
    $(".eye-ball").css({
        left: e.pageX / dw,
        top: e.pageY / dh,
    });
});

// 点击眼睛显示密码
$(".show").click(function () {
    // 如果有on的属性 则说明密码类型 不可见
    if ($(".pwd").hasClass("on")) {
        $(".pwd").removeClass("on");
        $(".pwd").attr({ type: "password" });
        $(".show").text(">_<");
    } else {
        $(".pwd").addClass("on");
        $(".pwd").attr("type", "text");
        $(".show").text("👀");
        // $('show').text('^o^');
    }
});

// 点击去登录  登录框显示，注册框隐藏
loginForm = $(".loginBtn").click(function () {
    // 将输入框置空
    $("input").val("");
    $(".login-box").removeClass("none");
    $(".reg-box").addClass("none");
    location.href = "#login";
});

// 点击去注册   注册框显示，登录框隐藏
regFrom = $(".reg").click(function () {
    $("input").val("");
    $(".login-box").addClass("none");
    $(".reg-box").removeClass("none");
    location.href = "#register";
});

// <!-- 验证码加载 -->
function refresh(obj) {
    obj.src = "CaptchaServlet?id=" + new Date().getTime();
}
