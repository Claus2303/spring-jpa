package de.claus.spring.jpa.adapter.h2.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private int id;
    private String name;
    private String location;
    private Date birthDate;
}
