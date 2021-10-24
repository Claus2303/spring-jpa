package de.claus.spring.jpa.adapter.h2.jpa.relation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRelRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

    public void addReviewsForCourse(){
        //get the Course 10003
        Course course = findById(10003L);
        logger.info("Aktueller Course 10003 -> {}",course);
        //add 2 Reviews ti it
        Review review1 = new Review("5","Great Experiemce");
        Review review2 = new Review("5","Awesome");

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);
        //save it to database
        entityManager.persist(review1);
        entityManager.persist(review2);
    }
}
