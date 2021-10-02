package com.basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.infos.Payload;

public class Practice 
{
	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = 
							given()
									.log().all()
									.queryParam("key", "qaclick123")
									.header("Content-Type", "application/json")
									.body(Payload.addPlace()).
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
		String scope = js.getString("scope");
		
		System.out.println("Status: "+status);
		System.out.println("Place_ID: "+place_id);
		System.out.println("Scope: "+scope);
		System.out.println("******************************************************************************************");
		
		
		
		
	}

}
