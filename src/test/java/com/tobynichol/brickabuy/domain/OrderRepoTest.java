package com.tobynichol.brickabuy.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    OrderRepo orderRepo;

    private Customer customer = new Customer();
    private Customer customer1 = new Customer();
    private Customer customer2 = new Customer();
    private Customer customer3 = new Customer();
    private Order order = new Order();
    private Order order1 = new Order();
    private Order order2 = new Order();
    private Order order3 = new Order();


    @Before
    public void setUp() throws Exception {

        entityManager.persist(customer);
        entityManager.persist(customer1);
        entityManager.persist(customer2);
        entityManager.persist(customer3);

        order.setNumOfBricks(45);
        order.setCustomer(customer);
        entityManager.persist(order);
        entityManager.flush();

        order1.setNumOfBricks(45);
        order1.setCustomer(customer3);
        entityManager.persist(order1);
        entityManager.flush();

        order2.setNumOfBricks(45);
        order2.setCustomer(customer2);
        entityManager.persist(order2);
        entityManager.flush();


        order3.setNumOfBricks(45);
        order3.setCustomer(customer1);
        entityManager.persist(order3);
        entityManager.flush();
    }

    @Test
    public void save() {


        //when
        List<Order> all = orderRepo.findAll();
        //then
        assertThat(all.size()).isEqualTo(4);

    }

    @Test
    public void findOrderbyId_404() {

        Integer id = 1;
        Order orderTestObj = orderRepo.findOrderById(id);
        assertThat(HttpStatus.NOT_FOUND); //We expect there to be no result.
    }

    @Test
    public void findOrderbyId_200() {

        order.setNumOfBricks(45);
        order.setCustomer(customer);
        entityManager.persist(order);
        Integer id = order.getId();
        Order orderTestObj = orderRepo.findOrderById(id);
        assertThat(HttpStatus.OK); //We expect there to be a 200 status.
        assertThat(orderTestObj == order); // We expect the order returned to be the order recently created.
        //System.out.println("Number of bricks =" + orderTestObj.getNumOfBricks().toString());
    }
}

