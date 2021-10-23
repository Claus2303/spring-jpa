package de.claus.spring.jpa;

import de.claus.spring.jpa.adapter.h2.jdbc.Person;
import de.claus.spring.jpa.adapter.h2.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonJdbcDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(JPADemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("findById id -> {}", dao.findById(10001));
        logger.info("findById name -> {}", dao.findById("Claus"));
        logger.info("Delete users -> {}", dao.deleteById(10001));
        logger.info("Insert users -> {}", dao.insert(new Person(10004,"Tanja","Ebensfeld",new Date())));
        logger.info("All users -> {}", dao.findAll());
        logger.info("findById id -> {}", dao.findById(10004));
        logger.info("All users -> {}", dao.findAllPersonMapper());
    }
}
