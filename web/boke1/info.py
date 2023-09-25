# 创建数据的链接对象con
import datetime

import pymysql,datetime
HOST = "127.0.0.1"
USER = "root"
PASS = "root"
DB = "boke"

con = pymysql.connect(host=HOST, port=3306, user=USER, password=PASS, db=DB, charset="utf8")
# 创建一个字典类型的游标cursor
cursor = con.cursor(pymysql.cursors.DictCursor)
# cursor执行SQL命令
sql = "select * from content"
cursor.execute(sql)
row = cursor.fetchone()
infos = (cursor.fetchall())
print()
# 提交数据库
con.commit()
con.close()
print(infos[-2]['content'])
print(datetime.date.today())
