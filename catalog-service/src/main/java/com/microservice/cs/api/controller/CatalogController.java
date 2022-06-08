package com.microservice.cs.api.controller;

import com.microservice.cs.api.common.AddCatalogRequest;
import com.microservice.cs.api.common.CatalogResponse;
import com.microservice.cs.api.common.CatalogResponseList;
import com.microservice.cs.api.entity.Catalog;
import com.microservice.cs.api.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService service;
    @PostMapping("/addCatalog")
    private CatalogResponse addCatalog(@RequestBody AddCatalogRequest request){return service.addCatalog(request);}
    @PostMapping("/updateStok")
    private CatalogResponse updateStok(@RequestBody Catalog catalog){return service.updateStok(catalog);}
    @GetMapping("/{catalogId}")
    private CatalogResponse findCatalogById(@PathVariable int catalogId){return service.getIdCatalogResponse(catalogId);}
    @DeleteMapping("/{catalogId}")
    private CatalogResponse deleteData(@PathVariable int catalogId){return service.deleteData(catalogId);}
    @GetMapping("/")
    private CatalogResponseList getAllCatalog(){return service.getCatalogResponse();}
}
