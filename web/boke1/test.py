#  这是基模板.py
# made by 杨庆华
from flask import Flask, render_template

app = Flask(__name__)


@app.route('/')
def index():
    return render_template('base.html')


@app.route('/son')
def son():
    return render_template('son.html')


def foo():
    return '我是全局的函数foo，老兄'


frout = 'apple'
app.jinja_env.globals['foo'] = foo;
app.jinja_env.globals['frout'] = frout;


@app.route('/laststep')
def laststep():
    return '这是上一个文件'

@app.route('/index')
def index1():
    return render_template("index.html")



app.run()
