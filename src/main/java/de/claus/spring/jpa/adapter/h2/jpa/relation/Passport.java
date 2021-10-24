package de.claus.spring.jpa.adapter.h2.jpa.relation;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")//wenn mappedBy dann wird keine ID in Passport eingefügt --> Dies hat Auswirkungen auf die SQLs
    private Student student;

    protected Passport(){};
    public Passport(String number){
        this.number = number;
    }
}
