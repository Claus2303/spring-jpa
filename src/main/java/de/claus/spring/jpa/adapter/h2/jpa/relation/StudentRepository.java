package de.claus.spring.jpa.adapter.h2.jpa.relation;

import de.claus.spring.jpa.adapter.h2.jpa.advanced.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@Repository
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    public void someOperationToUnderstandPersistenceContext(){
        //Hier würde eine Transaktion aufgemacht, da das Repository Transactional ist
        //Eager fetch
        Student student = entityManager.find(Student.class, 20001L);
        //Persistence Context (student) --> Context = Session
        Passport passport = student.getPassport();
        //Persistence Context (student, passport)
        passport.setNumber("NEU1233456");
        //Persistence Context (student, passport++)
        student.setName("Claus updated");
        //Persistence Context (student++, passport++)
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());

        //ERst zum SChluss werden die Änderungen an die Datenbank versendet
    }
}
