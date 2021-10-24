package de.claus.spring.jpa.adapter.h2.jpa.relation;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    protected Passport(){};
    public Passport(String number){
        this.number = number;
    }
}
