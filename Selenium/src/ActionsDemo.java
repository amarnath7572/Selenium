import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.in/");
		//Actions class object creation
		//Verify if the keyword is given as classname, dont give them
		Actions a = new Actions(driver);
		//hovers over the webelement
		a.moveToElement(driver.findElement(By.xpath("//a[contains(@id,'accountList')]"))).build().perform();
		
		//Entering in capital letters
		//click on the element, hold the shift and send keys
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("Toys").build().perform();
		//double click on the text that you are entering
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("Toys").doubleClick().build().perform();
		//right click
		a.moveToElement(driver.findElement(By.xpath("//a[contains(@id,'accountList')]"))).contextClick().build().perform();
		
	}

}
