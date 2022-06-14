import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTables2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int rows = driver.findElements(By.cssSelector("[name='courses'] tr")).size();
		int columns = driver.findElements(By.cssSelector("[name='courses'] tr th")).size();
		
		System.out.println("no of rows - "+ rows);
		System.out.println("no of columns - "+ columns);
		
		List<WebElement> secondRow = driver.findElements(By.cssSelector("[name='courses'] tr:nth-child(3)"));
		for(WebElement i: secondRow)
		{
			System.out.println(i.getText());
		}
	}

}
