#!/bin/bash
# 获取时间
TIME=`date +%Y-%m-%d,%H:%M:%S`
git add .
git commit -am $TIME"提交"
git push origin main
