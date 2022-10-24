package com.springframework.msscbeerclient.web.client;

import com.springframework.msscbeerclient.web.model.BeerDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class BreweryClientTest {
    @Autowired
    BreweryClient client;

   @Test
    public void getBeerById(){
       BeerDto dto = client.getBeerById(UUID.randomUUID());
       Assert.assertNotNull(dto);
   }
}