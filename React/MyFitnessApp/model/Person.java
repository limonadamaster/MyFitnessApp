package com.example.MyFitnessApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
public class Person implements Comparable<Person>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
     private String lastName;

    /*public Credentential getCredentential() {
        return credentential;
    }*/
/*
   //public void setCredentential(Credentential credentential) {
        this.credentential = credentential;
    }*/

    @JsonBackReference
   // @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "credentential_id")


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person( String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public Person(Person person)
    {
        this.id= person.getId();
        this.firstName= person.getFirstName();
        this.lastName= person.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person o) {
        if(this.id.equals(o.id)) {
            return 1;
        }
        else
            return 0;
    }
}
