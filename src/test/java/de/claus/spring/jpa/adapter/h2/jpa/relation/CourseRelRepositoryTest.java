package de.claus.spring.jpa.adapter.h2.jpa.relation;

import de.claus.spring.jpa.JPARelationDemoApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= JPARelationDemoApplication.class)
class CourseRelRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRelRepository repository;

    @Autowired
    EntityManager entityManager;
    @Test
    public void retrieveReviewsForCourse(){
        Course course = repository.findById(10001L);
        course.getReviews();
    }
    @Test
    public void retrieveCourseForReview(){
        Review review = entityManager.find(Review.class, 50001L);
        review.getCourse();
    }
}