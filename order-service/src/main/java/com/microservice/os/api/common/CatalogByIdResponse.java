package com.microservice.os.api.common;

import com.microservice.os.api.entity.Catalog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogByIdResponse {
    private Catalog catalog;
    private String msg;
}
