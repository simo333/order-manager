package com.simo333.spring.projects.ordersmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class OrderStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime placedAt;

    @NotNull
    @Future
    private ZonedDateTime deadlineDate;

    @NotNull
    @Size(min = 3, max = 100)
    private String deliveryName;

    @NotNull
    @Size(min = 3, max = 100)
    private String deliveryStreet;

    @NotNull
    @Size(min = 3, max = 100)
    private String deliveryCity;

    @NotNull
    @Pattern(regexp = "^\\d{2}-\\d{3}$")
    private String deliveryZip;

    @NotNull
    @Size(min = 3, max = 100)
    private String deliveryCountry;

    @OneToMany(mappedBy = "id")
    private Set<OrderedModel> orderedModels = new HashSet<>();

    @PrePersist
    void placedAt() {
        this.placedAt = ZonedDateTime.now(ZoneId.systemDefault());
    }

}
