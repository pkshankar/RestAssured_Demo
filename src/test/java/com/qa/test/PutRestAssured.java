package com.qa.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.UpdateUser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRestAssured {

	@Test
	public void updateUserInfo() throws JsonProcessingException {

		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer 7_7bk8nRTMj2mI9UbmtNLVmunksMPAfWcBYv");
		UpdateUser updateUser = new UpdateUser("Brew", "Lewy", "lewy@brew.com", "active");
		ObjectMapper mapper = new ObjectMapper();
		request.body(mapper.writeValueAsString(updateUser));
		Response response = request.put("/public-api/users/123");
		response.prettyPrint();

	}

	@Test
	public void updateUserBdd() throws JsonProcessingException {

		UpdateUser updateUser = new UpdateUser("Tin", "Sam", "sam@tin1.com", "inactive");
		ObjectMapper mapper = new ObjectMapper();
		String updateUserPayload = mapper.writeValueAsString(updateUser);
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 7_7bk8nRTMj2mI9UbmtNLVmunksMPAfWcBYv").body(updateUserPayload).when()
				.log().all().put("/public-api/users/123").then().assertThat().statusCode(200);

	}

}
