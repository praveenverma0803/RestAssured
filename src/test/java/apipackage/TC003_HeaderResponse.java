package apipackage;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.TestBase;

public class TC003_HeaderResponse extends TestBase{
	
	@SuppressWarnings("unused")
	@Test
	public void HeaderResponse() {
		
		logger.info("************TC003_HeaderResponse execution started*********");

		
		//specify base URI
				RestAssured.baseURI = "https://reqres.in/api/users";
				
		//Request Object
				RequestSpecification  httpRequest = RestAssured.given();
				
		//Response Object
				Response response = httpRequest.request(Method.GET,"/2");
				
				String Responsebody = response.getBody().asString();
				
		//Get all header from response
				Headers AllHeaders = response.headers();
				for(Header header : AllHeaders) 
				{
				System.out.println("Headers list: "+header.getName() +"   :   " +header.getValue());
				}
				
				logger.info("************TC003_HeaderResponse execution Complete successfully*********");

	}

}
