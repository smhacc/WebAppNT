package com.webshop.backend.service;

import com.webshop.backend.exception.RecordNotFoundException;
import com.webshop.backend.model.CategoriesEntity;
import com.webshop.backend.repository.CategoriesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository repository;

    public List<CategoriesEntity> getAllCategories()
    {
        List<CategoriesEntity> categoriesList = repository.findAll();

        if(categoriesList.size() > 0) {
            return categoriesList;
        } else {
            return new ArrayList<CategoriesEntity>();
        }
    }

    public CategoriesEntity getCategoriesById(Integer id) throws RecordNotFoundException
    {
        Optional<CategoriesEntity> categories = repository.findById(id);

        if(categories.isPresent()) {
            return categories.get();
        } else {
            throw new RecordNotFoundException("No categories record exist for given id");
        }
    }

    public CategoriesEntity createOrUpdateCategories(CategoriesEntity entity) throws RecordNotFoundException
    {
        Optional<CategoriesEntity> categories = repository.findById(entity.getId());

        if(categories.isPresent())
        {
            CategoriesEntity newEntity = categories.get();
            //newEntity.setId(entity.getId());
            newEntity.setName(entity.getName());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteCategoriesById(Integer id) throws RecordNotFoundException
    {
        Optional<CategoriesEntity> categories = repository.findById(id);

        if(categories.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No categories record exist for given id");
        }
    }
}
