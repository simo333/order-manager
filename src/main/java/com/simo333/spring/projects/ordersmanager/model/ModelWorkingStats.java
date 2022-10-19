package com.simo333.spring.projects.ordersmanager.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ModelWorkingStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "model_id", updatable = false)
    private Model model;
    @ManyToOne
    @JoinColumn(name = "job_position_id", updatable = false)
    private JobPosition jobPosition;
    @Digits(integer = 3, fraction = 2)
    @NotNull
    @Positive
    private BigDecimal rate;
    @NotNull
    @Positive
    private int timeToComplete;
}
