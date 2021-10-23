package de.claus.spring.jpa.adapter.h2.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    /**
     *
     * @param id
     * @return
     */
    public Person findById(int id){

        return entityManager.find(Person.class, id);
    }

    /**
     *
     * @param person
     * @return
     */
    public Person update(Person person){
        //Update und Insert wird gleich verwendet
        return entityManager.merge(person);
    }

    /**
     * Kein Unterschied zu update
     * @param person
     * @return
     */
    public Person insert(Person person){
        //Update und Insert wird gleich verwendet
        return entityManager.merge(person);
    }

    public void delete(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
        TypedQuery<Person> find_all_persons = entityManager.createNamedQuery("find_all_persons", Person.class);
        return find_all_persons.getResultList();
    }
}
