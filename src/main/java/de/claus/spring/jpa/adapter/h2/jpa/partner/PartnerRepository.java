package de.claus.spring.jpa.adapter.h2.jpa.partner;

import de.claus.spring.jpa.adapter.h2.jpa.partner.Entity.Adresse;
import de.claus.spring.jpa.adapter.h2.jpa.partner.Entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PartnerRepository {

    @Autowired
    EntityManager entityManager;

    public void savePartner(Partner partner){
        if (partner.getId()==null){
            entityManager.persist(partner);
        }
        else{
            entityManager.merge(partner);
        }

    }

    public Partner findById(Long id){
        return entityManager.find(Partner.class, id);
    }

    public void addAdresse(Adresse adresse, Long id){
        Partner partner = findById(id);
        partner.addAdresse(adresse);
    }
}
