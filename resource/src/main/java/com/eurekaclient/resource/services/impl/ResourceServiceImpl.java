package com.eurekaclient.resource.services.impl;

import com.eurekaclient.resource.dao.ResourceDAO;
import com.eurekaclient.resource.entity.Resource;
import com.eurekaclient.resource.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Resource add(Resource resource) {
        return resourceDAO.save(resource);
    }

    @Override
    @Transactional
    public Resource update(int id, Resource resource) {
        Resource resource1 = resourceDAO.findById(id);
        if(resource1!=null){
            resource1.setCode(resource.getCode());
            resource1.setName(resource.getName());
            return resourceDAO.save(resource1);
        }
        return null;
    }

    @Override
    @Transactional
    public Resource delete(int id) {
        Resource resource1 = resourceDAO.findById(id);
        resourceDAO.deleteById(id);
        return resource1;
    }
}