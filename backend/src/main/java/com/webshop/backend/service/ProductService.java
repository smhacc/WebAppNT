package com.webshop.backend.service;

import com.webshop.backend.exception.RecordNotFoundException;
import com.webshop.backend.model.ProductEntity;
import com.webshop.backend.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductEntity> getAllProduct()
    {
        List<ProductEntity> productList = repository.findAll();

        if(productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<ProductEntity>();
        }
    }

    public ProductEntity getProductById(Integer id) throws RecordNotFoundException
    {
        Optional<ProductEntity> product = repository.findById(id);

        if(product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No product record exist for given id");
        }
    }

    public ProductEntity createOrUpdateProduct(ProductEntity entity) throws RecordNotFoundException
    {
        Optional<ProductEntity> product = repository.findById(entity.getId());

        if(product.isPresent())
        {
            ProductEntity newEntity = product.get();
            //newEntity.setId(entity.getId());
            newEntity.setCategory(entity.getCategory());
            newEntity.setDescription(entity.getDescription());
            newEntity.setName(entity.getName());
            newEntity.setPrice(entity.getPrice());
            newEntity.setImage(entity.getImage());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteProductById(Integer id) throws RecordNotFoundException
    {
        Optional<ProductEntity> product = repository.findById(id);

        if(product.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No product record exist for given id");
        }
    }
}

