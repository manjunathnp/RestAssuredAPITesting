package com.basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.infos.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlace
{
	@Test
	public String addPlace()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = 
							given()
									.log().all()
									.queryParam("key", "qaclick123")
									.header("Content-Type", "application/json")
									.body(Payload.addPlaceMethod()).
							when()
									.post("/maps/api/place/add/json").
							then()
									.assertThat()
										.statusCode(200)
										.body("scope", equalTo("APP"))
										.header("Server", "Apache/2.4.18 (Ubuntu)")
									.extract().asPrettyString();
		System.out.println("*****************************************Response*****************************************");
		System.out.println(response);
		System.out.println("******************************************************************************************");
		
		// JSON Parsing
		JsonPath js = new JsonPath(response);
		String status = js.getString("status");
		String place_id = js.getString("place_id");
		
		System.out.println(place_id);
		System.out.println(status);
		
		return response;
	
	}

}
