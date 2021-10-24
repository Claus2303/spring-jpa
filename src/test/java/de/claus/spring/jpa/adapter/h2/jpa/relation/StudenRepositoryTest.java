package de.claus.spring.jpa.adapter.h2.jpa.relation;

import de.claus.spring.jpa.JPAAdvancedDemoApplication;
import de.claus.spring.jpa.JPARelationDemoApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest(classes= JPARelationDemoApplication.class)
public class StudenRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails(){
        //Eager fetch
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());
    }

    @Test
    @Transactional //Entweder alles oder nichts --> Persistence Context; Sonst wird jedes Statement abgesetzt
    public void someTest(){
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
