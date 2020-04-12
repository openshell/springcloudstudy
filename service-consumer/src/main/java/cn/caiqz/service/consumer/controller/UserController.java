package cn.caiqz.service.consumer.controller;

import cn.caiqz.service.consumer.pojo.User;
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
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient; //注入discoveryClient，通过该客户端获取服务列表

    @GetMapping
    public User queryUserById(@RequestParam Long id) {
        //通过client获取服务提供方的服务列表，这里我们只有一个
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
//        ServiceInstance serviceInstance = instances.get(0);

        //使用ribbon开启负载均衡，直接通过服务名调用服务
        String baseUrl = "http://service-provider/user/" + id;
        return this.restTemplate.getForObject(baseUrl, User.class);
    }
}
