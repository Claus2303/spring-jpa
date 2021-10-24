package de.claus.spring.jpa.adapter.h2.jpa.advanced;

import de.claus.spring.jpa.JPAAdvancedDemoApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes= JPAAdvancedDemoApplication.class)
class JPQLTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void findById_basic(){
        List resultList = entityManager.createQuery("Select c From Course c").getResultList();
        logger.info("Select c From Course c -> {}",resultList);
    }

    @Test
    public void findById_typed(){
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c",Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Select c From Course c -> {}",resultList);
    }

    @Test
    public void findById_where(){
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where name like '%DDD'",Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Select c From Course c where name like '%DDD' -> {}",resultList);
    }

    @Test
    public void jpql_namedquery(){
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses",Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Select c From Course c where name like '%DDD' -> {}",resultList);
    }
}
