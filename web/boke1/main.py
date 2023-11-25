from flask import Flask, render_template, request, redirect, url_for
import pymysql, time, json, datetime

app = Flask("web")

HOST = "127.0.0.1"
USER = "root"
PASS = "root"
DB = "boke"
isLogin = False  # 未登录
username = '游客'


# 创建一个数据库
def initializeBD():
    res = False
    try:
        # 创建数据的链接对象con
        con = pymysql.connect(host=HOST, port=3306, user=USER, password=PASS, db=DB, charset="utf8")
        # 创建一个字典类型的游标cursor
        cursor = con.cursor(pymysql.cursors.DictCursor)
        # cursor执行SQL命令
        sql = "create table if not exists users (user varchar(16) primary key, pwd varchar(16), email varchar(128))"
        cursor.execute(sql)
        # 提交数据库
        con.close()
        res = True
    except Exception as err:
        print(err)
    return res


# 向数据库写入数据
def registerBD(user, pwd, email):
    initializeBD()
    res = False
    try:
        # 创建数据的链接对象con
        con = pymysql.connect(host=HOST, port=3306, user=USER, password=PASS, db=DB, charset="utf8")
        # 创建一个字典类型的游标cursor
        cursor = con.cursor(pymysql.cursors.DictCursor)
        # cursor执行SQL命令
        # sql = "insert into users (user, pwd, email) values ('" + user + "', '" + pwd + "', '" + email + "')"
        # cursor.execute(sql)
        sql = "insert into users (user, pwd, email) values (%s, %s, %s)"
        cursor.execute(sql, [user, pwd, email])
        # 提交数据库
        con.commit()
        con.close()
        res = True
    except Exception as err:
        print(err)
    return res


# 在数据库中查找数据
def readUser(user, pwd):
    try:
        # 创建数据的链接对象con
        con = pymysql.connect(host=HOST, port=3306, user=USER, password=PASS, db=DB, charset="utf8")
        # 创建一个字典类型的游标cursor
        cursor = con.cursor(pymysql.cursors.DictCursor)
        # cursor执行SQL命令
        sql = "select * from users where user='" + user + "'and pwd='" + pwd + "'"
        cursor.execute(sql)
        row = cursor.fetchone()
        # 提交数据库
        con.commit()
        con.close()
        if row:
            return True
        else:
            return False
    except Exception as err:
        return False


# 登录页
@app.route("/login", methods=["GET", "POST"])
# @app.route("/logout", methods=["GET", "POST"])
@app.route("/", methods=["GET", "POST"])
def index():
    global username, isLogin
    msg = ''
    if request.method == "POST":
        user = request.values.get("user", "")
        pwd = request.values.get("pwd", "")
        if user != "" and pwd != "":
            if readUser(user, pwd):
                msg = user + "登录成功"
                username = user
                isLogin = True
                return redirect(url_for("home")), username.encode("utf-8").decode("latin1")
            else:
                msg = "账号或密码错误,登录失败"
                return render_template("login.html", msg=msg),"游客1".encode("utf-8").decode("latin1")
        else:
            msg = "登录失败，用户名或密码不能为空"
            return render_template("login.html", msg=msg),'游客'.encode("utf-8").decode("latin1")
    return render_template("login.html", msg=msg),'游客'.encode("utf-8").decode("latin1")


# 注销
@app.route("/logout", methods=['GET', 'POST'])
def logout():
    return render_template("login.html")


# 博客内容页
@app.route("/content", methods=["GET", "POST"])
def content():
    return render_template("detail.html", name=username)


# 首页  主页
@app.route("/home", methods=["GET", "POST"])
def home():
    con = pymysql.connect(host=HOST, port=3306, user=USER, password=PASS, db=DB, charset="utf8")
    # 创建一个字典类型的游标cursor
    cursor = con.cursor(pymysql.cursors.DictCursor)
    # cursor执行SQL命令
    sql = "select * from content"
    cursor.execute(sql)
    datas = (cursor.fetchall())
    # 提交数据库
    con.commit()
    con.close()
    a,b = index()
    return render_template("index.html", name=b,datas=(datas), len=len(datas))


# 注册
@app.route("/register", methods=["GET", "POST"])
def register():
    msg = ""
    if request.method == "POST":
        user = request.values.get("user", "")
        pwd1 = request.values.get("pwd1", "")
        pwd2 = request.values.get("pwd2", "")
        email = request.values.get("email", "")
        if user != "" and pwd1 != "" and pwd1 == pwd2:
            if registerBD(user, pwd1, email):
                msg = user + "注册成功"
            else:
                msg = "注册失败" + user + "已经存在"
        else:
            msg = "该用户名称与密码不能空，两次密码要一致"
    return render_template("reg.html", msg=msg)


# 写博客
# @app.route("/write", methods=["GET", "POST"])
# def write():
#     return render_template("edit.html")

# 写博客部分
@app.route('/write', methods=['GET','POST'])
def add_text():
    con = pymysql.connect(host=HOST, port=3306, user=USER, password=PASS, db=DB, charset="utf8")
    # 获取HTML表单中提交的数据
    if request.method == 'POST':
        title = request.values.get("title", "")
        content = request.values.get("content", "")
        # 插入数据到MySQL数据库
        cursor = con.cursor()
        sql = "INSERT INTO content (title, content, time) VALUES (%s, %s, %s)"
        cursor.execute(sql, (title, content, datetime.date.today()))
        con.commit()
        cursor.close()
    return render_template("edit.html")


# # 注销页
# @app.route("/logout", methods=["GET", "POST"])
# def logout():
#     return redirect(url_for('home'))


# 详情页
@app.route("/info", methods=["GET", "POST"])
def getinfo():
    con = pymysql.connect(host=HOST, port=3306, user=USER, password=PASS, db=DB, charset="utf8")
    # 创建一个字典类型的游标cursor
    cursor = con.cursor(pymysql.cursors.DictCursor)
    # cursor执行SQL命令
    sql = "select * from content"
    cursor.execute(sql)
    datas = (cursor.fetchall())
    # 提交数据库
    con.commit()
    con.close()
    return render_template("index.html", len=datas, title=datas[0]['title'])



app.debug = True
if __name__ == "__main__":
    app.run(port=1234)
