# eShopOnContainers-Java

Java 版本的 eShopOnContainers 基于 [dotnet ehop on containers](https://github.com/dotnet-architecture/eShopOnContainers)

## 技术栈替换

.net版本的eShop使用的大多是.net相关的技术，使用的云服务是Azure。我打算用Spring的技术栈重新实现一遍，主要是为了学习。

| 作用 | Spring Cloud框架 | Kubernetes | 备注 |
| --- | --- | --- | --- |
| API gateway | Spring Cloud Gateway | 聚合API请求，统一认证 |
| 远程配置 | Spring Cloud Config |  |
| 调用链路追踪 | Spring Cloud Sleuth |  |
| 断路器 | Spring Cloud Circuit Breaker |  |
| RPC | GRPC | 远程调用 |
| 消息队列 | RabbitMQ |  |
| 容器 | Docker |  |
| 数据库 | PostgreSQL |  |
| 服务发现 | Spring Cloud Consul |  |
| 客户端负载均衡 | Spring Cloud Load Balancer |  |

## 参考

- [Spring Cloud Netflix Alternatives](https://dzone.com/articles/the-future-of-spring-cloud-microservices-after-net)
- [Netflix OSS, Spring Cloud, Kubernetes的选择](https://blog.christianposta.com/microservices/netflix-oss-or-kubernetes-how-about-both/)
