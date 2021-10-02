package com.basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicChecks 
{
	public static void main(String[] args) 
	{
		/* given() => all input details
		 * when() => specify resource, HTTP Method details
		 * then() => validate the response 
		 */
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = 
					given()
							.log().all()
							.queryParam("key", "qaclick123")
							.header("Content-Type", "application/json")
							.body("{\r\n"
									+ "  \"location\": {\r\n"
									+ "    \"lat\": -38.383494,\r\n"
									+ "    \"lng\": 33.427362\r\n"
									+ "  },\r\n"
									+ "  \"accuracy\": 50,\r\n"
									+ "  \"name\": \"Testing Tester House\",\r\n"
									+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
									+ "  \"address\": \"230, side layout, cohen 09\",\r\n"
									+ "  \"types\": [\r\n"
									+ "    \"shoe park\",\r\n"
									+ "    \"shop\"\r\n"
									+ "  ],\r\n"
									+ "  \"website\": \"http://google.com\",\r\n"
									+ "  \"language\": \"French-IN\"\r\n"
									+ "}").
					when()
							.post("/maps/api/place/add/json").
					then()
								.assertThat()
								.statusCode(200)
								.body("scope", equalTo("APP"))
								.header("Server", "Apache/2.4.18 (Ubuntu)")
							.extract().asPrettyString();
		
		
		System.out.println("Response: "+response);
		
		// JSON Parsing
		JsonPath js = new JsonPath(response);
		String place_id = js.getString("place_id");
		System.out.println(place_id);
		
		
		
		
		
		
		
				
		
	}

}
