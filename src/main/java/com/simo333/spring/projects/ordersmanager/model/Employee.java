package com.simo333.spring.projects.ordersmanager.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;
    @NotNull
    @Past
    private LocalDate dateOfBirth;
    @NotNull
    @Size(min = 3, max = 100)
    private String street;
    @NotNull
    @Pattern(regexp = "^\\d{2}-\\d{3}$")
    private String zipCode;
    @NotNull
    @Size(min = 3, max = 50)
    private String city;
    @NotNull
    @Size(min = 2, max = 50)
    private String country;
    @NotNull
    @Pattern(regexp = "^(\\+\\d{2})?\\d{9}$")
    private String phoneNumber;
    @Past
    private LocalDate contractBeginning;
    @Future
    private LocalDate contractExpiration;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

}
