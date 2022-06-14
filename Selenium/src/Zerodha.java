import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zerodha {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://coin.zerodha.com/dashboard");
		driver.findElement(By.id("userid")).sendKeys("XS7929");
		driver.findElement(By.id("password")).sendKeys("Amarkav123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.id("pin")).sendKeys("757243");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Read more here')]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Read more here')]")).getText(), "Read more here.");
		
		driver.findElement(By.xpath("//*[text()='AG']")).click();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
	}

}
