package com.webshop.backend.service;

import com.webshop.backend.exception.RecordNotFoundException;
import com.webshop.backend.model.DeliveryEntity;
import com.webshop.backend.repository.DeliveryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository repository;

    public List<DeliveryEntity> getAllDelivery()
    {
        List<DeliveryEntity> deliveryList = repository.findAll();

        if(deliveryList.size() > 0) {
            return deliveryList;
        } else {
            return new ArrayList<DeliveryEntity>();
        }
    }

    public DeliveryEntity getDeliveryById(Integer id) throws RecordNotFoundException
    {
        Optional<DeliveryEntity> delivery = repository.findById(id);

        if(delivery.isPresent()) {
            return delivery.get();
        } else {
            throw new RecordNotFoundException("No delivery record exist for given id");
        }
    }

    public DeliveryEntity createOrUpdateDelivery(DeliveryEntity entity) throws RecordNotFoundException
    {
        Optional<DeliveryEntity> delivery = repository.findById(entity.getId());

        if(delivery.isPresent())
        {
            DeliveryEntity newEntity = delivery.get();
            //newEntity.setId(entity.getId());
            newEntity.setCity(entity.getCity());
            newEntity.setStreet(entity.getStreet());
            newEntity.setHome(entity.getHome());
            newEntity.setApartment(entity.getApartment());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteDeliveryById(Integer id) throws RecordNotFoundException
    {
        Optional<DeliveryEntity> delivery = repository.findById(id);

        if(delivery.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No delivery record exist for given id");
        }
    }
}

