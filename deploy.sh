#!/usr/bin/env bash
# 编译 +部署 order 站点。

# 需要配置如下参数。
#  项目路径，在 Execute Shell 中配置项目路径，pwd 就可以获得该项目路径。
# PROJ_PATH = 这个 jenkins 任务在部署机器上的路径。

# 环境上 tomcat 的全路径。
TOMCAT_APP_PATH=/root/geek/tools_my/apache-tomcat-8.5.53

### base 函数。
killTomcat()
{
    pid=`ps -ef | grep tomcat | grep java | awk '{print $2}'`
    echo "tomcat Id list: $pid"
    if [ "$pid" = "" ]
    then
      echo "no tomcat pid alive"
    else
      kill -9 $pid
    fi
}

cd $PROJ_PATH/order
/root/geek/tools_my/apache-maven-3.5.4/bin/mvn clean install

# 停 tomcat。
killTomcat

# 删除原有工程。
rm -rf $TOMCAT_APP_PATH/webapps/ROOT
rm -f $TOMCAT_APP_PATH/webapps/ROOT.war
rm -f $TOMCAT_APP_PATH/webapps/order.war

# 复制新的工程。
cp $PROJ_PATH/order/target/order.war $TOMCAT_APP_PATH/webapps/

cd $TOMCAT_APP_PATH/webapps/
mv order.war ROOT.war

# 启动 Tomcat。
cd $TOMCAT_APP_PATH/
sh bin/startup.sh
