package com.simo333.spring.projects.ordersmanager.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "models", uniqueConstraints = {@UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "innerName")})
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 50)
    private String name;
    @NotNull
    @Size(min = 3, max = 50)
    private String innerName;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private FurnitureType type;
}


