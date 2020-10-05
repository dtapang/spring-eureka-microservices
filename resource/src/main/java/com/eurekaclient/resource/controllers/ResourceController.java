package com.eurekaclient.resource.controllers;

import com.eurekaclient.resource.entity.Resource;
import com.eurekaclient.resource.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GetMapping("/list")
    public List<Resource> list(){
        return resourceService.getAll();
    }

    @GetMapping("/msg")
    public String msg() {
        return "this is resource msg";
    }
}
