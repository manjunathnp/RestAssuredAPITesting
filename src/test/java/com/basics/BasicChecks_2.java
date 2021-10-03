package com.basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicChecks_2 
{	
	@Test(enabled=false)
	public void getRequest()
	{
		//1. Define the Base URI
		RestAssured.baseURI = "https://reqres.in";
		
		//2. Define HTTP Request
		RequestSpecification httpRequest =  RestAssured.given();
		
		//3. Execute the Request
		Response response = httpRequest.request(Method.GET, "/api/users/2");
		
		//4. Convert the Response object to String 
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response Body: "+responseBody);
	}
	
	
	@Test(enabled=false)
	public void getReq()
	{
		//1. Define the Base URI
		RestAssured.baseURI = "https://reqres.in";
		
		//2. Define HTTP Request
		RequestSpecification httpRequest=  RestAssured.given();
		
		//3. Execute the Request
		Response response = httpRequest.request(Method.GET, "/api/users/2");
		
		//4. Convert the response object to String
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);
		
	}
	
	@Test
	public void bddGetReq()
	{
		//1. Define the Base URI
		RestAssured.baseURI = "https://reqres.in";
		
		//2. Define the HTTP Request
		String response = given().
		
								when()
										.get("/api/users/2").
								then()
										.extract().asPrettyString();
		//3. Print Response
		System.out.println(response);
										
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
