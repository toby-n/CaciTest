package com.tobynichol.brickabuy.controller;

import com.tobynichol.brickabuy.domain.Order;
import com.tobynichol.brickabuy.domain.OrderNotFoundException;
import com.tobynichol.brickabuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*This Controller defines the end-point routes for the rest API*/
@RestController
public class ApiController {

    //Inject our order service.
    @Autowired
    private OrderService orderService;

    //Test app is functioning by going to this route.
    @GetMapping("/")
    public String testMapping(){
        return "Howdy";
    }

    //To list all orders go to this route.
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.findAllOrders();
    }

    //To find a single order send an ID to this route.
    @ExceptionHandler(OrderNotFoundException.class)
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable("id") Integer id){

        if (orderService.findOrderbyId(id) == null)
            throw new OrderNotFoundException("id-" + id); //Custom error handling

        return orderService.findOrderbyId(id); //else return the object found.
    }

    //To create a new order post the number of bricks and the customer ID to this route.
    @PostMapping("/create_order")
    public Integer createOrder(@RequestBody Order order)
    {
        return this.orderService.save(order);
    }

}
