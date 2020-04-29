package com.webshop.backend.model;
/*
 * Copyright
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The type ORDER.
 */
@Entity
@Table(name = "ORDERS")
public class OrderEntity {
    @Id
    @SequenceGenerator(name = "IdSeq", sequenceName = "ID_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdSeq")
    @Column(name = "ORDERS_ID")
    private Integer id;

    @Column(name = "ORDERS_COMMENT")
    private String comment;

    @Column(name = "ORDERS_DISCOUNT")
    private String discount;

    /**
     * Instantiates a new Order.
     */
    public OrderEntity() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets comment.
     *
     * @return the id
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param id the id
     */
    public void setComment(String id) {
        this.comment = comment;
    }

    /**
     * Gets discount.
     *
     * @return the sale
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Sets discount.
     *
     * @param discount the discount
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
