package com.microservice.cs.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    @Id
    private Integer catalogId;
    private String name;
    private Long price;
    private Integer stock;
}
