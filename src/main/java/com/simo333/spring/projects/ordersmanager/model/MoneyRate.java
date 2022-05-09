package com.simo333.spring.projects.ordersmanager.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(MoneyRatePKId.class)
public class MoneyRate {
    @Id
    /*@ManyToOne*/
    private Long modelId;
    @Id
    private Long jobPositionId;
    private BigDecimal rate;


}
