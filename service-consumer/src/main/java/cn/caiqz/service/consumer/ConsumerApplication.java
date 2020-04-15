package cn.caiqz.service.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 消费服务
 *
 * @author openshell
 */

/**
 * @SpringCloudApplication是一个组合注解包含了以下三个注解
 * @SpringBootApplication
 * @EnableDiscoveryClient 声明是一个erueka客户端
 * @EnableCircuitBreaker 开启Hystrix
 * Ribbon:负载均衡，简化远程调用代码，可以通过服务名调用。
 * Hystrix：降级、熔断
 * Feign：可以把Rest的请求进行隐藏，伪装成类似SpringMVC的Controller一样。你不用再自己拼接url，拼接参数等等操作，一切都交给Feign去做。
 */
@SpringCloudApplication
@EnableFeignClients
public class ConsumerApplication {

//    @Bean
//    @LoadBalanced //开启负载均衡 Ribbon可以大大简化远程调用代码，可以通过服务名调用。
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
