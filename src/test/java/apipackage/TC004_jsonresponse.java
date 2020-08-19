package apipackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC004_jsonresponse {
	@Test
	public void jsonresponse() {
		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users/";
		
//Request Object
		RequestSpecification  httpRequest = RestAssured.given();
		
//Response Object
		Response response = httpRequest.request(Method.GET,"2");
		
		String Responsebody = response.getBody().asString();
		System.out.println("Response Body:" +Responsebody);
		
		Assert.assertEquals(Responsebody.contains("janet.weaver@reqres.in"), true);
	}
}
