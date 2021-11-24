package com.jpa.jpaexample.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "sample_member")
@Table(name = "sample_member")
public class CrudEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;

}