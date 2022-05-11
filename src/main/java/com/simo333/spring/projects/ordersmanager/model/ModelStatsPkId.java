package com.simo333.spring.projects.ordersmanager.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ModelStatsPkId implements Serializable {
    private Long model;
    private Long jobPosition;
}
