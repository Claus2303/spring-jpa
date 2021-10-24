package de.claus.spring.jpa.adapter.h2.jpa.relation;

import de.claus.spring.jpa.adapter.h2.jpa.advanced.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@Repository
public class StudentRepository {

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z123456");
        entityManager.persist(passport);//Zuerst Passport in die DB

        Student student = new Student("Mike");
        student.setPassport(passport);

        entityManager.persist(student);
    }
}
