package de.claus.spring.jpa.adapter.h2.jpa.advanced;

import de.claus.spring.jpa.JPAAdvancedDemoApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes= JPAAdvancedDemoApplication.class)
class NativeQueryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    //Für Performancethemen oder spezielle Datenbank SQL Dialekte
    public void native_query_basic(){
        Query query = entityManager.createNativeQuery("Select * From Course where id = :id", Course.class);
        query.setParameter("id", 10001L);
        List resultList = query.getResultList();

        logger.info("Select * From Course ->{}",resultList);
    }

    @Test
    @Transactional
    //Bei JPA kein massenupdate möglich
    public void native_query_toUpdate(){
        Query query = entityManager.createNativeQuery("Update Course set last_updated_date=sysdate");
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("Number of Rows ->{}",noOfRowsUpdated);
    }

}
