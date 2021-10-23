package de.claus.spring.jpa.adapter.h2.jpa.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@Repository
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course){
        if (course.getId() == null){
            entityManager.persist(course);
        }
        else{
            entityManager.merge(course);
        }

        return null;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }
}
