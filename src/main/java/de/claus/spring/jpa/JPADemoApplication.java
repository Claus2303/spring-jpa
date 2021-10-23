package de.claus.spring.jpa;

import de.claus.spring.jpa.adapter.h2.jdbc.PersonJdbcDAO;
import de.claus.spring.jpa.adapter.h2.jpa.Person;
import de.claus.spring.jpa.adapter.h2.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
//@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JPADemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("findById id -> {}", repository.findById(10001));
        logger.info("insert 10004 id -> {}",
                repository.update(new Person(10004, "Tanja", "Ebensfeld", new Date())));
        logger.info("update 10003 id -> {}",
                repository.update(new Person(10003, "Hund", "Ebensfeld", new Date())));

        repository.delete(10001);
        logger.info("findAll id -> {}", repository.findAll());
        /**
        logger.info("All users -> {}", repository.findAll());

        logger.info("findById name -> {}", repository.findById("Claus"));
        logger.info("Delete users -> {}", repository.deleteById(10001));
        logger.info("Insert users -> {}", repository.insert(new Person(10004,"Tanja","Ebensfeld",new Date())));
        logger.info("All users -> {}", repository.findAll());
        logger.info("findById id -> {}", repository.findById(10004));
        logger.info("All users -> {}", repository.findAllPersonMapper());
         */
    }
}
