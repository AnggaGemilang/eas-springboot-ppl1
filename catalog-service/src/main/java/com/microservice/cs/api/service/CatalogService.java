package com.microservice.cs.api.service;

import com.microservice.cs.api.common.AddCatalogRequest;
import com.microservice.cs.api.common.CatalogResponse;
import com.microservice.cs.api.common.CatalogResponseList;
import com.microservice.cs.api.entity.Catalog;
import com.microservice.cs.api.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository repository;

    public CatalogResponse addCatalog(AddCatalogRequest request){
        Catalog catalog = request.getCatalog();
        repository.save(catalog);
        return new CatalogResponse(catalog, "Data Berhasil Ditambahkan");
    }

    public CatalogResponse updateStok(Catalog catalog){
        repository.save(catalog);
        return new CatalogResponse(catalog, "Stok Berkurang");
    }

    public CatalogResponse getIdCatalogResponse(Integer catalogId){
        Optional<Catalog> oCatalog = repository.findById(catalogId);
        Catalog catalogTemp = new Catalog();
        if(!oCatalog.isEmpty()){
            Catalog catalog = oCatalog.get();
            return new CatalogResponse(catalog,"Data Berhasil Ditampilkan!");
        } else{
            return new CatalogResponse(catalogTemp,"Data Gagal Ditampilkan!");
        }
    }

    public CatalogResponse deleteData(Integer catalogId){
        Optional<Catalog> oCatalog = repository.findById(catalogId);
        Catalog catalogTemp = new Catalog();
        repository.deleteById(catalogId);
        if(!oCatalog.isEmpty()){
            Catalog catalog = oCatalog.get();
            return new CatalogResponse(catalog,"Data Berhasil Dihapus!");
        } else{
            return new CatalogResponse(catalogTemp,"Data gagal Dihapus!");
        }
    }

    public CatalogResponseList getCatalogResponse(){
        List<Catalog> oCatalog = repository.findAll();
        return new CatalogResponseList(oCatalog, "Data berhasil ditampilkan!");
    }

}
