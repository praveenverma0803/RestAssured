package apipackage;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.TestBase;

public class TC007_JsonFilePayload extends TestBase {

	@Test
	public void UserDetails() {
		logger.info("************TC007_JsonFilePayload execution started*********");

	//specify base URI
		RestAssured.baseURI = "https://reqres.in/api";
		
	//Request Object
		RequestSpecification  httpRequest = RestAssured.given();
				
	//Request pay load
		File file = new File("D:/UserDetails.json");
		httpRequest.body(file);
		
		httpRequest.contentType(ContentType.JSON);
		
		
	//Response Object
		Response response = httpRequest.request(Method.POST,"/users");
		
	//Print response	
		//String Responsebody = response.getBody().asString();
		//System.out.println("Response Body:" +Responsebody);
		
		JsonPath jsonbody = response.jsonPath();
		System.out.println("Created user Name: " +jsonbody.get("name"));
		System.out.println("Created user job: " +jsonbody.get("job"));
		System.out.println("Created user id: " +jsonbody.get("id"));
		System.out.println("User create time: " +jsonbody.get("createdAt"));
		
		
	//Validate response
		int statuscode = response.getStatusCode();
		System.out.println("Statsus code is: " +statuscode);
		Assert.assertEquals(statuscode, 201);
				
	//Verify contents in response body
		String userjob = response.jsonPath().get("job");
		Assert.assertEquals(userjob, "leader");
		System.out.println("Job of created user:" +userjob);	
		
		logger.info("************TC007_JsonFilePayload execution Completed successfully*********");

	}
}
