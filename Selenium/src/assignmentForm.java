import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignmentForm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@name='name' and @xpath='1']")).click();
		driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input")).sendKeys("Amar");
		driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input")).sendKeys("aa@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password' ]")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@type='checkbox' ]")).click();
		
		//Select dropdown
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		Select dropdown = new Select(staticDropdown);
		//index starts from 0
		dropdown.selectByIndex(1);
		
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("06/06/2022");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText());
		//Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText(), "Success! The Form has been submitted successfully!.");
		
		
		
		
	}

}
