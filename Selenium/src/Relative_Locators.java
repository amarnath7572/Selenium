import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Relative_Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameBox = driver.findElement(By.cssSelector("input[name='name']"));
		
		//get the label text above name edit box
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameBox)).getText());
		
		// select checkbox which is left to the label text "Check me out if you Love IceCreams!"
		WebElement checkBoxLabel = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxLabel)).click();
		
		//get the label text of the first radio button
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		
		//enter date in the field below Date of Birth label
		WebElement dateLabel = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(dateLabel)).click();
		
		
	}

}
