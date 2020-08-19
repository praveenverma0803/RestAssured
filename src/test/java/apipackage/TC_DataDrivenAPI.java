package apipackage;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.ExcelUtils;
import util.TestBase;

public class TC_DataDrivenAPI extends TestBase{
	
	RequestSpecification httpRequest;
	Response response;
	
	
	@BeforeClass
	public void UserDetails(){
		
		//specify base URI
				logger.info("Base URI declared");
				RestAssured.baseURI = "https://reqres.in/api";
				
		//Request Object
				logger.info("Request Object declared");
				httpRequest = RestAssured.given();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test (dataProvider = "exceluserdata" )
	public void TestData(String Name, String Title) {
		//Request pay load
				logger.info("Json request data added through excel");
				JSONObject requestparms = new JSONObject();
				requestparms.put("name", Name);
				requestparms.put("job", Title);
				
				httpRequest.header("Content-Type", "application/json");	
				logger.info("Payload defined as JSON type body");
				httpRequest.body(requestparms.toJSONString());
				
		//Response Object
				logger.info("Post request send as response stored in Response object");
				response = httpRequest.request(Method.POST,"/users");
				String Responsebody = response.getBody().asString();
		//Print response
				System.out.println("Response Body:" +Responsebody);
		
				logger.info("Validating the elements receied in response");
		//Verify contents in response body
				Assert.assertEquals(Responsebody.contains(Name), true);
				Assert.assertEquals(Responsebody.contains(Title), true);
			
				int statuscode = response.getStatusCode();
				System.out.println("Statsus code is: " +statuscode);
				Assert.assertEquals(statuscode, 201);		
}

	
	@DataProvider (name="exceluserdata")
	String[][] Exceluserdata() throws IOException
	{
		String path = System.getProperty("user.dir")+"/Resource/DataDrivenAPI.xlsx";
		int rowscount = ExcelUtils.getrowcount(path,"TestData");
		int columscount = ExcelUtils.getcellcount(path,"TestData", rowscount);
		
		String users[][] = new String[rowscount][columscount];
		
		 for(int i=1; i<=rowscount; i++)
		 {
			 for(int j=0;j<columscount;j++) {
				 users[i-1][j] = ExcelUtils.getCelldata(path, "TestData", i, j);
			 }
		 }
		return users;
	}
	
	
	@DataProvider (name="userdata")
	String[][] Getuserdata()
	{
		String users[][] = {{"ABC","Leader"},{"PQR","Co-Leader"},
				{"XYZ","SrMember"},{"TUV","Asociate"}};
		return users;
	}
}

//