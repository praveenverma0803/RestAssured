package apipackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.TestBase;

public class TC001_GetRequest extends TestBase{

	@Test
	public void UserDetails() {
	
		logger.info("************TC001_GetRequest execution started*********");

		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		//Request Object
		RequestSpecification  httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/2");
		
		String Responsebody = response.getBody().asString();
		//Print response
		System.out.println("Response Body:" +Responsebody);
		
		//Validate response
		int statuscode = response.getStatusCode();
		System.out.println("Statsus code is: " +statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//Verify status line
		String statusline= response.getStatusLine();
		System.out.println("statusline is: "+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		//Verify response header
		String headers = response.header("Content-Type");
		System.out.println(headers);
		Assert.assertEquals(headers, "application/json; charset=utf-8");
				
		logger.info("************TC001_GetRequest execution completed successfully*********");
	
	}
}
