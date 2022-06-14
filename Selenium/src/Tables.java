import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement> tdValues = driver.findElements(By.cssSelector("[class='tableFixHead'] td:nth-child(4)"));
		int sum=0;
		
		//using for each loop
		for(WebElement i: tdValues)
		{
			sum=sum + Integer.parseInt(i.getText());
		}
		System.out.println(sum); 
		
		//another way to loop
		for (int i=0;i<tdValues.size();i++)
		{
			sum=sum+ Integer.parseInt(tdValues.get(i).getText());
		}
		System.out.println("Summed value: "+sum);
		
		//compare the sum amount with the text available on the UI
		
		int uiValue = Integer.parseInt(driver.findElement(By.cssSelector("[class='totalAmount']")).getText().split(":")[1].trim());
		
		System.out.println("UI Text value: "+uiValue);
		
		Assert.assertEquals(sum, uiValue);
	}

}
