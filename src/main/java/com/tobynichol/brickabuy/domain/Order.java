package com.tobynichol.brickabuy.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "brick_orders") //Order is a reserved term so change to brick_orders
public class Order {

    //ID and reference number.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    //Number of bricks.
    @Column(name = "num_of_bricks")
    public Integer numOfBricks;

    //One to one relationship with customer.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @NotNull
    public Customer customer;

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumOfBricks() {
        return numOfBricks;
    }

    public void setNumOfBricks(Integer numOfBricks) {
        this.numOfBricks = numOfBricks;
    }
}
