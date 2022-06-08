package com.microservice.os.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    private Integer catalogId;
    private String name;
    private Long price;
    private Integer stock;
}
