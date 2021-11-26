package com.example.cs5500serverjava;

import com.example.cs5500serverjava.controllers.ActivityController;
import com.example.cs5500serverjava.controllers.UserController;
import com.example.cs5500serverjava.models.User;
import com.example.cs5500serverjava.repositories.ActivityRepository;
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
 * Test Class for the UserController class api's.
 * Sources used for this test class: https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService service;
    @MockBean
    private UserController controller;
    @MockBean
    private UserRepository repository;
    @MockBean
    private DateRecordedService dateRecordedService;


    @Test
    public void getAllUsers() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllUsersCount() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/users/all/count")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getAllDataForAUser() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/users/{userId}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addANewUser() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/api/users/newUser")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addANewUserWithId() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/api/users/newUser/{userId}", 1111111)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deletesAUser() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .delete("/api/users/{userId}", 10000)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
