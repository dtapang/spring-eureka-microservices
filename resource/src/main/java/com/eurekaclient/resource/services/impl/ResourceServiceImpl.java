package com.eurekaclient.resource.services.impl;

import com.eurekaclient.resource.dao.ResourceDAO;
import com.eurekaclient.resource.entity.Resource;
import com.eurekaclient.resource.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceDAO resourceDAO;

    @Override
    public List<Resource> getAll() {
        return resourceDAO.findAll();
    }

    @Override
    public Resource getById(int id) {
        return resourceDAO.findById(id);
    }
}
