package apipackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.TestBase;

public class TC006_Authorization extends TestBase {

	@Test
	public void Authorization()  {
		logger.info("************TC006_Authorization execution started*********");

//specify base URI
		RestAssured.baseURI = "https://internalrscs.scatech.org/plugins/contracts/rest/v1/contracts/send-expired-notifications?";
		
//Authorization
		//PreemptiveOAuth2HeaderScheme authschema = new PreemptiveOAuth2HeaderScheme();
		//authschema.setAccessToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzY2F0ZWNoLmNvbSIsImlhdCI6MTU5Nzc1MTk3MiwiZXhwIjoxNTk3ODM4MzcyLCJqdGkiOiI2YmEyYzJmZS1iYzM2LTRiZTQtOGMyYi1kNWIwZDU0NTFlNzgiLCJzdWIiOiJzY2FwbGFubmVyIn0.-gb-CxM5wqnhxLMktsLqDhzNgWInVNZNRL-vEQqp6Ygaf259CDQxBlDEIayt98ib4SrbOuRE0UpRhTNXiSEAzw");
				
		//RestAssured.authentication = authschema;
		String Key = 
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzY2F0ZWNoLmNvbSIsImlhdCI6MTU5Nzg2MjU1OSwiZXhwIjoxNTk3OTQ4OTU5LCJqdGkiOiIxY2UyMmNlNC1iMDU1LTRhNGItYWE3NS1iZWJmMDM0YzU4NzgiLCJzdWIiOiJzY2FwbGFubmVyIn0.4kvf597TXo_RONG2WHnrsAqEbb5J44sLFmpS-Y_KsxCE2_iINvlIR2qih1_LsIixCcMuYUyluBsAnjsIN96xJg";
		
		//Request Object
		RequestSpecification  httpRequest = RestAssured.given();	
		httpRequest.queryParam("today=11%2F06%2F2021");	
		httpRequest.auth().oauth2(Key);
				
//Response Object
		Response response = httpRequest.request(Method.GET,"");
		
		String Responsebody = response.getBody().asString();
		System.out.println("Response Body:" +Responsebody);
		
//Validate response
		int statuscode = response.getStatusCode();
		System.out.println("Statsus code is: " +statuscode);
		Assert.assertEquals(statuscode, 200);

		logger.info("************TC006_Authorization execution Completed successfully*********");


}
	
}

/*
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzY2F0ZWNoLmNvbSIsImlhdCI6MTU5Nzc1MTk3MiwiZXhwIjoxNTk3ODM4MzcyLCJqdGkiOiI2YmEyYzJmZS1iYzM2LTRiZTQtOGMyYi1kNWIwZDU0NTFlNzgiLCJzdWIiOiJzY2FwbGFubmVyIn0.-gb-CxM5wqnhxLMktsLqDhzNgWInVNZNRL-vEQqp6Ygaf259CDQxBlDEIayt98ib4SrbOuRE0UpRhTNXiSEAzw
  */
