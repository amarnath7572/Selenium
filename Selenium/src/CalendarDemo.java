import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		
		driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).click();
		
		//select the month first
		List<WebElement> months = driver.findElements(By.xpath("//*[contains(@class,'month')]"));
		for (WebElement i : months)
		{
			String monthText = i.getText();
			if(monthText.equalsIgnoreCase("Jul"))
			{
				i.click();
				break;
			}
		}
		
		//implementing the same with while loop
		System.out.println(driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText());
		 
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("July"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}
		
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		List<WebElement> dates =driver.findElements(By.xpath("//*[@class='day']"));
		
		//loop to validate the date given
		for (WebElement i : dates)
		{
			String dateText = i.getText();
			if(dateText.equalsIgnoreCase("23"))
			{
				i.click();
				break;
			}
		}
		
	
		
	}

}
