package com.bob.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-07 16:39
 * @Description:
 */
@RestController
@Slf4j
public class TestController {
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/serverList")
    public String serverList(){
        //第一种方式：直接使用RestTemplate调用
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject("http://127.0.0.1:6001/getServer",String.class);
        //第二种方式：LoadBalancerClient获取服务，再使用RestTemplate调用
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("api-bob-order");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/getServer");
//        String result = restTemplate.getForObject(url,String.class);

        //第三种方式：使用注解@LoadBalanced
        String result = restTemplate.getForObject("http://API-BOB-ORDER/getServer",String.class);
        log.info(result);

        return result;
    }

    @GetMapping("/msg")
    public String msg(){

        return "This is product message";
    }
}
