package de.claus.spring.jpa.adapter.h2.jpa.partner.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adresse {

    @Id
    @GeneratedValue
    private Long id;
    private Integer postleitzahl;

    private String ort;

    private String strasse;

    private String hausnummer;
    @ManyToOne
    private Partner partner;
}
