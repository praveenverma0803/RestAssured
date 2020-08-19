package apipackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_Authorization {

	@Test
	public void Authorization() {
//specify base URI
		RestAssured.baseURI = "https://internalrscs.scatech.org/plugins/contracts/rest/v1/contracts/send-expired-notifications?";
		
//Authorization
		//PreemptiveOAuth2HeaderScheme authschema = new PreemptiveOAuth2HeaderScheme();
		//authschema.setAccessToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzY2F0ZWNoLmNvbSIsImlhdCI6MTU5Nzc1MTk3MiwiZXhwIjoxNTk3ODM4MzcyLCJqdGkiOiI2YmEyYzJmZS1iYzM2LTRiZTQtOGMyYi1kNWIwZDU0NTFlNzgiLCJzdWIiOiJzY2FwbGFubmVyIn0.-gb-CxM5wqnhxLMktsLqDhzNgWInVNZNRL-vEQqp6Ygaf259CDQxBlDEIayt98ib4SrbOuRE0UpRhTNXiSEAzw");
				
		//RestAssured.authentication = authschema;
		
//Request Object
		RequestSpecification  httpRequest = RestAssured.given();	
		httpRequest.queryParam("today=11%2F06%2F2021");	
		httpRequest.auth().oauth2("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzY2F0ZWNoLmNvbSIsImlhdCI6MTU5Nzc1MTk3MiwiZXhwIjoxNTk3ODM4MzcyLCJqdGkiOiI2YmEyYzJmZS1iYzM2LTRiZTQtOGMyYi1kNWIwZDU0NTFlNzgiLCJzdWIiOiJzY2FwbGFubmVyIn0.-gb-CxM5wqnhxLMktsLqDhzNgWInVNZNRL-vEQqp6Ygaf259CDQxBlDEIayt98ib4SrbOuRE0UpRhTNXiSEAzw");
				
//Response Object
		Response response = httpRequest.request(Method.GET,"");
		
		String Responsebody = response.getBody().asString();
		System.out.println("Response Body:" +Responsebody);
		
//Validate response
		int statuscode = response.getStatusCode();
		System.out.println("Statsus code is: " +statuscode);
		Assert.assertEquals(statuscode, 200);


}
	
}

/*
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzY2F0ZWNoLmNvbSIsImlhdCI6MTU5Nzc1MTk3MiwiZXhwIjoxNTk3ODM4MzcyLCJqdGkiOiI2YmEyYzJmZS1iYzM2LTRiZTQtOGMyYi1kNWIwZDU0NTFlNzgiLCJzdWIiOiJzY2FwbGFubmVyIn0.-gb-CxM5wqnhxLMktsLqDhzNgWInVNZNRL-vEQqp6Ygaf259CDQxBlDEIayt98ib4SrbOuRE0UpRhTNXiSEAzw
  */
