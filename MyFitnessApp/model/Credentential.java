package com.example.MyFitnessApp.model;

import com.example.MyFitnessApp.dto.CreateCredententialDTO;
import jakarta.persistence.*;
import org.hibernate.mapping.Join;

@Entity
public class Credentential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;


    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Credentential(CreateCredententialDTO createCredententialDTO) {
        this.username = createCredententialDTO.getUsername();
        this.password = createCredententialDTO.getPassword();
    }

    public Credentential() {

    }

    public Credentential(long id, String username, String password, Person person) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.person = person;
    }

    public Credentential(String username, String password, Person person) {

        this.username = username;
        this.password = password;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
