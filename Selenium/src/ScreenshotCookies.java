import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


public class ScreenshotCookies {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//delete cookies
		driver.manage().deleteAllCookies();
//		driver.manage().deleteCookieNamed("sessionKey");
		
		driver.get("https://www.google.co.in/");
		
//		Cast the driver to TakesScreenshot
//		Use the method getScreenshotAs(OutputType.FILE) on the casted driver
//		Return type is a file

		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Amar_2022\\Automation_Basics\\Selenium_course\\images\\screenshot.png"));
		
	}

}
