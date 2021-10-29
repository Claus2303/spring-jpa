package de.claus.spring.jpa.adapter.h2.jpa.relation;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "course" )//Damit holt er sich die Beziehung über die andere Tabelle ////Lazy Fetching ist Default
    private List<Review> reviews = new ArrayList<>();
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();//Wenn die Beziehung auf beiden Seiten ist würden 2 Tabellen erzeugt

    protected Course(){}

    public Course(String name){
        this.name = name;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }
    public void removeReview(Review review){
        this.reviews.remove(review);
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
