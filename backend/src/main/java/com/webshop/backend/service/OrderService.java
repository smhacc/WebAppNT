package com.webshop.backend.service;

import com.webshop.backend.exception.RecordNotFoundException;
import com.webshop.backend.model.OrderEntity;
import com.webshop.backend.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public List<OrderEntity> getAllOrder()
    {
        List<OrderEntity> orderList = repository.findAll();

        if(orderList.size() > 0) {
            return orderList;
        } else {
            return new ArrayList<OrderEntity>();
        }
    }

    public OrderEntity getOrderById(Integer id) throws RecordNotFoundException
    {
        Optional<OrderEntity> order = repository.findById(id);

        if(order.isPresent()) {
            return order.get();
        } else {
            throw new RecordNotFoundException("No order record exist for given id");
        }
    }

    public OrderEntity createOrUpdateOrder(OrderEntity entity) throws RecordNotFoundException
    {
        Optional<OrderEntity> order = repository.findById(entity.getId());

        if(order.isPresent())
        {
            OrderEntity newEntity = order.get();
            //newEntity.setId(entity.getId());
            newEntity.setDiscount(entity.getDiscount());
            newEntity.setComment(entity.getComment());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteOrderById(Integer id) throws RecordNotFoundException
    {
        Optional<OrderEntity> order = repository.findById(id);

        if(order.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No order record exist for given id");
        }
    }
}

