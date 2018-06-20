package com.tobynichol.brickabuy.domain;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
}
