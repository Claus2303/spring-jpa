package de.claus.spring.jpa.adapter.h2.jpa.relation;

import lombok.Data;
import org.springframework.remoting.support.RemoteInvocationExecutor;

import javax.persistence.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    private String description;
    @ManyToOne //Eager Fetching
    private Course course;

    protected Review(){

    }
    public Review (String rating, String description){
        this.rating = rating;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                ", course=" + course.getId() +
                '}';
    }
}
