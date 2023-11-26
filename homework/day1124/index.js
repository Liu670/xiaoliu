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

// 点击去登录
$(".loginBtn").click(function () {
    // 将输入框置空
    $("input").val("");
    $(".login-box").removeClass("none");
    $(".reg-box").addClass("none");
});
// 点击去注册
$(".reg").click(function () {
    $("input").val("");
    $(".login-box").addClass("none");
    $(".reg-box").removeClass("none");
});

// 登录功能
function login(data) {
    var users = data;
    // 登录成功跳转链接  登录验证
    $(".loginButton").click(function () {
        var u = $("#loginId").val();
        var p = $("#password").val();
        var isExits = true;
        for (const i of users) {
            // 判断账号是否一致
            if (i.name === u) {
                // 判断密码
                if (i.password === p) {
                    $(".log").text("🙆登录成功！");
                    alert("🙆登录成功！");
                    window.location.href = "https://github.com/Liu670";
                } else {
                    $(".log").text("❌密码错误");
                }
                break;
            } else {
                isExits = false;
            }
        }
        if (!isExits) {
            $(".log").text("⚠️账号不存在");
        }
        // alert(users[0].user)
        // window.location.href = "https://github.com/Liu670";
    });
}

// 登录
$(document).ready(function () {
    $.ajax({
        url: "http://liu.ihong.love:8089/loginAndRegister/test.jsp",
        type: "GET",
        dataType: "json",
        // async: true,
        success: function (data) {
            // 在这里处理获取到的JSON数据
            // console.log(data);
            login(data);
            register(data);
        },
        error: function (xhr, status, error) {
            // 处理请求错误
            // console.log(error);
        },
    });
});

$(document).ready(function () {
    // $.ajax({
    //     url: `http://localhost:8080/loginAndRegister/reg.jsp`,
    //     type: "get",
    //     // data: {
    //     //     name: 'join',
    //     //     age: 19,
    //     // },
    //     username: uname,
    //     password: pwd,
    //     // data: JSON.stringify({ "password": "1", "name": "1" }),
    //     dataType: "text",
    //     contentType: "application/json",
    //     success: function (response) {
    //         // 在这里处理后端返回的响应
    //         console.log(response);
    //     },
    //     error: function (xhr, status, error) {
    //         // 在这里处理错误
    //     },
    // });
});

// 注册功能
function register(data) {
    $(".registerButton").click(function () {
        $(".log").text("");
        // 从前端获取注册信息
        var name = $("#regName").val();
        var pwd1 = $("#password1").val();
        var pwd2 = $("#password2").val();
        // 判断账号是否存在
        flag = false; //不存在
        for (var i of data) {
            if (i.name == name) {
                flag = true;
                break;
            }
        }
        if (flag) {
            $(".log").text("账号已存在");
        } else if (!flag && pwd1 != pwd2) {
            $(".log").text("密码不一致");
        } else {
            // ajax向后端发送请求
            $.ajax({
                url: `http://liu.ihong.love:8089/loginAndRegister/reg.jsp?username=${name}&password1=${pwd1}`,
                type: "get",
                username: name,
                password1: pwd1,
                password2: pwd2,
                dataType: "text",
                // contentType: "application/json",
                success: function (response) {
                    // 在这里处理后端返回的响应
                    $(".log").text("注册成功");
                },
                error: function (xhr, status, error) {
                    // 在这里处理错误
                    console.log(error);
                    $(".log").text("注册失败");
                },
            });
        }
    });
}
