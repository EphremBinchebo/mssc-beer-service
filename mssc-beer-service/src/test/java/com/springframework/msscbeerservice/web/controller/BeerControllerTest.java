package com.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.msscbeerservice.web.model.BeerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
@RunWith(SpringRunner.class)
public class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = mapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateBeerId() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = mapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }
}