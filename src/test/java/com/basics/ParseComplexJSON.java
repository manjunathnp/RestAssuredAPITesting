package com.basics;

import com.infos.Payload;

import io.restassured.path.json.JsonPath;

public class ParseComplexJSON 
{

	public static void main(String[] args) 
	{
		JsonPath js = new JsonPath(Payload.coursePrice());
		
		//1. Print no. courses
		int courseCount = js.getInt("courses.size()");
		System.out.println("Total No. of Courses: "+courseCount);
		
		//2. Print Purchase Amount
		int purchaseAmt = js.getInt("dashboard.purchaseamount");
		System.out.println("Purchase Amount: "+purchaseAmt);
		
		//3. Print Title of the First Course
		String courseTitle_FirstCourse = js.get("courses[0].title");
		System.out.println("First Course Title: "+courseTitle_FirstCourse);
		
		//4. Print All course titles and their respective Prices
		System.out.println("\nCourse Titles:");
		for(int i=0; i<courseCount; i++)
		{
			System.out.println(js.get("courses["+i+"].title"));
			System.out.println("Price: "+js.getInt("courses["+i+"].price"));
			System.out.println("Copies: "+js.getInt("courses["+i+"].copies"));
			System.out.println();
		}
		
		//5. Print no of copies sold by RPA Course
		System.out.println("\nTotal Copies sold by RPA");
		for(int i=0; i<courseCount; i++)
		{
			String courseTitle = js.get("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("RPA"))
			{
				System.out.println("Copies Sold by "+courseTitle+": "+js.getInt("courses["+i+"].copies"));
			}
		}
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		int sumCoursePrice=0;
		for(int i=0; i<courseCount; i++)
		{
			int coursePrice = js.getInt("courses["+i+"].price");
			int totalCopies = js.getInt("courses["+i+"].copies");
			sumCoursePrice = sumCoursePrice + (coursePrice*totalCopies);
		}
		System.out.println("\nSum of Course Price: "+sumCoursePrice);
		System.out.println("Purchase Amount: "+purchaseAmt);
		
		if(sumCoursePrice == purchaseAmt)
			System.out.println("PRICE MATCH!");
		else
			System.out.println("PRICE MISMATCH");
	}

}
 