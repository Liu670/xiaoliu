<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!--
 * @Author: xiaoliu
 * @Date: 2023-12-07 10:14:56
 * @LastEditors: xiaoliu
 * @LastEditTime: 2023-12-07 12:46:42
 * @Description: file content
 * @FilePath: /code/Java/AjaxDemo/src/main/webapp/JavaDemo.jsp
-->
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="icon" href="http://liu.ihong.love:81/favicon.ico">
        <script src="http://liu.ihong.love:81/file/html/js/jquery-3.7.1.js"></script>
        <style>
            * {
                padding: 0;
                margin: 0;
            }

            .table {
                border-collapse: collapse;

            }

            .table tr {
                text-align: center;
            }

            .table tr td {
                width: 100px;
                padding: -10px;
            }
        </style>
    </head>

    <body>
        一、JSON格式的user对象:
        <div id="objectDiv"></div><br />
        二、JSON格式的user对象:
        <select id="arraySel"></select>
        <ul id="arrayUl"></ul>
        三、JSON格式的user对象数组:
        <div id="objectArrayDiv"></div>
    </body>

    </html>
    <script>
        // 一、定义json格式的user对象
        $(function () {
            var user = { "id": 1, "name": "张三", "password": "1" };
            $("#objectDiv").append("ID:" + user.id + "<br>").append("用户名:" + user.name + "<br>").append("密码:" + user.password + "<br>");

        })
        // 二、定义json格式的字符串数组
        $(function () {
            var arr = ["中", "美", "俄"];
            // 将数组中对应数据，分别添加到下拉框和无序列表中
            var $arr = $(arr);
            var $arraySel = $("#arraySel");//展示数据的下拉框元素
            var $arrayUl = $("#arrayUl");// 展示数据的列表元素
            $arr.each(function () {
                $arrayUl.append("<li>" + this + "</li>");
            });
            $arr.each(function (i) {
                $arraySel.append("<option value='" + (i + 1) + "'>" + this + "</option>");
            });
        })

        // 三、定义json格式的user对象数组
        var userArray = [
            {
                "id": 1,
                "name": "张三",
                "password": "1"
            },
            {
                "id": 2,
                "name": "李四",
                "password": "2"
            },
            {
                "id": 3,
                "name": "王五",
                "password": "3"
            },
            {
                "id": 4,
                "name": "赵六",
                "password": "4"
            }
        ]
        var objectArrayDiv = $("#objectArrayDiv");//展示数据的div元素
        var table = $(
            "<table border='1' class='table'>\
                <tr><th>id</th>\
                    <th>用户名</th>\
                    <th>密码</th></tr>\
            </table>"
        ).appendTo(objectArrayDiv);
        var $userArray = $(userArray);
        $userArray.each(function () {
            table.append(
                "<tr><td>" + this.id +
                "</td><td>" + this.name +
                "</td><td>" + this.password +
                "</td></tr>"
            );
        });
    </script>