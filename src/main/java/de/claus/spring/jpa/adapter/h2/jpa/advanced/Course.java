package de.claus.spring.jpa.adapter.h2.jpa.advanced;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Course(){}

    public Course(String name){
        this.name = name;
    }
}
