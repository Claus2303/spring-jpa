package de.claus.spring.jpa.adapter.h2.jpa.partner.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Partner {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String vorname;
    @OneToMany(mappedBy = "partner")
    private List<Adresse> adresses = new ArrayList<>();

    @OneToMany(mappedBy = "partner")
    private List<Telekommunikation> telekoms = new ArrayList<>();

    @OneToMany(mappedBy = "partner")
    private List<Vertrag> vertraege = new ArrayList<>();

    protected Partner(){

    }

    public Partner(String name, String vorname){
        this.name = name;
        this.vorname = vorname;
    }

    public void addAdresse(Adresse adresse){
        this.adresses.add(adresse);
    }

    public void removeAdresse(Adresse adresse){
        this.adresses.remove(adresse);
    }

    public void addTelekom(Telekommunikation telekom){
        this.telekoms.add(telekom);
    }

    public void removeTelekom(Telekommunikation telekom){
        this.telekoms.remove(telekom);
    }

    public void addVertrag(Vertrag vertrag){
        this.vertraege.add(vertrag);
    }

    public void removeVertrag(Vertrag vertrag){
        this.vertraege.remove(vertrag);
    }
}
