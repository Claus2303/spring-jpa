package de.claus.spring.jpa.adapter.h2.jpa.relation;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))//Damit kann man den Namen der JoinTabelle ändern sowie die Column Names
    private List<Course> courses = new ArrayList<>();

    protected Student(){

    }
    public Student(String name){
        this.name = name;
    }

    public void addCourse(Course course){
        courses.add(course);
    }
}
