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

    public void playWithEntityManager(){
        Course course = new Course("DDD Course");
        entityManager.persist(course);
        entityManager.flush(); //Änderungen werden in DB übernommen

        Course course1 = new Course("DDD1 Course");
        entityManager.persist(course1);
        entityManager.flush(); //Änderungen werden in DB übernommen

        entityManager.clear();//nächste Änderungen werden nicht durch em übernommen

        entityManager.detach(course1);// --> dann würde course1 Änderungen nicht mehr übernommen werden

        course.setName("DDD Course Update");//das würde ausgeführt wegen Transactional --> man sieht ein Update
        entityManager.flush(); //Änderungen werden in DB übernommen

        entityManager.refresh(course1);//Hier wird wieder der aktuell Stand aus der DB geholt für course1

        course1.setName("DDD1 Course Update");//das würde ausgeführt wegen Transactional --> man sieht ein Update
        entityManager.flush(); //Änderungen werden in DB übernommen
    }

    public void playWithEntityManager1() {
        Course course = new Course("DDD First");
        entityManager.persist(course);

        Course course1 = new Course("DDD Second");
        entityManager.persist(course1);
    }

}
