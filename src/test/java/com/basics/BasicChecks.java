package com.basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.infos.Payload;
import com.infos.Utils;

public class BasicChecks 
{
	public static void main(String[] args) 
	{
		/* given() => all input details
		 * when() => specify resource, HTTP Method details
		 * then() => validate the response 
		 */
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		// 1. Add Place
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
		
		
		System.out.println("Response: "+response);
		
		// JSON Parsing
		JsonPath js = Utils.rawToJson(response);
		String  place_id = js.getString("place_id");
		System.out.println(place_id);
		
		//2. Update Place
		String newAddress = "101 Rain Park, UK";
					given()
							.log().all()
							.queryParam("key", "qaclick123")
							.header("Content-Type", "application/json")
							.body("{\r\n"
									+ "\"place_id\":\""+place_id+"\",\r\n"
									+ "\"address\":\""+newAddress+"\",\r\n"
									+ "\"key\":\"qaclick123\"\r\n"
									+ "}").
					when()
							.put("/maps/api/place/update/json").
					then()
							.log().all()
							.assertThat().statusCode(200)
							.body("msg", equalTo("Address successfully updated"));
		
		//3. GET Place
		String getPlaceResponse =	
						given()
											
							.log().all()
							.queryParam("key", "qaclick123")
							.queryParam("place_id", place_id).
							
					when()
							.get("/maps/api/place/get/json").
					
					then()
							.assertThat().log().all()
							.statusCode(200)
							.extract().response().asPrettyString();
		
		JsonPath js2 = Utils.rawToJson(getPlaceResponse);
		
		String actualAddress = js2.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);

		
		
		
		
		
				
		
	}

}
