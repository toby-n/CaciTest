package com.tobynichol.brickabuy.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    @Override
    List<Customer> findAll ();

    Customer findCustomerById(Integer id);

}
