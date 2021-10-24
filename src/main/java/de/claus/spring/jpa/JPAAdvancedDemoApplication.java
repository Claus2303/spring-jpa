package de.claus.spring.jpa;

import de.claus.spring.jpa.adapter.h2.jpa.PersonJpaRepository;
import de.claus.spring.jpa.adapter.h2.jpa.advanced.Course;
import de.claus.spring.jpa.adapter.h2.jpa.advanced.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class JPAAdvancedDemoApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JPAAdvancedDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
