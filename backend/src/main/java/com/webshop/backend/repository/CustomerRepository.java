/*
 * Copyright
 */

package com.webshop.backend.repository;

import com.webshop.backend.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Customer repository.
 */

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
