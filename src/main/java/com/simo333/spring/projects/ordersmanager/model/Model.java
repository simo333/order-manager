package com.simo333.spring.projects.ordersmanager.model;

import com.simo333.spring.projects.ordersmanager.model.types.FurnitureType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "To pole nie może być puste")
    @Size(min = 3, max = 50, message = "Nazwa musi zawierać od 3 do 50 znaków")
    private String name;
    @NotNull(message = "To pole nie może być puste")
    @Size(min = 3, max = 50, message = "Nazwa musi zawierać od 3 do 50 znaków")
    private String innerName;
    @NotNull(message = "Typ jest wymagany")
    @ManyToOne
    private FurnitureType type;
}


