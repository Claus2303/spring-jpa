package de.claus.spring.jpa.adapter.h2.jpa.relation;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    protected Course(){}

    public Course(String name){
        this.name = name;
    }
}
