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
  <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
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
     <!-- <link rel="stylesheet" href="static/css/login.css"  charset="utf-8"> -->
    <%--  <link href="<%=request.getContextPath()%>/static/css/login.css?v=1.0" rel="stylesheet" type="text/css" > --%>
     <style>
    	@import url("static/login.css?v=1.0");
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
 <script src="static/js/login.js"></script>



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