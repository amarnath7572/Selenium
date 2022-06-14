import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_getPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//scan the name column with getText, if its Potato, print the price
		
		//get all the list of webelements with veggies
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		//Apply stream and filter based on the text, pass the webelement to a method to get the price and convert the result to a list to access that value
		List<String> price= veggies.stream().filter(i->i.getText().contains("Potato")).map(i->getPrice(i)).collect(Collectors.toList());
		System.out.println(price);
	}
	
	private static String getPrice(WebElement i)
	{
		
		String value = i.findElement(By.xpath("following-sibling::td[1]")).getText();
		return value;
		
	}

}
