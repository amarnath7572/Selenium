import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTable_Sort_JS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("[aria-label*='Veg']")).click();
		
		// Algorithm to solve this
		// Capture all column values into a list
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		// getText for each webelement into a new List (original)
		// use streams
		 List<String> newOrignialList = veggies.stream().map(i->i.getText()).collect(Collectors.toList());
		 System.out.println(newOrignialList);
		
		// apply sort on the original list (sorted)
		List<String> newSortedList = newOrignialList.stream().sorted().collect(Collectors.toList());
		System.out.println(newSortedList);
		
		// compare original and sorted list
		Assert.assertTrue(newOrignialList.equals(newSortedList));
		
	}

}
