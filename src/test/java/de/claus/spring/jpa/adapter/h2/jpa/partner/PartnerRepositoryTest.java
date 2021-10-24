package de.claus.spring.jpa.adapter.h2.jpa.partner;

import de.claus.spring.jpa.JPAAdvancedDemoApplication;
import de.claus.spring.jpa.PartnerDemoApplication;
import de.claus.spring.jpa.adapter.h2.jpa.partner.Entity.Partner;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes= PartnerDemoApplication.class)
class PartnerRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PartnerRepository partnerRepository;

    @Test
    void savePartner() {
        Partner partner = new Partner("Schaeffner", "Claus");
        partnerRepository.savePartner(partner);

        logger.info("Neuer Partner anlegegt -> {}",partner);

        Partner findPartner = partnerRepository.findById(partner.getId());
        assertEquals("Schaeffner", findPartner.getName());

        findPartner.setName("SchaeffnerTest");

        partnerRepository.savePartner(findPartner);

        findPartner = partnerRepository.findById(partner.getId());
        assertEquals("SchaeffnerTest", findPartner.getName());

    }

    @Test
    void findById() {
    }

    @Test
    void addAdresse() {
    }
}