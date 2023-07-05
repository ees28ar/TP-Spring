package com.Info.infoTP1practica.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = true)
    private UUID uuid;
    @Column(name = "title", length = 40, columnDefinition = "varchar(40)", updatable = true, nullable = true)
    private String title;
    @Column(name = "Author", length = 40, columnDefinition = "varchar(40)", updatable = false, nullable = true)
    private String author;
    }