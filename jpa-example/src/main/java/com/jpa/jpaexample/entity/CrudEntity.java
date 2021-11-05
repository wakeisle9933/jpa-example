package com.jpa.jpaexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="tb2")
public class CrudEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;

}