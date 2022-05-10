package com.simo333.spring.projects.ordersmanager.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@IdClass(MoneyRatePKId.class)
public class MoneyRate {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model modelId;
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "job_position_id", nullable = false)
    private JobPosition jobPositionId;
    private BigDecimal rate;


}
