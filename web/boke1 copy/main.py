from flask import Flask,render_template,request,redirect,url_for
import pymysql,time

app = Flask("web")


HOST = "127.0.0.1"
USER = "root"
PASS = "root"
DB = "boke"

isLogin = False  #  未登录

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
        sql = "select * from users where user='" + user + "'and pwd='" + pwd+"'"
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


@app.route("/login", methods=["GET", "POST"])
@app.route("/", methods=["GET", "POST"])
def index():
    msg = ""
    if request.method == "POST":
        user = request.values.get("user", "")
        pwd = request.values.get("pwd", "")
        if user != "" and pwd != "":
            if readUser(user, pwd):
                msg = user + "登录成功"
                return redirect(url_for("home"))
            else:
                msg = "账号或密码错误,登录失败"
                return render_template("login.html", msg=msg)
        else:
            msg = "登录失败，用户名或密码不能为空"
            return render_template("login.html",msg=msg)
    return render_template("login.html", msg=msg)

@app.route("/content", methods=["GET", "POST"])
def content():
    return render_template("detail.html")
@app.route("/home", methods=["GET", "POST"])
def home():
    return render_template("index.html")

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
@app.route("/write", methods=["GET", "POST"])
def write():
    return render_template("edit.html")

app.debug=True
if __name__ == "__main__":
    app.run()

