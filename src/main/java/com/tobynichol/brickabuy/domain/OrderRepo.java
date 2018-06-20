package com.tobynichol.brickabuy.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Integer> {

    @Override
    List<Order> findAll ();

    Order findOrderById(Integer id);

}
