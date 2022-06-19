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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime placedAt;

    @NotNull(message = "Termin dostawy jest wymagany")
    @Future(message = "Termin zamówienia musi odnosić się do przyszłości")
    private Date deadlineDate;

    @NotNull(message = "Nazwa dostawy jest wymagana")
    @Size(min = 3, max = 100, message = "Nazwa musi zawierać od 3 do 100 znaków")
    private String deliveryName;

    @NotNull(message = "Ulica jest wymagana")
    @Size(min = 3, max = 100, message = "Nazwa ulicy musi zawierać od 3 do 100 znaków")
    private String deliveryStreet;

    @NotNull(message = "Miejscowość jest wymagana")
    @Size(min = 3, max = 100, message = "Nazwa miejscowości musi zawierać od 3 do 100 znaków")
    private String deliveryCity;

    @NotNull(message = "Kod pocztowy jest wymagany")
    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Kod pocztowy musi być w formacie 00-000")
    private String deliveryZip;

    @NotNull(message = "Państwo jest wymagane")
    @Size(min = 3, max = 100, message = "Nazwa państwa musi zawierać od 3 do 100 znaków")
    private String deliveryCountry;

    //TODO Add deleting ordered models while deleting order containing those ordered models (error when deleted order with ordered models)
    @NotNull(message = "Zamówienie musi zawierać conajmniej jeden model ")
    @OneToMany
    private List<OrderedModel> orderedModels = new ArrayList<>();

    @PrePersist
    void placedAt() {
        this.placedAt = ZonedDateTime.now(ZoneId.systemDefault());
    }

}
