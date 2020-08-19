package apipackage;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_ExtractValues {

	@Test
	public void jsonresponse() {
		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users/";
		
//Request Object
		RequestSpecification  httpRequest = RestAssured.given();
		
//Response Object
		Response response = httpRequest.request(Method.GET,"2");
		
		JsonPath jsonbody = response.jsonPath();
		
		System.out.println(jsonbody.get("data.id"));
		System.out.println(jsonbody.get("data.email"));
		System.out.println(jsonbody.get("data.first_name"));
		System.out.println(jsonbody.get("data.last_name"));
}
	
}

/*{"data":{"id":2,"email":"janet.weaver@reqres.in",
"first_name":"Janet","last_name":"Weaver",
"avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"},
"ad":{"company":"StatusCode Weekly","url":"http://statuscode.org/",
	"text":"A weekly newsletter focusing on software development, infrastructure,"
			+ " the server, performance, and the stack end of things."}} */
