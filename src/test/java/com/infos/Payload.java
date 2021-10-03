package com.infos;

import com.basics.AddPlace;

public class Payload extends AddPlace
{
	public static String addPlaceMethod()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Testing Tester House_2\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"230, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	
	public static String updatePlace()
	{
		return "{\r\n"
				+ "\"place_id\":\"c1af2417bffa7946dc813c89a3243323\",\r\n"
				+ "\"address\":\"75 Summer walks, India\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
	}
	
	public static String coursePrice()
	{
		return "{\r\n"
				+ "  \"dashboard\":{\r\n"
				+ "    \"purchaseamount\": 910,\r\n"
				+ "    \"website\": \"trainingweb.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\":[\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    \r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    \r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}\r\n"
				+ "";
	}

}
