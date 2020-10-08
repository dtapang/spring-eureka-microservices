package com.eurekaclient.product.clients;

import com.eurekaclient.product.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(value = "resource", name = "resource")
public interface ResourceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/resources", consumes = "application/json")
    Resource create(Resource resource);

    @RequestMapping(method = RequestMethod.GET, value = "/resources")
    List<Resource> getResources();

    @RequestMapping(method = RequestMethod.GET, value = "/resources/{resourceId}", consumes = "application/json")
    Resource getResource(@PathVariable("resourceId") int resourceId);

    @RequestMapping(method = RequestMethod.PUT, value = "/resources/{resourceId}", consumes = "application/json")
    Resource update(@PathVariable("resourceId") int resourceId, Resource resource);

    @RequestMapping(method = RequestMethod.DELETE, value = "/resources/{resourceId}", consumes = "application/json")
    Resource delete(@PathVariable("resourceId") int resourceId);
}
