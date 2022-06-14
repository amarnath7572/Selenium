import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// click to sort
		driver.findElement(By.cssSelector("[aria-label*='Veg']")).click();
		List<String> price;
		do
		{
		List<WebElement> names = driver.findElements(By.xpath("//tr/td[1]"));
		price = names.stream().filter(i->i.getText().contains("Wheat")).map(i->getPrice(i)).collect(Collectors.toList());
		
		//System.out.println(price); // prints null values for every loop
		price.forEach(i->System.out.println(i));
		
		if(price.size()<1)
		{
			driver.findElement(By.xpath("//*[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}
	
	private static String getPrice(WebElement i)
	{
		return i.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
