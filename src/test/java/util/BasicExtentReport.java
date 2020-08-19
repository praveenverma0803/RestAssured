package util;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReport extends TestListenerAdapter 
{
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
   
    public void onStart(ITestContext testcontext) {
    	// initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/BasicExtentReport/testReport.html");

        
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setDocumentTitle("Extent API Report");
        htmlReporter.config().setReportName("API results");
        htmlReporter.config().setTheme(Theme.DARK);
        //htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Project Name", "Users Dashboard");;
         
    }
    
    public void onTestSuccess(ITestResult result) {
    		
    	test = extent.createTest(result.getName());
    	test.log(Status.PASS,"Testcase is" +  MarkupHelper.createLabel(result.getName() +" PASSED ", ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult result) {
		
    	test = extent.createTest(result.getName());
    	test.log(Status.FAIL,"Testcase is" +  MarkupHelper.createLabel(result.getName() +" FAILED ", ExtentColor.RED));
    	test.log(Status.FAIL,"Testcase is" +result.getThrowable());
    }

public void onTestSkip(ITestResult result) {
		
    	test = extent.createTest(result.getName());
    	test.log(Status.SKIP,"Testcase is" + MarkupHelper.createLabel(result.getName() +" SKIPPED ", ExtentColor.ORANGE));
    	test.log(Status.SKIP,"Testcase is" +result.getThrowable());
    }
    
    public void onFinish(ITestContext testcontext) {
    	//to write or update test information to reporter
        extent.flush();
        
    }
}
