import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment_checkbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).isSelected());
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).isSelected());
		
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}

}
