import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentAutoDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("[id='autocomplete']")).sendKeys("Ind");
		Thread.sleep(2000);
		
		// using list of elements
		List<WebElement> values = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		for (WebElement i: values)
		{
			if(i.getText().equalsIgnoreCase("India"))
			{
				i.click();
				break;
			}
		} 
		
		
		//using keyboard actions
		driver.findElement(By.cssSelector("[id='autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector("[id='autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector("[id='autocomplete']")).click();
		System.out.println(driver.findElement(By.cssSelector("[id='autocomplete']")).getAttribute("value"));
		
		
		
	}

}
