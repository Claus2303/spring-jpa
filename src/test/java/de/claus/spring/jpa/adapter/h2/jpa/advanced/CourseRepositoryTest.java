package de.claus.spring.jpa.adapter.h2.jpa.advanced;

import de.claus.spring.jpa.JPAAdvancedDemoApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= JPAAdvancedDemoApplication.class)
class CourseRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;
    @Test
    public void findById_basic(){
        Course course = repository.findById(10001L);
        assertEquals("Claus Course", course.getName());
    }

    @Test
    @DirtiesContext //Wird die Daten wieder zurückdrehen
    public void deleteById_basic(){
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }
    @Test
    @DirtiesContext //Wird die Daten wieder zurückdrehen -_> Damit gibt es keine Abhängigkeiten bzgl. Reihenfolge von Tests
    public void save_basic(){
        //Test Update Fall
        //Cource holen
        Course course = repository.findById(10001L);
        assertEquals("Claus Course", course.getName());
        //Course verändern
        course.setName("Claus Update Course");
        repository.save(course);
        //Course prüfen
        Course course1 = repository.findById(10001L);
        assertEquals("Claus Update Course", course1.getName());
    }
    @Test
    public void playWithEntityManager() {
        logger.info("playWithEntityManager start");
        repository.playWithEntityManager();
    }

    @Test
    public void playWithEntityManager1() {
        logger.info("playWithEntityManager1 start");
        repository.playWithEntityManager1();
    }


}