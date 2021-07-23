package it.truecloud.ddns.felix.models.persons.author;

import javax.persistence.Entity;
import javax.persistence.Table;

import it.truecloud.ddns.felix.models.persons.Person;

/**
 * The class represents author of either books, CDs or DVDs.
 */
@Entity
@Table(name = "authors")
public class Author extends Person { 
    public Author(Long id, String firstName, String secondName, String surname, Integer yearOfBirth) {
        super(id, firstName, secondName, surname, yearOfBirth);
    }

    public Author() {}
}