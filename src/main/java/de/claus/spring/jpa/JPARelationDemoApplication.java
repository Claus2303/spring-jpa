package de.claus.spring.jpa;

import de.claus.spring.jpa.adapter.h2.jpa.relation.CourseRelRepository;
import de.claus.spring.jpa.adapter.h2.jpa.relation.Review;
import de.claus.spring.jpa.adapter.h2.jpa.relation.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JPARelationDemoApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;
    @Autowired
    CourseRelRepository courseRepository;
    public static void main(String[] args) {
        SpringApplication.run(JPARelationDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("5","Great Experiemce"));
        reviews.add(new Review("5","Awesome"));

        //courseRepository.addReviewsForCourse();
        courseRepository.addReviewsForCourse(10003L, reviews);
    }
}
