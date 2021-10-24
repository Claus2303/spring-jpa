package de.claus.spring.jpa;

import de.claus.spring.jpa.adapter.h2.jpa.relation.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JPARelationDemoApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(JPARelationDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.saveStudentWithPassport();
    }
}
