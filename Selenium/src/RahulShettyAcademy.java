import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RahulShettyAcademy {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		driver.findElement(By.xpath("//*[contains(text(),'Forgot your password')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Reset Login')]")).click();
		String password = getPassword(driver);
		System.out.println(password);
		
		driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Amar");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'logged in')]")).getText(), "You are successfully logged in.");
		

	}

	public static String getPassword(WebDriver driver)
	{
		String passwordText=driver.findElement(By.xpath("//*[contains(text(),'rahulshettyacademy')]")).getText();
		//System.out.println(passwordText.split("'"));
		String[] passwordArray = passwordText.split("'");
		//0th index = Please use temporary password
		// 1st index = rahulshettyacademy' to Login.
		String[] passwordArray2 = passwordArray[1].split("'");
		//0th index = rahulshettyacademy
		//1st index =  to Login.
		return passwordArray2[0];
	}
	
}
