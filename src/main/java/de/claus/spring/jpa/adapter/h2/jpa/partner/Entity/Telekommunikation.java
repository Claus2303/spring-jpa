package de.claus.spring.jpa.adapter.h2.jpa.partner.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "Telekom")
public class Telekommunikation {

    @Id
    @GeneratedValue
    private Long id;
    private Telekomtyp telekomtyp;

    private String wert;

    @ManyToOne
    private Partner partner;



    enum Telekomtyp{
        HANDY, EMAIL
    }
}
