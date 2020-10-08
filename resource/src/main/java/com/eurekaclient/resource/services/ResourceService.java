package com.eurekaclient.resource.services;

import com.eurekaclient.resource.entity.Resource;
import java.util.List;

public interface ResourceService {
    List<Resource> getAll();
    Resource getById(int id);
    Resource add(Resource resource);
    Resource update(int id, Resource resource);
    Resource delete(int id);
}
