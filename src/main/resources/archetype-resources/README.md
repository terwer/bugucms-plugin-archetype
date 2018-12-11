#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
# ${artifactId}

$symbol_pound$symbol_pound$symbol_pound$symbol_pound 项目介绍
${pluginShortName} plugin for bugucms

$symbol_pound$symbol_pound$symbol_pound$symbol_pound 安装教程

> 使用maven打包

```
mvn clean package -DskipTests
```

> 将 ``target/`` 目录下的 ``${artifactId}-${version}.zip`` 文件拷贝到容器项目的 ``plugins`` 目录下

> 将wabjars目录复制到target/classes/，用于插件寻找webjars资源

$symbol_pound$symbol_pound$symbol_pound$symbol_pound 联系作者

[http://www.terwergreen.com](http://www.terwergreen.com/guestbook.html)