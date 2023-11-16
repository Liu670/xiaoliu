#!/bin/bash
# 获取时间
TIME=`date +%Y-%m-%d,%H:%M:%S`
git add ~/code
git commit -am 提交于:$TIME
git push origin main

