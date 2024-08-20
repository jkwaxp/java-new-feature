# 新特性
* 模块化
* 新增只读集合和工厂方法
* REPL 工具：JSheel 命令
* 接口支持私有方法
* Stream API的增强
* Optional 的增强
* try-with-resources的升级
* Process API
* 平台日志 API 和 服务
* 反应式流（Reactive Streams）
* HTML5 Javadoc
* 多版本兼容 JAR 文件
* 改进的弃用注解 @Deprecated
* 改进钻石操作符(Diamond Operator)


``` shell script
"E:\Program Files\Java\jdk-9.0.4\bin\javac" --release 8 java8/com/Hello.java
"E:\Program Files\Java\jdk-9.0.4\bin\javac" --release 9 java9/com/Hello.java
"E:\Program Files\Java\jdk-9.0.4\bin\jar"  -c -f test.jar -C java8 . --release 9 -C java9 .

"E:\Program Files\Java\jdk1.8.0_201\bin\java" -cp test.jar com.Hello
> hello from 8
"E:\Program Files\Java\jdk-9.0.4\bin\java" -cp test.jar com.Hello
> hello from 9
```