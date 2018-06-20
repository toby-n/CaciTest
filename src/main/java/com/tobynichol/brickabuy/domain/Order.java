package com.tobynichol.brickabuy.domain;

import javax.persistence.*;

@Entity
@Table(name = "brick_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;


    @Column(name = "num_of_bricks")
    public Integer numOfBricks;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
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
