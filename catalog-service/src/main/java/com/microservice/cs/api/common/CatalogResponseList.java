package com.microservice.cs.api.common;

import com.microservice.cs.api.entity.Catalog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogResponseList {
    private List<Catalog> catalog;
    private String msg;
}