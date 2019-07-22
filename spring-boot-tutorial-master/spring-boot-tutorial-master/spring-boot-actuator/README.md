## # Spring Boot Actuator 应用监控

Spring Boot Actuator提供了对单个Spring Boot的监控，信息包含：应用状态、内存、线程、堆栈等等，比较全面的监控了Spring Boot应用的整个生命周期。

## 使用说明

1. pom.xml

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

2. application.properties

```properties
# 不需权限可访问所有端口，默认为true
management.security.enabled=false
# 自定义管理的上下文
management.context-path=/abc
# 管理监控的端口
management.port=8888
# 配置某一个端点是否可用
endpoints.actuator.enabled=true
```

可以定义监控管理的访问上下文为`/abc`，也可以单独定义管理的端口号。



### Actuator 的 REST 接口

Spring Boot Actuator 的关键特性是在应用程序里提供众多 Web 接口，通过它们了解应用程序运行时的内部状况。Actuator 提供了 13 个接口，可以分为三大类：配置接口、度量接口和其它接口。

 通过http://localhost:8888/abc/+路径,访问

## Endpoints

Endpoints是actuator非常重要的部分,用来监视程序,和应用交互(如检查信息,)

| ID            | 描述                                                         | 是否需要鉴权 |
| ------------- | ------------------------------------------------------------ | ------------ |
| `actuator`    | 为其他端点提供“发现页面”。要求Spring HATEOAS在classpath路径上。 | 需要         |
| `auditevents` | 陈列当前应用程序的审计事件信息。                             | 需要         |
| `autoconfig`  | 展示自动配置信息并且显示所有自动配置候选人以及他们“被不被”应用的原因。 | 需要         |
| `beans`       | 显示应用程序中所有Spring bean的完整列表。                    | 需要         |
| `configprops` | 显示所有配置信息。                                           | 需要         |
| `dump`        | dump所有线程。                                               | 需要         |
| `env`         | 陈列所有的环境变量。                                         | 需要         |
| `flyway`      | Shows any Flyway database migrations that have been applied. | 需要         |
| `health`      | 显示应用程序运行状况信息                                     | 不需要       |
| `info`        | 显示应用信息。                                               | 不需要       |
| `loggers`     | 显示和修改应用程序中的loggers配置。                          | 需要         |
| `liquibase`   | 显示已经应用的任何Liquibase数据库迁移。                      | 需要         |
| `metrics`     | 显示当前应用程序的“指标”信息。                               | 需要         |
| `mappings`    | 显示所有`@RequestMapping`的url整理列表。                     | 需要         |
| `shutdown`    | 关闭应用（默认情况下不启用）。                               | 需要         |
| `trace`       | 显示跟踪信息（默认最后100个HTTP请求）。                      | 需要         |

后台的监控信息，有些需要权限才能访问，见上表，需要在配置文件设置`management.security.enabled=false`就放开了权限。

shutdown命令默认不开启，如要开启需要在配置文件中写`endpoints.shutdown.enabled=false`

### /health

Spring Boot Actuator有几个预定义的健康指标比如[`DataSourceHealthIndicator`](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/jdbc/DataSourceHealthIndicator.html), [`DiskSpaceHealthIndicator`](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/system/DiskSpaceHealthIndicator.html), [`MongoHealthIndicator`](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/mongo/MongoHealthIndicator.html), [`RedisHealthIndicator`](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/redis/RedisHealthIndicator.html), [`CassandraHealthIndicator`](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/cassandra/CassandraHealthIndicator.html)等，默认，所有的这些健康指标被当作健康检查的一部分。

#### 关闭特定的健康检查指标

比如在prpperties中使用如下命令：

```
management.health.mongo.enabled=false
```

#### 显示详细的健康信息

`health` endpoint只展示了简单的`UP`和`DOWN`状态。为了获得健康检查中所有指标的详细信息。How？？

## 定制Actuator

虽然Actuator提供了很多运行中Spring Boot应用程序的内部工作细节，但难免和你的需求有所偏差。也许你并不需要它提供的所有功能，想要关闭一些也说不定。或者，你需要对Actuator 稍作扩展，增加一些自定义的度量信息，以满足你对应用程序的需求。

#### 1. 修改端点 ID

每个Actuator 端点都有一个ID用来决定接口的路径，比方说，/beans接口的默认ID就是beans。比如要修改 /beans 为 /instances，则设置如下：

```
endpoints.beans.id = instances
```

#### 2. 打开关闭监控端点

虽然Actuator的接口都很有用，但你不一定需要全部这些接口。默认情况下，所有接口(除 了/shutdown)都启用。比如要禁用 /metrics 接口，则可以设置如下：

```
endpoints.metrics.enabled = false
```

如果你只想打开一两个接口，那就先禁用全部接口，然后启用那几个你要的，这样更方便。

```
endpoints.enabled = false
endpoints.metrics.enabled = true
```

#### 3. 添加自定义度量信息

Actuator 自动配置有两个实例 CounterService 和 GaugeService 可以用来计数使用，我们所要做的就是把它们的实例注入所需的 bean 然后调用相应的方法。除此之外，我们还可以实现 PublicMetrics 接口，提供自己需要的度量信息。

#### 4. 创建自定义跟踪仓库

默认情况下，/trace 接口报告的跟踪信息都存储在内存仓库里，100个条目封顶。一旦仓库满了，就开始移除老的条目，给新的条目腾出空间。在开发阶段这没什么问题，但在生产环境中，大流量会造成跟踪信息还没来得及看就被丢弃。我们可以将那些跟踪条目存储在其他地方——既不消耗内存，又能长久保存的地方。只需实现Spring Boot的TraceRepository接口即可。

#### 5. 自定义的健康指示器

实现 HealthIndicator 接口则可以实现自定义的健康指示器。

```java
@Component
public class MyHealthIndicator implements HealthIndicator{
 
	@Override
	public Health health() {
		return Health.down().withDetail("error", "spring boot error").build();
	}
 
}
```

#### 6. 保护 Actuator 接口

很多Actuator端点发布的信息都可能涉及敏感数据，还有一些端点，(比如/shutdown)非常危险，可以用来关闭应用程序。因此，保护这些端点尤为重要,能访问它们的只能是那些经过授权的客户端。



## 两个小窍门

### 在线更改日志级别

当你在跟踪在线系统的问题时，可以临时将日志级别改为debug，问题解决之后，改为info。这个功能对于线上问题的排查非常有用。

为了改变`root` logger的等级为`DEBUG` ，发送一个`POST`请求到<http://localhost:8080/actuator/loggers/root>，加入如下参数

```
{
   "configuredLevel": "DEBUG"
}
```

可以用postman，也可以在命令行执行以下命令，即可在线更改应用的日志级别：

```
http POST http://localhost:8888/abc/loggers/com.example configuredLevel=DEBUG

# mac下 
curl http://localhost:8888/abc/loggers/com.example -X POST -H "Content-Type:application/json" -d '{"configuredLevel":"DEBUG"}' 
```

### 通过/info监控spring git information

参考：<http://www.baeldung.com/spring-git-information> 

将项目的.git里的一些信息，通过actuator的info这个Endpoints显示出来。

1. pom.xml
```
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-actuator</artifactId>
            </dependency>
    …………
    
    	<build>
    		<plugins>
    			<plugin>
       				 <groupId>pl.project13.maven</groupId>
        			<artifactId>git-commit-id-plugin</artifactId>
       				 <version>2.2.1</version>
    		</plugin>
    		……
    	</build>
```
2. 运行mvn  build
3. 运行应用，http://localhost:8888/abc/info

 

 

 

 

 

 

 

 