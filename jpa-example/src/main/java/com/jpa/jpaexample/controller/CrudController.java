package com.jpa.jpaexample.controller;

import com.jpa.jpaexample.domain.CrudEntity;
import com.jpa.jpaexample.repository.CrudEntityRepository;
import com.jpa.jpaexample.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CrudController {

    private final CrudEntityRepository crudEntityRepository;

    @Autowired
    private CrudService crudService;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("searchAll")
    public List<CrudEntity> searchAll() {
        return crudService.searchAll();
    }

    @GetMapping("searchParam")
    public List<CrudEntity> searchParam(@RequestParam(value = "age") int age) {
        return crudService.searchParam(age);
    }

    @GetMapping("searchParamRepo")
    public List<CrudEntity> searchParamRepo(@RequestParam(value = "name") String name) {
        return crudService.searchParamRepo(name);
    }

    @GetMapping("insert")
    public String insertMember(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        return crudService.insertMember(name, age);
    }

    @GetMapping("update")
    public String updateMember(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        return crudService.updateMember(name, age);
    }

    @GetMapping("delete")
    public String deleteMember(@RequestParam(value = "name") String name) {
        return crudService.deleteMember(name);
    }

}
