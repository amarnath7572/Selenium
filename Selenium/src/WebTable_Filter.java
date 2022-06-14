import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTable_Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("[id='search-field']")).sendKeys("Rice");
		
		List<WebElement> names = driver.findElements(By.xpath("//tr/td[1]"));
		
		//using for loop
		
		for(WebElement i : names)
		{
			if(i.getText().contains("Rice"))
			{
				System.out.println("Veggie found");
				break;
			}
			else
			{
				System.out.println("Veggie not found");
			}
			
		}
		
		//using Java streams
		
		List<WebElement> filteredList = names.stream().filter(i->i.getText().contains("Rice")).collect(Collectors.toList());
		//sizes of the Lists should match
		Assert.assertEquals(names.size(), filteredList.size());
	}

}
