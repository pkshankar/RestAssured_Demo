package com.qa.test;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.client.RestClient;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APITest {

	RestClient restClient;

	@BeforeMethod
	public void setUp() {

		restClient = new RestClient();

	}

	@Test(enabled = false)
	public void getUsers() {

		Response response = restClient.get("/public-api/users");
		response.prettyPrint();
		//System.out.println(response.getBody().asString());
		//System.out.println(response.jsonPath().);
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getHeader("Content-Type"));
		JsonPath jsonPath = response.jsonPath();
		System.out.println("ok "+jsonPath.getJsonObject("result.website"));
		
		

	}
	
	@Test
	public void post() throws JsonProcessingException, FileNotFoundException {
		
//		Response response = restClient.post("/public-api/users");
//		response.prettyPrint();
		
		//Response response = restClient.createUser("/public-api/users");
		Response response = restClient.createUserJsonFile("/public-api/users");
		response.prettyPrint();
	}
	
	@Test
	public void postThroughJsonFile() {
		
		
	}
}
