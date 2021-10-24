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
    //@OneToOne(fetch = FetchType.LAZY) --> Die Daten werden erst geholt, wenn sie benötigt werden. Sonst werden Joins durchgeführt
    //Standard ist Eager Fetch
    private Passport passport;

    protected Student(){

    }
    public Student(String name){
        this.name = name;
    }
}
