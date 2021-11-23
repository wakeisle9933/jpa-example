package com.jpa.jpaexample.service;

import com.jpa.jpaexample.entity.CrudEntity;
import com.jpa.jpaexample.repository.CrudEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    @Autowired
    private CrudEntityRepository crudEntityRepository;

    public List<CrudEntity> newSearch() {
        return crudEntityRepository.findAll();
    }

}
