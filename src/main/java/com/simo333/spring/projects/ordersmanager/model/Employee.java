package com.simo333.spring.projects.ordersmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String street;
    private String zipCode;
    private String city;
    private String country;
    private String phoneNumber;
    private Date contractBeginning;
    private Date contractExpiration;
    @ManyToOne
    private JobPosition jobPosition;

}
