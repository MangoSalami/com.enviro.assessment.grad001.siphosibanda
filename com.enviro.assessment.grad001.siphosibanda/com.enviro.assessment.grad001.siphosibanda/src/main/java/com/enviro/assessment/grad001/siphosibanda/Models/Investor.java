package com.enviro.assessment.grad001.siphosibanda.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "investor")
public class Investor {
    @Id
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("first_name")


    @Column(name = "first_name")
    private String firstName;
    @JsonProperty("last_name")

    @Column(name = "last_name")
    private String lastName;
    @JsonProperty("address")

    @Column(name = "address")
    private String address;
    @JsonProperty("contact")

    @Column(name = "contact")
    private String contact;
    @JsonProperty("age")
    @Column(name = "age")
    private int age;

    public int getAge() {

        return age;
    }
    public Long getId() {

        return id;
    }
    // Getters and setters...
}
