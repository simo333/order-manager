package com.simo333.spring.projects.ordersmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
    @JoinColumn(updatable = false)
    private Model model;
    @Id
    @ManyToOne
    @JoinColumn(updatable = false)
    private JobPosition jobPosition;
    @NotNull(message = "To pole nie może być puste")
    @Positive(message = "Stawka musi być liczbą dodatnią")
    private BigDecimal rate;
    @NotNull(message = "To pole nie może być puste")
    @Positive(message = "Czas jest wymagany")
    private int timeToComplete;
}
