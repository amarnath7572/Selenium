import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_getPrice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//find the discount price of strawberry
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		 
		List<WebElement> names = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> discountedPrice= names.stream().filter(i->i.getText().contains("Strawberry")).map(i->getDiscountPrice(i)).collect(Collectors.toList());
		System.out.println(discountedPrice);
	}
	
	
	public static String getDiscountPrice(WebElement i)
	{
		return i.findElement(By.xpath("following-sibling::td[2]")).getText();
	}
}
