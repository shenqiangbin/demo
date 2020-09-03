# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/#build-image)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

### Guides
The following guides illustrate how to use some features concretely:

* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)


@Mapper 和 @MapperScan(basePackages = { "com.example.demo.mapper" })
留一个即可

### 为什么必须有 @Bean(name = "mysql") mybatis 才不会报错？？
加上 Bean，才是交给了 Spring Boot 管理，这里把 DataSource 交给了 Spring Boot
MyBatis 使用的数据源就是这个了。（MyBatis 会使用默认的数据源）


参考：https://www.cnblogs.com/cxuanBlog/p/11179439.html
