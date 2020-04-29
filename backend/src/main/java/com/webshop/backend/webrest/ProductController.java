package com.webshop.backend.webrest;

import com.webshop.backend.exception.RecordNotFoundException;
import com.webshop.backend.model.ProductEntity;
import com.webshop.backend.service.ProductService;
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
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        List<ProductEntity> list = service.getAllProduct();

        return new ResponseEntity<List<ProductEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable("id") Integer id)
        throws RecordNotFoundException {
        ProductEntity entity = service.getProductById(id);

        return new ResponseEntity<ProductEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createOrUpdateProduct(ProductEntity product)
        throws RecordNotFoundException {
        ProductEntity updated = service.createOrUpdateProduct(product);
        return new ResponseEntity<ProductEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProductById(@PathVariable("id") Integer id)
        throws RecordNotFoundException {
        service.deleteProductById(id);
        return HttpStatus.FORBIDDEN;
    }

}