package it.truecloud.ddns.felix.models.author;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String secondName;
    private String surname;
    private Integer yearOfBirth;
    
    public Author(Long id, String firstName, String secondName, String surname, Integer yearOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }

    public Author() {}

    public Long getId() {
        return id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    @Column(name = "year_of_birth")
    public Integer getDateOfBirth() {
        return yearOfBirth;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Author author = (Author) obj;
        return (author.firstName.equals(firstName) &&
            author.secondName.equals(secondName) &&
            author.surname.equals(surname) &&
            author.yearOfBirth == yearOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, surname, yearOfBirth);
    }
}
