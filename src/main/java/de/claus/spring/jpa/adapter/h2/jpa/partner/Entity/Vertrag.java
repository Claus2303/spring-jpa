package de.claus.spring.jpa.adapter.h2.jpa.partner.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Vertrag {

    @Id
    @GeneratedValue
    private Long id;

    private Integer vnr;
    @ManyToOne
    private Partner partner;



}
