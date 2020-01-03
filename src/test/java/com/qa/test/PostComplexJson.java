package com.qa.test;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.BookingDates;
import com.qa.pojo.BookingDetails;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostComplexJson {

	@Test
	public void createBooking() throws JsonProcessingException {

		BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");
		BookingDetails bookingDetails = new BookingDetails("Jim", "Brown", 111, true, bookingDates,"Breakfast");
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Content-Type", "application/json");
		ObjectMapper mapper = new ObjectMapper();
		String createBookingPayload = mapper.writeValueAsString(bookingDetails);
		System.out.println(createBookingPayload);
		request.body(createBookingPayload);
		Response response = request.post("/booking");
		response.prettyPrint();
		
}

}