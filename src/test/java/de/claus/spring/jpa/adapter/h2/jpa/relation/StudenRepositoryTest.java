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

@SpringBootTest(classes= JPARelationDemoApplication.class)
public class StudenRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void retrieveStudentAndPassportDetails(){
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());
    }
}
