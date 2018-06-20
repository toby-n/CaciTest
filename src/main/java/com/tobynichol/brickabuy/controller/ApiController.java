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

    @ExceptionHandler(OrderNotFoundException.class)
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable("id") Integer id){
        return orderService.findOrderbyId(id);
    }

    @PostMapping("/create_order")
    public Integer createOrder(@RequestBody Order order)
    {
        return this.orderService.save(order);
    }

}
