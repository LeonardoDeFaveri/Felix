package it.truecloud.ddns.felix.models.persons.actor;

import javax.persistence.Entity;
import javax.persistence.Table;

import it.truecloud.ddns.felix.models.persons.Person;

@Entity
@Table(name = "actors")
public class Actor extends Person {
    public Actor(Long id, String firstName, String secondName, String surname, Integer yearOfBirth) {
        super(id, firstName, secondName, surname, yearOfBirth);
    }

    public Actor() {}
}