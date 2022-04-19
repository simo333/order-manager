package com.simo333.spring.projects.ordersmanager.model;

import com.simo333.spring.projects.ordersmanager.model.types.FurnitureType;
import lombok.*;

import javax.persistence.*;

@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String innerName;
    @ManyToOne
    private FurnitureType type;


}
