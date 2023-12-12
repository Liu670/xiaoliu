<!--
 *                        _oo0oo_
 *                       o8888888o
 *                       88" . "88
 *                       (| -_- |)
 *                       0\  =  /0
 *                     ___/`---'\___
 *                   .' \\|     |// '.
 *                  / \\|||  :  |||// \
 *                 / _||||| -:- |||||- \
 *                |   | \\\  - /// |   |
 *                | \_|  ''\---/''  |_/ |
 *                \  .-\__  '-'  ___/-. /
 *              ___'. .'  /--.--\  `. .'___
 *           ."" '<  `.___\_<|>_/___.' >' "".
 *          | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *          \  \ `_.   \_ __\ /__ _/   .-` /  /
 *      =====`-.____`.___ \_____/___.-`___.-'=====
 *                        `=---='
 * 
 * 
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 
 *            佛祖保佑     永不宕机     永无BUG
 * 
 *        佛曰:  
 *                写字楼里写字间，写字间里程序员；  
 *                程序人员写程序，又拿程序换酒钱。  
 *                酒醒只在网上坐，酒醉还来网下眠；  
 *                酒醉酒醒日复日，网上网下年复年。  
 *                但愿老死电脑间，不愿鞠躬老板前；  
 *                奔驰宝马贵者趣，公交自行程序员。  
 *                别人笑我忒疯癫，我笑自己命太贱；  
 *                不见满街漂亮妹，哪个归得程序员？
 -->

<!--
 * @Author: xiaoliu 2558949748@qq.com
 * @Date: 2023-11-25 08:04:48
 * @LastEditors: xiaoliu
 * @LastEditTime: 2023-12-10 03:33:22
 * @FilePath: /code/homework/day1124/index.html
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html lang="en">


            <head>
                <meta charset="UTF-8">
                <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
                <meta http-equiv="Access-Control-Allow-Origin" content="*">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>登录</title>
                <script src="http://liu.ihong.love:81/file/html/js/jquery-3.7.1.js"></script>
                <link rel="icon" href="http://liu.ihong.love:81/favicon.ico">
                <!-- <link rel="stylesheet" href="button.css"> -->
                <style>
                    * {
                        padding: 0;
                        margin: 0;
                    }

                    body {
                        width: 100vw;
                        height: 100vh;
                        /* 弹性盒子 水平+水平居中 */
                        display: inline-block;
                        justify-content: center;
                        align-items: center;
                        /* 背景 */
                        /* background: linear-gradient(200deg, #37e2b2, #2fa080); */
                        background: linear-gradient(to right, #9fe1fa, #f4edc9);
                    }

                    .container {
                        margin: 0 auto;
                        /* border: 1px solid black; */
                        width: 80vw;
                        height: 90vh;
                        align-items: center;
                        justify-content: center;
                        display: flex;
                    }

                    /* 画熊猫 */
                    .panda {
                        position: relative;
                        margin: 0 auto;
                        /* border: 1px solid pink; */
                        width: 60%;
                        height: 100%;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                    }

                    /* 脸 */
                    .face {
                        width: 200px;
                        height: 200px;
                        background-color: white;
                        border-radius: 50%;
                        box-shadow: 0 10px 15px rgba(0, 0, 0, .15);
                        position: absolute;
                        top: 8%;
                        left: 33%;
                        z-index: 1;

                    }

                    /* 耳朵 */
                    .ear {
                        width: 70px;
                        height: 70px;
                        border-radius: 50%;
                        background-color: black;
                        position: absolute;
                        /* top: 0px; */
                    }

                    /* 左耳 */
                    .ear.left {
                        left: 30%;
                        top: 10%;
                    }

                    /* 右耳 */
                    .ear.right {
                        right: 35%;
                        top: 10%;
                    }

                    /* 眼睛 */
                    .eye-shadow {
                        width: 50px;
                        height: 80px;
                        border-radius: 50%;
                        background-color: black;
                        position: absolute;
                        top: 30px;
                    }

                    /* 左眼睛 */
                    .eye-shadow.left {
                        transform: rotate(45deg);
                        left: 30px;
                    }

                    /* 右眼睛 */
                    .eye-shadow.right {
                        transform: rotate(-45deg);
                        right: 30px;
                    }

                    /* 眼白 */
                    .eye-white {
                        width: 30px;
                        height: 30px;
                        border-radius: 50%;
                        background-color: white;
                        position: absolute;
                        top: 20px;
                    }

                    /* 左眼 */
                    .eye-white.left {
                        left: 10px;
                    }

                    /* 右眼 */
                    .eye-white.right {
                        right: 10px;
                    }

                    /* 眼球 */
                    .eye-ball {
                        width: 20px;
                        height: 20px;
                        border-radius: 50%;
                        background-color: #000;
                        position: absolute;
                        top: 5px;
                        left: 5px;
                    }

                    /* 鼻子 */
                    .nose {
                        width: 40px;
                        height: 20px;
                        background-color: #000;
                        position: absolute;
                        left: 80px;
                        top: 100px;
                        border-radius: 60% 60% 90% 90%;
                    }

                    /* 嘴巴 */
                    .mouth {
                        width: 60px;
                        height: 30px;
                        /* background-color: #000; */
                        position: absolute;
                        left: 70px;
                        top: 110px;
                        border-radius: 50%;
                        border-bottom: 10px solid black;
                    }

                    /* 身体部分 */
                    .body {
                        width: 350px;
                        height: 300px;
                        background-color: #fff;
                        position: relative;
                        left: -25px;
                        top: 5%;
                        border-radius: 80% 80% 50% 50%;
                        box-shadow: 0 5px 10px rgba(0, 0, 0, .3);
                    }

                    /* 脚 */
                    .foot,
                    .foot::before,
                    .foot::after {
                        width: 70px;
                        height: 100px;
                        background-color: #000;
                        border-radius: 40% 40% 100% 100%;
                        position: absolute;
                        z-index: 3;
                    }

                    .foot.left {
                        top: 75%;
                        left: 25%;
                    }

                    .foot.right {
                        top: 75%;
                        right: 30%;
                    }

                    .foot::after {
                        content: "";
                        width: 55px;
                        height: 65px;
                        background-color: #222;
                        position: absolute;
                        border-radius: 50%;
                    }

                    .foot .sole {
                        width: 20px;
                        height: 30px;
                        background-color: #222;
                        position: absolute;
                        border-radius: 50%;
                    }

                    .foot .sole::before {
                        content: "";
                        left: -50px;
                    }

                    .foot .sole::after {
                        content: "";
                        left: 25px;
                    }

                    /* 手 */
                    .hand,
                    .hand::before,
                    .hand::after {
                        width: 40px;
                        height: 30px;
                        background-color: #000;
                        border-radius: 50px;
                        position: absolute;
                        top: 70px;
                    }

                    .hand::before {
                        content: "";
                        top: 16px;
                    }

                    .hand::after {
                        content: "";
                        top: 32px;
                    }

                    .hand.left {
                        left: -20px;
                    }

                    .hand.right {
                        right: -20px;
                    }

                    /* 登录框,注册框 */
                    .login-box,
                    .reg-box {
                        /* visibility: hidden; */
                        width: 400px;
                        height: 400px;
                        background-color: #fff;
                        border-radius: 10%;
                        position: absolute;
                        left: 35%;
                        top: 28%;
                        z-index: 2;
                        /* 弹性布局 使登录框内部居中 */
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        flex-direction: column;
                        /* 翻转动画 */
                        animation: action 1s both;
                    }

                    /* 登录注册切换 反转效果 */
                    @keyframes action {
                        from {
                            /* transform: rotateY(0deg); */
                            transform: scaleX(-1);
                        }

                        to {
                            /* transform: rotateY(180deg); */
                            transform: scaleX(1);
                        }
                    }


                    h1 {
                        color: #1dc797;
                    }

                    .ipt-box {
                        width: 80%;
                        margin-top: 25px;
                        /* border: 1px solid red; */
                        position: relative;
                    }

                    .ipt-box input {
                        width: 100%;
                        height: 35px;
                        border: none;
                        border-bottom: 1px solid #bbb;
                        text-indent: 5px;
                        outline: none;
                        transition: 0, 3s;
                    }

                    .ipt-box label {
                        position: absolute;
                        left: 5px;
                        top: 5px;
                        font-size: 14px;
                        color: #888;
                        transition: .3s;
                        pointer-events: none;

                    }

                    /* 输入框获得焦点 有值输入的时候输入框样式 */
                    .ipt-box input:focus,
                    .ipt-box input:valid {
                        border-color: #1dc797;
                        box-shadow: 0 2px #1dc797;
                    }

                    /* 选中有值输入时label样式 */
                    .ipt-box input:focus~label,
                    .ipt-box input:valid~label {
                        color: #1dc797;
                        transform: translateY(-20px);
                    }

                    /* 登录框 */
                    .login-box,
                    .reg-box {
                        height: 40vh;
                    }


                    .login-box>button,
                    .reg-box>button {
                        width: 150px;
                        height: 40px;
                        background-color: #1dc797;
                        border: none;
                        border-radius: 10px;
                        color: #fff;
                        margin-top: 30px;
                        letter-spacing: 10px;
                        text-indent: 10px;
                        transition: .3s;
                    }

                    .login-box>button:hover,
                    .reg-box>button:hover {
                        letter-spacing: 25px;
                        text-indent: 25px;
                        cursor: pointer;
                        background-color: #2fa080;
                    }

                    /* 登录框向上举 */
                    .up {
                        transform: translate(-50%, -110px);
                    }

                    /* 查看密码 */
                    .show {
                        position: absolute;
                        top: 10px;
                        left: 290px;
                        border: none;
                        outline: none;
                    }

                    .show:hover {
                        cursor: pointer;
                        background-color: #2fa080;

                    }

                    /* 没有账号，立即注册 */
                    .reg {
                        font-size: 12px;
                        position: absolute;
                        top: 10px;
                        right: 0;
                        color: #bbb;

                    }

                    /* 已有账号，去登录 */
                    .loginBtn {
                        font-size: 12px;
                        color: #bbb;
                    }

                    .reg:hover {
                        text-decoration: underline;
                        cursor: pointer;
                        color: #1dc797;

                    }

                    .loginBtn:hover {
                        text-decoration: underline;
                        cursor: pointer;
                        color: #1dc797;

                    }

                    .reg-box>input {}

                    /* 登录框注册框隐藏 */
                    .none {
                        display: none;
                    }

                    /* 闭眼 */
                    .offeye {
                        width: 40px;
                        height: 1px;
                    }

                    /* 提示语 */
                    .log {
                        position: absolute;
                        bottom: 12%;
                        color: red;
                    }

                    .reg-box .log {
                        bottom: 15%;
                    }

                    .loginButton {
                        position: relative;
                        top: 5%;
                    }

                    /* 验证码 */
                    #CodeImg:hover {
                        cursor: pointer;
                    }
                </style>
            </head>

            <body>

                <div class="container">
                    <div class="panda">
                        <!-- 左耳 -->
                        <div class="ear left"></div>
                        <!-- 右耳 -->
                        <div class="ear right"></div>
                        <!-- 脸 -->
                        <div class="face">
                            <!-- 眼睛 -->
                            <div class="eye-shadow left">
                                <div class="eye-white left">
                                    <div class="eye-ball"></div>
                                </div>
                            </div>
                            <div class="eye-shadow right">
                                <div class="eye-white right">
                                    <div class="eye-ball"></div>
                                </div>
                            </div>
                            <!-- 鼻子 -->
                            <div class="nose"></div>
                            <!-- 嘴巴 -->
                            <div class="mouth"></div>
                        </div>
                        <!-- 身子 -->
                        <div class="body"></div>
                        <!-- 脚 -->
                        <div class="foot left">
                            <!-- 脚底 -->
                            <div class="sole"></div>
                        </div>
                        <div class="foot right">
                            <!-- 脚底 -->
                            <div class="sole"></div>
                        </div>

                    </div>

                    <form action="LoginServlet" method="post">

                        <!-- 登录框 -->
                        <div class="login-box none1">
                            <div class="hand left"></div>
                            <div class="hand right"></div>
                            <h1>用户登录</h1>
                            <div class="ipt-box">
                                <input name="username" type="text" required id="loginId">
                                <label for="">用户名</label>
                                <div class="reg">没有账号?立即注册</div>
                            </div>
                            <div class="ipt-box">
                                <input name="password" class="pwd" type="password" required id="password" class="on">
                                <label for="">密码</label>
                                <button type="button" class="show" value="👀"
                                    style="background-color:#fff;">^_^</button>
                            </div>
                            <!-- 验证码 -->
                            <div class="ipt-box" style="height: 2vh;">
                                <input class="captcha" type="text" required id="captcha" class="on" name="captcha">
                                <label for="" style="display: inline-block;">验证码</label>
                                <div id="CodeImg1" class="captchaImg" style="position: absolute;bottom:-10px;right: 0;">
                                    <img id="CodeImg" src="CaptchaServlet" alt="Captcha Image"
                                        onclick="refresh(this)"><br>
                                </div>

                            </div>
                            <button class="loginButton">登录</button>
                            <!-- 提示信息 -->
                            <!-- <span class="log"></span> -->
                            <%-- 显示错误信息 --%>
                                <c:if test="${param.error == 'login'}">
                                    <span class="log">登录失败. 请检查你的账号或密码.</span>
                                </c:if>

                                <c:if test="${param.error == 'captcha'}">
                                    <span class="log">验证码错误. 请重试.</span>
                                </c:if>

                        </div>
                    </form>

                    <!-- 注册框 -->
                    <form action="RegisterServlet" method="post">
                        <div class="reg-box none">
                            <div class="hand left"></div>
                            <div class="hand right"></div>
                            <h1>用户注册</h1>
                            <div class="ipt-box">
                                <input type="text" required id="regName" name="username">
                                <label for="">用户名</label>
                            </div>
                            <div class="ipt-box">
                                <input class="pwd" type="password" required id="password1" class="on" name="password">
                                <label for="">密码</label>
                                <button type="button" class="show" value="👀"
                                    style="background-color:#fff;">^_^</button>
                            </div>
                            <div class="ipt-box">
                                <input class="pwd" type="password" required id="password2" class="on"
                                    name="confirmPassword">
                                <label for="">重复密码</label>
                                <button type="button" class="show" value="👀"
                                    style="background-color:#fff;">^_^</button>
                            </div>
                            <button class="registerButton">注册</button>
                            <div class="loginBtn">已有账号，去登录</div>
                            <!-- <span class="log"></span> -->
                            <%-- 显示错误信息 --%>
                                <c:if test="${param.error == 'isExist'}">
                                    <span class="log">账号已存在. 请重试.</span>
                                </c:if>
                                <c:if test=" ${param.error=='password' }">
                                    <span class="log">密码不匹配. 请重试.</span>
                                </c:if>
                        </div>
                    </form>
                </div>

            </body>

            </html>


            <script>
                timer = setTimeout(function () {
                    if ((location.href).includes("#register")) {
                        // 注册框显示,登录框隐藏
                        $('.login-box').addClass('none')
                        $('.reg-box').removeClass('none')
                    } else if ((location.href).includes("#login")) {
                        $('.login-box').removeClass('none')
                        $('.reg-box').addClass('none')
                    } else {
                        clearInterval(timer);
                    }
                }, 100);
            </script>
            <script>
                $('.pwd').focusin(function () {
                    // 密码框选中
                    $('.login-box').addClass('up');
                    $('.eye-white').addClass('offeye');
                }).focusout(function () {
                    // 密码框非选中
                    $('.login-box').removeClass('up');
                    $('.eye-white').removeClass('offeye');
                })

                // 鼠标位置移动 眼睛跟着动
                $(document).on('mousemove', function (e) {
                    let dw = $(document).width() / 20;
                    let dh = $(document).height() / 15;
                    let x = e.pageX / dw;
                    let y = e.pageY / dh;
                    // console.log(e.pageX, e.pageY);
                    $('.eye-ball').css({
                        left: e.pageX / dw,
                        top: e.pageY / dh,
                    })
                })


                // 点击眼睛显示密码
                $('.show').click(function () {
                    // 如果有on的属性 则说明密码类型 不可见
                    if ($('.pwd').hasClass('on')) {
                        $('.pwd').removeClass('on');
                        $('.pwd').attr({ 'type': 'password' });
                        $('.show').text('>_<')
                    } else {
                        $('.pwd').addClass('on');
                        $('.pwd').attr('type', 'text');
                        $('.show').text('👀');
                        // $('show').text('^o^');
                    }
                });



                // 点击去登录  登录框显示，注册框隐藏
                loginForm = $('.loginBtn').click(function () {
                    // 将输入框置空
                    $('input').val('');
                    $('.login-box').removeClass('none')
                    $('.reg-box').addClass('none')
                    location.href = "#login"
                })
                // 点击去注册

                regFrom = $('.reg').click(function () {
                    $('input').val('');
                    $('.login-box').addClass('none')
                    $('.reg-box').removeClass('none')
                    location.href = "#register"
                })


            </script>
            <!-- 验证码加载 -->
            <script>
                function refresh(obj) {
                    obj.src = "CaptchaServlet?id=" + new Date().getTime();
                }
            </script>



            <!-- <script>
    // 登录功能
    function login(data) {
        var users = data;
        // 登录成功跳转链接  登录验证
        $('.loginButton').click(function () {
            var u = $('#loginId').val();
            var p = $('#password').val();
            var isExits = true;
            for (const i of users) {
                console.log(i);
                // 判断账号是否一致
                if (i.name === u) {
                    // 判断密码
                    if (i.password === p) {
                        $('.log').text('🙆登录成功！')
                        alert("🙆登录成功！")
                        window.location.href = "http://liu.ihong.love:81";
                    } else {
                        $('.log').text('❌密码错误')
                    }
                    break;
                } else {
                    isExits = false;
                }
            }
            if (!isExits) {
                $('.log').text("⚠️账号不存在")
            }
            // alert(users[0].user)
            // window.location.href = "https://github.com/Liu670";
        })

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
            }
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
        $('.registerButton').click(function () {
            $('.log').text('');
            // 从前端获取注册信息
            var name = $('#regName').val();
            var pwd1 = $('#password1').val();
            var pwd2 = $('#password2').val();
            // 判断账号是否存在
            flag = false;//不存在
            for (var i of data) {
                if (i.name == name) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                $('.log').text("账号已存在");
            } else if (!flag && (pwd1 != pwd2)) {
                $('.log').text("密码不一致");
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
                        $('.log').text("注册成功");
                    },
                    error: function (xhr, status, error) {
                        // 在这里处理错误
                        console.log(error);
                        $('.log').text("注册失败");

                    },
                });
            }
        });

    }
</script>

<script>
    // 点击验证码重新更换
    CodeImg1.onclick = function () {
        // // 获取 img 元素
        // var image = document.querySelector("#CodeImg1 img");
        // image.src = "CaptchaServlet"; 
    }

</script>
-->