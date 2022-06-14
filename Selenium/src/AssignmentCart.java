import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Enter form details
		driver.findElement(By.xpath("//input[@name='name' and contains(@class,'form-control')]")).sendKeys("Amar");
		driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input")).sendKeys("aa@aa.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Amarkav123");
		
		WebElement staticdrpdwn = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		Select dropdown = new Select(staticdrpdwn);
		dropdown.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("08/24/1990");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		System.out.println(driver.findElement(By.xpath("//*[contains(@class,'alert-success')]")).getText());
		
		//Navigate to Shop
		driver.findElement(By.xpath("//a[@class='nav-link' and text()='Shop']")).click();
		
		//get list of Add cart buttons
		List <WebElement> products = driver.findElements(By.xpath("//button[contains(@class,'btn-info')]"));
		//click all cart buttons and checkout
		for (WebElement product: products)
		{
			product.click();
		}
		
		driver.findElement(By.xpath("//a[contains(@class,'btn-primary')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn-success')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Purchase']")).getTagName(), "input");
	}

}
