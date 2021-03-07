package com.nagamani.microservice.persistence;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;
    private String parentId;
}
