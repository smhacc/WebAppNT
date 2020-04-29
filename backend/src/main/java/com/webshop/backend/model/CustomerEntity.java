package com.webshop.backend.model;

/*
 * Copyright
 */

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The type Customer.
 */

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
    @Id
    @SequenceGenerator(name = "IdSeq", sequenceName = "ID_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdSeq")
    @Column(name = "CUSTOMER_ID")
    private Integer id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD", columnDefinition = "bpchar")
    private char[] password;

    @Column(name = "CUSTOMER_FIRST_NAME")
    private String first_name;

    @Column(name = "CUSTOMER_LAST_NAME")
    private String last_name;

    @Column(name = "CUSTOMER_EMAIL")
    private String email;

    @Column(name = "CUSTOMER_PHONE_NUMBER")
    private String phone_number;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DELIVERY_ID", foreignKey = @ForeignKey(name = "CUST_AD_FK"))
    private DeliveryEntity delivery;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ORDERS_ID", foreignKey = @ForeignKey(name = "CUST_ORD_ID_FK"))
    private OrderEntity order;

    /**
     * Instantiates a new Customer.
     */
    public CustomerEntity() {
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Sets first name.
     *
     * @param first_name the first name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Sets last name.
     *
     * @param last_name the last name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Get password char [ ].
     *
     * @return the char [ ]
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(char[] password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * Sets phone number.
     *
     * @param phone_number the phone number
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * Gets delivery address.
     *
     * @return the delivery
     */

    public DeliveryEntity getDelivery() {
        return delivery;
    }

    /**
     * Sets delivery address.
     *
     * @param delivery the address
     */
    public void setDelivery(DeliveryEntity delivery) {
        this.delivery = delivery;
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public OrderEntity getOrder() {
        return order;
    }

    /**
     * Sets orer.
     *
     * @param order the order
     */
    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
