package cn.caiqz.service.consumer.controller;

import cn.caiqz.service.consumer.client.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author openshell
 * @since 2020-04-07
 */
@RestController
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "fallbackMethod")
public class UserController {

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient; //注入discoveryClient，通过该客户端获取服务列表

    @Autowired
    private UserClient userClient;

    @GetMapping
//    @HystrixCommand(fallbackMethod = "fallbackMethod")  单独指定降级方法
    @HystrixCommand //表示该方法使用类指定的默认降级方法
    public String queryUserById(@RequestParam Long id) {
        //通过client获取服务提供方的服务列表，这里我们只有一个
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
//        ServiceInstance serviceInstance = instances.get(0);
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        if (id == 28) {
//            throw new RuntimeException("请求繁忙");
//        }
        //使用ribbon开启负载均衡，直接通过服务名调用服务
//        String baseUrl = "http://service-provider/user/" + id;
//        return this.restTemplate.getForObject(baseUrl, String.class);

        //使用feign
        return userClient.queryById(id).toString();
    }


    /**
     * 熔断方法
     * 返回值要和被熔断的方法的额返回值一致
     * 熔断方法不需要参数
     */
    public String fallbackMethod() {
        return "请求繁忙，请稍后再试！";
    }
}
