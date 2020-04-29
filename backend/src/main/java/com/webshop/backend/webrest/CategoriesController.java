package com.webshop.backend.webrest;

import com.webshop.backend.exception.RecordNotFoundException;
import com.webshop.backend.model.CategoriesEntity;
import com.webshop.backend.service.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Categories")
public class CategoriesController
{
    @Autowired
    CategoriesService service;

    @GetMapping
    public ResponseEntity<List<CategoriesEntity>> getAllCategories() {
        List<CategoriesEntity> list = service.getAllCategories();

        return new ResponseEntity<List<CategoriesEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriesEntity> getCategoriesById(@PathVariable("id") Integer id)
        throws RecordNotFoundException {
        CategoriesEntity entity = service.getCategoriesById(id);

        return new ResponseEntity<CategoriesEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriesEntity> createOrUpdateCategories(CategoriesEntity Categories)
        throws RecordNotFoundException {
        CategoriesEntity updated = service.createOrUpdateCategories(Categories);
        return new ResponseEntity<CategoriesEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCategoriesById(@PathVariable("id") Integer id)
        throws RecordNotFoundException {
        service.deleteCategoriesById(id);
        return HttpStatus.FORBIDDEN;
    }

}