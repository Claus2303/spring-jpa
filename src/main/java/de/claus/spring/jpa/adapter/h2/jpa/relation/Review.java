package de.claus.spring.jpa.adapter.h2.jpa.relation;

import lombok.Data;
import org.springframework.remoting.support.RemoteInvocationExecutor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    private String description;

    protected Review(){

    }
    public Review (String rating, String description){
        this.rating = rating;
        this.description = description;
    }
}
