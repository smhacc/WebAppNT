/*
 * Copyright
 */
package com.webshop.backend.repository;

import com.webshop.backend.model.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Delivery repository.
 */

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Integer> {
}
