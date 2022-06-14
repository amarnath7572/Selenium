import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(@id,'friendsandfamily')]")).click();
		//System.out.println(driver.findElement(By.xpath("//*[contains(@id,'friendsandfamily')]")).isSelected());
		
		//Using assertions to validate the result
		//If assertion fails, test wont be executed after
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@id,'friendsandfamily')]")).isSelected());
		
		//Get the number of checkboxes on the page
		System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());
		//List <WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
	}

}
