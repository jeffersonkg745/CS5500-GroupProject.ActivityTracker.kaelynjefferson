package com.example.cs5500serverjava;

import com.example.cs5500serverjava.controllers.ActivityController;
import com.example.cs5500serverjava.repositories.ActivityRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
/**
 * Test Class for the ActivityController class api's.
 * Sources used for this test class: https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ActivityController.class)
class ActivityTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private DateRecordedService dateRecordedService;
	@MockBean
	private ActivityRepository activityRepository;
	@MockBean
	private UserService userService;


//TESTS FOR VISUALIZATION 1
	@Test
	public void getAllActivitiesCount() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/count")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void getWalkingActivitiesCount() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/walking/count")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getRunningActivitiesCount() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/running/count")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getTransportActivitiesCount() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/transport/count")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getCyclingActivitiesCount() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/cycling/count")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getOtherActivitiesCount() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/other/count")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getKayakingActivitiesCount() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/kayaking/count")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

//TESTS FOR VISUALIZATION 2
	@Test
	public void getWalkingTotalTime() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/walking/total-time")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getRunningTotalTime() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/running/total-time")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getCyclingTotalTime() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/cycling/total-time")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getTransportTotalTime() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/transport/total-time")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getOtherTotalTime() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/other/total-time")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

//TESTS FOR VISUALIZATION 3
	@Test
	public void getWalkingAvgCalories() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/walking/calories/average")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getRunningAvgCalories() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/running/calories/average")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getCyclingAvgCalories() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/cycling/calories/average")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getKayakingAvgCalories() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/kayaking/calories/average")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getCrossCountrySkiingAvgCalories() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/crosscountryskiing/calories/average")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

//GENERAL TESTS
	@Test
	public void getAllActivityData() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getAllActivityDataForUser() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/{userId}/date-recorded/segments/move/activity", 1)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getAllActivityDataOfWalking() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/walking")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getAllActivityDataOfRunning() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/running")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getAllActivityDataOfTransport() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/transport")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getAllActivityDataOfCycling() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/cycling")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getAllActivityDataOfKayaking() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/kayaking")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	public void getAllActivityDataOfOther() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/user/date-recorded/segments/move/activity/other")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}


}
