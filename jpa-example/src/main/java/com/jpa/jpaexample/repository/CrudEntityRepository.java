package com.jpa.jpaexample.repository;

import com.jpa.jpaexample.entity.CrudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudEntityRepository extends JpaRepository<CrudEntity, String> {
}