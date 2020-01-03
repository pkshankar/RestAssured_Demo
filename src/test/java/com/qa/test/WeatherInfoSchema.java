package com.qa.test;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherInfoSchema {

	
	@Test
	public void  validateWeatherSchema() {
		
		RestAssured.baseURI="http://restapi.demoqa.com";
		RestAssured.given().log().all()
					.when().log().all()
					.get("/utilities/weather/city/delhi")
					.then()
					.assertThat()
					.body(matchesJsonSchemaInClasspath("WeatherInfoSchema.json"));
		
		
	}
}
