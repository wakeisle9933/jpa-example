package com.jpa.jpaexample.service;

import com.jpa.jpaexample.domain.CrudEntity;
import com.jpa.jpaexample.repository.CrudEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CrudService {

    @Autowired
    private CrudEntityRepository crudEntityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private CrudEntity crudEntity;

    public List<CrudEntity> searchAll() {
        return crudEntityRepository.findAll();
    }

    public List<CrudEntity> searchParam(int age) {
        return entityManager.createQuery("select m from sample_member m where age > :age", CrudEntity.class)
                            .setParameter("age", age)
                            .getResultList();
    }

    public List<CrudEntity> searchParamRepo(String name) {
        return crudEntityRepository.searchParamRepo(name);
    }

    public String insertMember(String name, int age) {
        if(crudEntityRepository.findById(name).isPresent()) {
            return "동일한 이름이 이미 있습니다";
        } else {
            crudEntityRepository.save(CrudEntity.builder().name(name).age(age).build());
            return "이름 : " + name + " 나이 : " + age + "으로 추가 되었습니다";
        }
    }

    public String updateMember(String name, int age) {
        if(crudEntityRepository.findById(name).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + name + "이 존재하지 않습니다";
        } else {
            crudEntityRepository.save(CrudEntity.builder().name(name).age(age).build());
            return name + "의 나이를 " + age + "로 변경 완료";
        }
    }

    public String deleteMember(String name) {
        if(crudEntityRepository.findById(name).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + name + "이 존재하지 않습니다";
        } else {
            crudEntityRepository.delete(CrudEntity.builder().name(name).build());
            return name + " 삭제 완료";
        }
    }

}
