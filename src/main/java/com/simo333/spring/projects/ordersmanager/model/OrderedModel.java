package com.simo333.spring.projects.ordersmanager.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Model model;
    @NotNull
    @Size(min = 1, max = 100, message = "Opis materiału musi zawierać od 1 do 100 znaków")
    private String material;
    private String specialDesign;
}
