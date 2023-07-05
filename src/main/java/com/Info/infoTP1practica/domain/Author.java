package com.Info.infoTP1practica.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @Column(name = "name", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = true)
    private String name;
    @Column(name = "lastName", length = 40, columnDefinition = "varchar(40)", updatable = false, nullable = true)
    private String lastName;
    @Temporal(TemporalType.DATE)
    //Pasra guardar la fecha sin la hora
    @Column(name = "birthdate", nullable = true)
    private Date birthdate;
}
