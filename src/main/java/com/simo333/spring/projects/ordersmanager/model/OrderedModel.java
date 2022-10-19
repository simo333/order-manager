package com.simo333.spring.projects.ordersmanager.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordered_models")
public class OrderedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private Model model;
    @NotNull
    @Size(min = 1, max = 100)
    private String material;
    private String specialDesign;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderStats order;
}
