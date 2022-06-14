import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentDynamic {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//*[@id='checkBoxOption2']")).click();
		
		//get The text of the checkbox selected
		String selectedText = driver.findElement(By.xpath("//*[@id='checkBoxOption2']/parent::label")).getText();
		System.out.println(selectedText);
		
		//select the dropdown based on the text
		WebElement staticdrpdwn = driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
		Select dropdown = new Select(staticdrpdwn);
		dropdown.selectByVisibleText(selectedText);
		
		//Enter the text in the edit box
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(selectedText);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		//verify the text in the java alert box
		System.out.println(driver.switchTo().alert().getText());
		String actualText = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		Assert.assertEquals(actualText, selectedText);
		
		//another way to verify the text
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText.contains(selectedText));
	}

}
