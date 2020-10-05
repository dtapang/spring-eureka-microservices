package com.eurekaclient.product.controllers;

import com.eurekaclient.product.model.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductResources")
    public ResponseEntity<Resource[]> getProductRes() {
        //1. The first way (use restTemplate directly, url defined)
        //RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject("http://localhost:9080/msg", String.class);
        //2. The second way (use loadBalancerClient to get the URL by the application name, and then use restTemplate)
        //RestTemplate restTemplate = new RestTemplate();
        //ServiceInstance serviceInstance = loadBalancerClient.choose("RESOURCE");
        //String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
        //String response = restTemplate.getForObject(url, String.class);

        //3. The third way (using @LoadBalanced, you can use the application name in restTemplate)
        ResponseEntity<Resource[]> responseEntity = restTemplate.getForEntity("http://RESOURCE/list", Resource[].class);
        Resource[] objects = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();

        log.info("response={}", responseEntity);
        return responseEntity;
    }

}
