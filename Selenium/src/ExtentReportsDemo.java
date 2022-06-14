import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportsDemo {
	
	ExtentReports extent; // Create a global variable in order to access for all tests
	
	@BeforeTest
	public void ExtentReportsmain()
	{
		// create objects for these classes ExtentReports, ExtentSparkReporter
		// user.dir gives the current project directory wherever it is located
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html"; // create path of the reports 
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//attach the configured report to the main class
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		//update the name of the tester
		extent.setSystemInfo("QA", "Amar");
		
	}
	
		
	@Test
	public void Demo()
	{
		// creates a test object of type ExtentTest
		ExtentTest test = extent.createTest("ReportsDemo"); // this will monitor the test continuously
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com");
		
		extent.flush(); // will stop monitoring the test
		// test.addScreenCaptureFromBase64String(null);
	}


}
