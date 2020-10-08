package com.eurekaclient.resource.controllers;
import com.eurekaclient.resource.entity.Resource;
import com.eurekaclient.resource.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/resources")
    public Resource create(Resource resource){
        return resourceService.add(resource);
    }

    @GetMapping("/resources")
    List<Resource> getResources(){
        return resourceService.getAll();
    }

    @GetMapping("/resources/{resourceId}")
    Resource getResource(@PathVariable("resourceId") int resourceId){
        return resourceService.getById(resourceId);
    }

    @PutMapping("/resources/{resourceId}")
    Resource update(@PathVariable("resourceId") int resourceId, Resource resource){
        return resourceService.update(resourceId,resource);
    }

    @DeleteMapping("/resources/{resourceId}")
    Resource delete(@PathVariable("resourceId") int resourceId){
        return resourceService.delete(resourceId);
    }
}
