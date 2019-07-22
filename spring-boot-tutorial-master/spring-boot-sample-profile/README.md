## 带参数运行--spring.profiles.active
```shell
java -jar ./target/spring-boot-sample-profile-2.0.2.RELEASE.jar --spring.profiles.active=hello
java -jar ./target/spring-boot-sample-profile-2.0.2.RELEASE.jar --spring.profiles.active=generic
java -jar ./target/spring-boot-sample-profile-2.0.2.RELEASE.jar --spring.profiles.active=goodbye
```
本例中MessageService有3个实现类，根据profie参数，加载不同的实现类。

## 带参数运行 --name
```shell
java -jar ./target/spring-boot-sample-profile-2.0.2.RELEASE.jar --name=xiawei
```

## 优先级问题
命令行参数优先级大于配置文件