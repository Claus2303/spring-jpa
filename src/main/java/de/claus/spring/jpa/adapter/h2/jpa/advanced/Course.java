package de.claus.spring.jpa.adapter.h2.jpa.advanced;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
//@NamedQuery(name="query_get_all_courses", query = "Select c From Course c")
@NamedQueries(value={
            @NamedQuery(name="query_get_all_courses", query = "Select c From Course c"),
            @NamedQuery(name="query_get_special_courses", query = "Select c From Course c where name like '%DDD'")})
//@Table(name="CourseDetails")//SOnst der Klassenname. Mit JPL kann man trotzdem über den Klassennamen zugreifen
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(name="fullname", nullable = false)//Änderung der Tabelle. Auch in der SQL.Datei muss dies angepasst werden
    //Weitere Beispiele für Attribute siehe Column Interface
    private String name;

    @UpdateTimestamp //Ist Hibernate Marker! Gibt es nicht im JPA Standard
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp //Hibernate!
    private LocalDateTime createdDate;

    protected Course(){}

    public Course(String name){
        this.name = name;
    }
}
