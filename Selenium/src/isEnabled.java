import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class isEnabled {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style"));
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style"));
	
		//isEnabled is not working
		//Alternate way to verify the enabled state of the date picker
		//negative test step
		//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0' and @value='OneWay']")).click();
		if(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style").contains("1"))
		{
			System.out.println("Enabled state");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Disabled state");
			Assert.assertTrue(false);
		}
	}

}
