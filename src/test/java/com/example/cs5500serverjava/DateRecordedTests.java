package com.example.cs5500serverjava;

import com.example.cs5500serverjava.controllers.DateRecordedController;
import com.example.cs5500serverjava.controllers.UserController;
import com.example.cs5500serverjava.repositories.DateRecordedRepository;
import com.example.cs5500serverjava.repositories.UserRepository;
import com.example.cs5500serverjava.services.DateRecordedService;
import com.example.cs5500serverjava.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test Class for the DateRecordedController class api's.
 * Sources used for this test class: https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DateRecordedController.class)
class DateRecordedTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService service;
    @MockBean
    private DateRecordedController controller;
    @MockBean
    private DateRecordedRepository repository;
    @MockBean
    private DateRecordedService dateRecordedService;

    @Test
    public void getCollectionDatesForAUser() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/user/{user_id}/date-recorded", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getAllSummaryInfo() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/user/all/date-recorded/summary")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getAllSummaryInfoForUser() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/user/{user_id}/date-recorded/summary", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getAllSegmentsInfo() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/user/all/date-recorded/segments")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getAllSegmentsInfoForUser() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/user/{user_id}/date-recorded/segments", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllPlaceInfo() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/user/all/date-recorded/segments/place")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
}

