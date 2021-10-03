package com.basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.infos.Payload;

public class UpdatePlace 
{
	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
							given()
									.log().all()
									.queryParam("key", "qaclick123")
									.header("Content-Type", "application/json")
									.body(Payload.updatePlace()).
							when()
									.put("/maps/api/place/update/json").
							then()
									.log().all()
									.assertThat().statusCode(200)
									.body("msg", equalTo("Address successfully updated"));

	}

}
