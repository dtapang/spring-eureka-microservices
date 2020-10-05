package com.eurekaclient.resource.dao;
import com.eurekaclient.resource.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceDAO extends JpaRepository<Resource, Integer> {
    Resource findById(int id);
}
