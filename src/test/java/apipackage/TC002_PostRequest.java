package apipackage;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.TestBase;

public class TC002_PostRequest extends TestBase {

	@SuppressWarnings("unchecked")
	@Test
	public void UserDetails() {
		logger.info("************TC002_PostRequest execution started*********");
	
//specify base URI
		RestAssured.baseURI = "https://reqres.in/api";
		
//Request Object
		RequestSpecification  httpRequest = RestAssured.given();
				
//Request pay load
		JSONObject requestparms = new JSONObject();
		requestparms.put("name", "morpheus");
		requestparms.put("job", "leader");
		
		httpRequest.header("Content-Type", "application/json");		
		httpRequest.body(requestparms.toJSONString());
		
//Response Object
		Response response = httpRequest.request(Method.POST,"/users");
		String Responsebody = response.getBody().asString();
//Print response
		System.out.println("Response Body:" +Responsebody);
		
//Validate response
		int statuscode = response.getStatusCode();
		System.out.println("Statsus code is: " +statuscode);
		Assert.assertEquals(statuscode, 201);
				
//Verify contents in response body
		String userjob = response.jsonPath().get("job");
		Assert.assertEquals(userjob, "leader");
		System.out.println("Job of created user:" +userjob);	
		
		logger.info("************TC002_PostRequest execution completed successfully*********");

	}
}
