package de.claus.spring.jpa.adapter.h2.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){

        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        //Update und Insert wird gleich verwendet
        return entityManager.merge(person);
    }
}
