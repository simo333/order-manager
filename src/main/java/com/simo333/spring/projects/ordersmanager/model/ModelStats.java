package com.simo333.spring.projects.ordersmanager.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@IdClass(ModelStatsPkId.class)
public class ModelStats {
    @Id
    @ManyToOne
    private Model model;
    @Id
    @ManyToOne
    private JobPosition jobPosition;
    private BigDecimal rate;
    private int timeToComplete;
}
