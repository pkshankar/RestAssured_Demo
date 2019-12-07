package com.qa.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.POJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	public Response get(String serviceUrl) {

		RestAssured.baseURI = "https://gorest.co.in/";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Authorization", "Bearer 7_7bk8nRTMj2mI9UbmtNLVmunksMPAfWcBYv");
		// httpRequest.queryParam("access-token",
		// "7_7bk8nRTMj2mI9UbmtNLVmunksMPAfWcBYv");
		httpRequest.queryParam("first_name", "Dana");
		Response response = httpRequest.get(serviceUrl);
		return response;
	}

	@SuppressWarnings("unchecked")
	public Response post(String serviceUrl) {

		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer 7_7bk8nRTMj2mI9UbmtNLVmunksMPAfWcBYv");
		request.header("Content-Type","application/json");
		JSONObject jObj = new JSONObject();
		jObj.put("first_name", "Thomson2");
		jObj.put("last_name", "Peter2");
		jObj.put("gender", "male");
		jObj.put("email", "thomson@peter21.com");
		jObj.put("status", "active");
		request.body(jObj.toJSONString());
		return request.post(serviceUrl);

	}

	
	public Response createUser(String serviceUrl) throws JsonProcessingException {
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer 7_7bk8nRTMj2mI9UbmtNLVmunksMPAfWcBYv");
		request.header("Content-Type","application/json");
		POJO pojo = new POJO("Tim","Jobs","female","jobs@tim.com","active");
		ObjectMapper mapper = new ObjectMapper();
		//mapper.writeValueAsString(pojo);
		request.body(mapper.writeValueAsString(pojo));
		
		return request.post(serviceUrl);

	}
	
public Response createUserJsonFile(String serviceUrl) throws JsonProcessingException, FileNotFoundException {
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer 7_7bk8nRTMj2mI9UbmtNLVmunksMPAfWcBYv");
		request.header("Content-Type","application/json");
		FileInputStream fis = new FileInputStream("C:\\Users\\pkshank\\eclipse-workspace\\RestAssured_Demo\\src\\main\\java\\com\\qa\\json\\createUser.json");
		request.body(fis);
		
		
		return request.post(serviceUrl);

	}
}
