package com.example.cs5500serverjava;

import com.example.cs5500serverjava.models.DateRecorded;
import com.example.cs5500serverjava.models.User;
import com.example.cs5500serverjava.services.DateRecordedService;
import com.example.cs5500serverjava.services.UserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;

/**
 * ActivityTrackerApplication class contains the main method. It also contains a runner method to parse our json file
 * into an array, which is later sent to DateRecordedService class and saved to mySQL database. In this project, only
 * one user is created to hold json data.
 */
@SpringBootApplication
public class ActivityTrackerApplication {

	private static UserService userService;

	@Autowired
	private DateRecordedService dateRecordedService;

	public static void main(String[] args) {
		SpringApplication.run(ActivityTrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService){
		return args -> {

			//Adapted from "Read Object array from json array string" and "read object from json file", http://tutorials.jenkov.com/java-json/jackson-objectmapper.html#read-object-from-json-file
			ObjectMapper mapper = new ObjectMapper();

			//ignoring unknown json fields -->//Adapted from "ignore unknown json fields" http://tutorials.jenkov.com/java-json/jackson-objectmapper.html#ignore-unknown-json-fields
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			//File jsonFile = new File("/Users/kaelynjefferson/Desktop/CS5500-Group3/src/main/resources/simple_day.json");
			//File jsonFile = new File("/Users/kaelynjefferson/Desktop/CS5500-Group3/src/main/resources/storyline.json");
			File jsonFile = new File("/Users/kaelynjefferson/Desktop/CS5500-Group3/src/main/resources/storyline_day.json");


			//source used: https://stackoverflow.com/questions/58703834/how-to-read-json-file-from-resources-in-spring-boot
			DateRecorded[] arrayOfDateRecordedFromjson = new DateRecorded[0];

			try {
				arrayOfDateRecordedFromjson = mapper.readValue(jsonFile, DateRecorded[].class);

				//create a new user instance
				User user = new User();
				user = userService.createUser(user);


				for (int i = 0; i < arrayOfDateRecordedFromjson.length; i++) {

					//creates each collectionDate instance for the user
					//stores the unique user id with collectionDate
					arrayOfDateRecordedFromjson[i].setUser(user);
					dateRecordedService.createCollectionDate(arrayOfDateRecordedFromjson[i]);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}
}





