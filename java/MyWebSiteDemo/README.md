# 个人网站的实现

#### 项目介绍

个人网站，主要是记录学习笔记、生活随笔、技术总结、面试经验、个人简历等。

目前完成进度：登录注册功能和页面，导航页面，部分学习笔记，部分个人简历

#### 开发环境

操作系统：macOS13+ubuntu16（部分页面及静态资源文件托管服务器）

开发工具：eclipse、navicat

语言：Java、html+js+css

框架：bootstrap（响应式布局，这里用来完成主页面的轮播图）

环境：jdk8、tomcat9、mysql5.7

jar 包：mysql-connector-java-5.1.47-bin.jar、servlet-api-2.5.jar、jsp-api、jstl

#### 项目结构

项目目录：

>  src 目录：java 源代码
>
> web 目录：jsp 页面(login.jsp)
>
> static 目录：静态资源文件
>
> lib 目录：jar 包

#### 项目功能

1. 登录注册

2. 主页

3. 学习笔记

4. 生活随笔

5. 技术总结

6. 面试经验

7. 个人简历

#### 项目技术

1. 数据库：mysql5.7

2. 服务器：tomcat9

3. 框架：bootstrap

4. 开发工具：eclipse

5. 语言：

   > Java
   >
   > html

6. 环境：jdk8

7. jar 包：

   > mysql-connector-java-5.1.47-bin.jar
   >
   > servlet-api-2.5.jar
   >
   > jsp-api.jar
   >
   > jstl.jar

8. 项目结构：

   > src 目录：java 源代码
   >
   > web 目录：jsp 页面
   >
   > static 目录：静态资源文件
   >
   > lib 目录：jar 包

<!-- more -->

文件目录

Java 后端使用五层架构，dao、entity、filter、servlet、util

dao:数据访问层，

entity:实体层，

filter:过滤层（拦截器），处理前后端字符编码乱码问题

servlet:事件处理层（控制层），

util:工具包，



####数据库

user表

表字段：id、username、password、createDate

#### 项目实现

##### 1. 登录注册

登录注册页面，使用一个 login.jsp 实现登录和注册功能

##### 2. 主页

主页分为三部分，轮播图、内容。

轮播图使用 bootstrap 实现响应式布局
