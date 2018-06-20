package com.tobynichol.brickabuy.service;


import com.tobynichol.brickabuy.domain.OrderRepo;
import com.tobynichol.brickabuy.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> findAllOrders() {

        return this.orderRepo.findAll();

    }

    public Order findOrderbyId(Integer id){
        return this.orderRepo.findOrderById(id);
    }

    public Integer save(Order order) {

        return this.orderRepo.save(order).id;

    }
}
