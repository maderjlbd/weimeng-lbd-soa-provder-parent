具体的开发规范，请参考：http://bable.weimob.com/pages/viewpage.action?pageId=10749316

按照开发规范，我们提供了下面的demo实例，根据此demo，你需要掌握下面几部分内容。

## 4层服务架构
* consumer
* client
* interface
* server

## 4层应用架构
* export
* facade
* service
* dao

## dubbo相关配置
参考：applicationContext-dubbo.xml

## 异常体系
* ErrorCode枚举
* BaseException
* XxxBizException

## 第三方服务层规范及httpclient-enhance的使用
参考：PhoneZoneService

## cat
* catAppender 参考：log4j.xml
* 手动打点(demo中未涉及)
* aop切面

## wcc
* wcc的工作原理
* wcc的两种使用方式：1,配置文件注入; 2,API获取

## wdd
* wdd的使用方式

## druid
* druid的配置
* 如何将sql的执行打点到cat

## redis-enhance(demo中未涉及)
* redis-enhance的作用
* redis-enhance的使用方式

## myBatis
* myBatis的使用

## 测试页面的使用
服务启动后，访问下面这个页面，可以测试spring容器中所有实例
http://localhost:8085/resources/service_test.html