import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenURLs {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		System.setProperty("javax.net.ssl.trustStore", "C:/.keystore");
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//for a single URL
		
		String url = driver.findElement(By.cssSelector("[href*='soapui']")).getAttribute("href");
		System.out.println(url);
		
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		
		conn.connect();
		int code = conn.getResponseCode();
		System.out.println(code); 
		
		
		//for all URLs
		List<WebElement> links = driver.findElements(By.cssSelector("[class*='footer_style'] tr a"));
		
		//get URLs from the links using Selenium
		//use Java to verify the URLs
		//if status code is >400, URL is not working or link is broken
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement i: links)
		{
			String url2 = i.getAttribute("href");
			
			HttpURLConnection conn2 = (HttpURLConnection) new URL(url2).openConnection();
			conn2.setRequestMethod("HEAD");
			
			conn2.connect();
			int code2 = conn2.getResponseCode();
			System.out.println(i.getText()+ ":" + code2);
			if(code2>400)
			{
				System.out.println("The link "+ i.getText()+ " is broken");
				//Assert.assertTrue(false); if you use assert, execution will stop in the middle
			}
			
			//if block can be replaced with the below statement
			a.assertTrue(code2<400, "The link " + url2+ " is broken");
		} 
		
		a.assertAll();
	}

}
