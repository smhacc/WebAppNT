/*
 * Copyright
 */
package com.webshop.backend.repository;

import com.webshop.backend.model.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Categories repository.
 */

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {
}
