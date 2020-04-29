package com.webshop.backend.service;

import com.webshop.backend.exception.RecordNotFoundException;
import com.webshop.backend.model.CustomerEntity;
import com.webshop.backend.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<CustomerEntity> getAllCustomer()
    {
        List<CustomerEntity> customerList = repository.findAll();

        if(customerList.size() > 0) {
            return customerList;
        } else {
            return new ArrayList<CustomerEntity>();
        }
    }

    public CustomerEntity getCustomerById(Integer id) throws RecordNotFoundException
    {
        Optional<CustomerEntity> customer = repository.findById(id);

        if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    }

    public CustomerEntity createOrUpdateCustomer(CustomerEntity entity) throws RecordNotFoundException
    {
        Optional<CustomerEntity> customer = repository.findById(entity.getId());

        if(customer.isPresent())
        {
            CustomerEntity newEntity = customer.get();
            //newEntity.setId(entity.getId());
            newEntity.setFirst_name(entity.getFirst_name());
            newEntity.setLast_name(entity.getLast_name());
            newEntity.setLogin(entity.getLogin());
            newEntity.setPassword(entity.getPassword());
            newEntity.setEmail(entity.getEmail());
            newEntity.setPhone_number(entity.getPhone_number());
            newEntity.setDelivery(entity.getDelivery());
            newEntity.setOrder(entity.getOrder());



            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteCustomerById(Integer id) throws RecordNotFoundException
    {
        Optional<CustomerEntity> customer = repository.findById(id);

        if(customer.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    }
}

