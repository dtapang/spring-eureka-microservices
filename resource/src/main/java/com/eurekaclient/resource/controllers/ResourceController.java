package com.eurekaclient.resource.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg 1";
    }
}
