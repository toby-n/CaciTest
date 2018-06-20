package com.tobynichol.brickabuy.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@ActiveProfiles("CustomerRepoTest")
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void save(){
        Customer customerTest = new Customer();
        customerRepo.save(customerTest);
        assertThat(customerRepo.findAll().size()).isEqualTo(1);
    }
}