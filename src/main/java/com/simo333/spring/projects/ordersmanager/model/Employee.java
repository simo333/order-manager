package com.simo333.spring.projects.ordersmanager.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "To pole nie może być puste")
    @Size(min = 3, max = 20, message = "Imię musi zawierać od 3 do 20 znaków")
    private String name;
    @NotNull(message = "To pole nie może być puste")
    @Size(min = 3, max = 30, message = "Nazwisko musi zawierać od 3 do 40 znaków")
    private String lastName;
    @NotNull(message = "To pole nie może być puste")
    @Past(message = "Data urodzenia musi być z przeszłości")
    private Date dateOfBirth;
    @NotNull(message = "To pole nie może być puste")
    @Size(min = 3, max = 100, message = "Nazwa ulicy musi zawierać od 3 do 100 znaków")
    private String street;
    @NotNull(message = "To pole nie może być puste")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Kod pocztowy musi być w formacie 00-000")
    private String zipCode;
    @NotNull(message = "To pole nie może być puste")
    @Size(min = 3, max = 50, message = "Nazwa miejscowości musi zawierać od 3 do 50 znaków")
    private String city;
    @NotNull(message = "To pole nie może być puste")
    @Size(min = 2, max = 50, message = "Nazwa państwa musi zawierać od 2 do 50 znaków")
    private String country;
    @NotNull(message = "To pole nie może być puste")
    @Pattern(regexp = "(\\+\\d{2})?\\d{9}",
             message = "Numer telefonu może zawierać numer kierunkowy oraz musi zawierać 9 cyfr")
    private String phoneNumber;
    @Past(message = "Data zawarcia umowy musi być z przeszłości")
    private Date contractBeginning;
    @Future(message = "Data zakończenia umowy musi być z przyszłości")
    private Date contractExpiration;
    @ManyToOne
    private JobPosition jobPosition;

}
