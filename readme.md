# 基于Gardle+SpringMVC+Spring+Mybatis的DEMO工程
## 一、基础
- [项目搭建参考](http://blog.csdn.net/wyyl1/article/details/52352110)
## 二、在Gradle中使用Mybatis Generator插件
- [在 Gradle 中使用 MyBatis Generator](http://www.jianshu.com/p/5c85becf5f73)
- [上面教程对应的GitHub地址](https://github.com/kingcos/MyBatisGenerator-Tool)
- [MyBatis Geneator配置文件详解](http://git.oschina.net/free/Mybatis_Utils/blob/master/MybatisGeneator/MybatisGeneator.md)
## 三、实现开发环境、测试环境、生产环境配置的自动切换
1. 建立对应不同环境的.properties配置文件
```
在resources目录下,建立下述配置文件:
/config/properties/dev/*.properties
/config/properties/prod/*.properties
/config/properties/test/*.properties
```
2. 定义profile,来将不同环境的配置分开
```
建立applicationContext-properties.xml文件,在其中设置以下内容:
!-- 测试环境配置文件 -->
<beans profile="test">
    <context:property-placeholder location="classpath:/config/properties/test/*.properties" file-encoding="UTF-8"/>
</beans>
<!-- 开发环境配置文件 -->
<beans profile="dev">
    <context:property-placeholder location="classpath:/config/properties/dev/*.properties" file-encoding="UTF-8"/>
</beans>
<!-- 生产环境配置文件 -->
<beans profile="prod">
    <context:property-placeholder location="classpath:/config/properties/prod/*.properties" file-encoding="UTF-8"/>
</beans>
```
3. 定义默认的profile
```
在web.xml中定义全局servlet上下文参数spring.profiles.default
<context-param>
    <param-name>spring.profiles.default</param-name>
    <param-value>prod</param-value>
</context-param>
```
4. 定义激活的profile
> 激活profile有以下几种方式:
> - 通过代码来激活
> - 通过系统环境变量
> - 通过JVM参数
> - 通过servlet上下文参数中定义spring.profiles.active来激活
```
定义JVM参数来激活:
    在tomcat的启动脚本中加入以下JVM参数
    -Dspring.profiles.active="production"
```
```
通过servlet上下文参数中定义spring.profiles.active来激活:
<context-param>
    <param-name>spring.profiles.active</param-name>
    <param-value>dev</param-value>
</context-param>
```
5. 在其他.properties文件中,获取配置文件的数据
> 可以使用${jdbc.driver}的形式,来读取配置文件中的数据
6. 在controller中,通过@Value注解来获取配置文件中的数据
> 如果希望在controller中获取配置数据,需要额外在controller的xml文件中,声明所使用的.properties文件。
```
在spring-mvc文件中,设置以下内容:
<!-- 测试环境配置文件 -->
<beans profile="test">
    <context:property-placeholder location="classpath:/config/properties/test/*.properties" file-encoding="UTF-8"/>
</beans>
<!-- 开发环境配置文件 -->
<beans profile="dev">
    <context:property-placeholder location="classpath:/config/properties/dev/*.properties" file-encoding="UTF-8"/>
</beans>
<!-- 生产环境配置文件 -->
<beans profile="prod">
    <context:property-placeholder location="classpath:/config/properties/prod/*.properties" file-encoding="UTF-8"/>
</beans>
```
> 在controller中,使用@Value注解来获取相应的数值
```
@Value("${jdbc.driver}")
private String jdbcDriver;
```
7. Reference
- [通过 spring 容器内建的 profile 功能实现开发环境、测试环境、生产环境配置自动切换](http://blog.lifw.org/post/68990012)
- [Spring.profile实现开发、测试和生产环境的配置和切换](http://www.cnblogs.com/strugglion/p/7091021.html)
