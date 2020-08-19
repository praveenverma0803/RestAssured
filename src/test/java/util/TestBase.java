package util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import apipackage.TC_DataDrivenAPI;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	
	public Logger logger;
	
	@BeforeClass
		public void logrecord() {

		logger = Logger.getLogger(TC_DataDrivenAPI.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.ALL);	
	}
	

}
