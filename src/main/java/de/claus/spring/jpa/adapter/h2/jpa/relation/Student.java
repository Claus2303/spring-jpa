package de.claus.spring.jpa.adapter.h2.jpa.relation;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Passport passport;

    protected Student(){

    }
    public Student(String name){
        this.name = name;
    }
}
