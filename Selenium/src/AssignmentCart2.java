import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentCart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		// Enter form data

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("learning");

		// Select dropdown value consultant
		WebElement staticdrpdwn = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticdrpdwn);
		dropdown.selectByVisibleText("Consultant");

		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//*[@name='signin']")).click();

		// cart

		// get list of Add cart buttons
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='list-group-item' and text()='Category 1']")));
		List<WebElement> products = driver.findElements(By.xpath("//button[contains(@class,'btn-info')]"));
		// click all cart buttons and checkout
		for (WebElement product : products) 
		{
			product.click();
		}

		driver.findElement(By.xpath("//a[contains(@class,'btn-primary')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn-success')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Purchase']")).getTagName(), "input");

	}

}
