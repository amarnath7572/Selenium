import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		
		//Select India in country
		//Autosuggestive Dropdowns
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("India");
		Thread.sleep(1000);
		List<WebElement> options =  driver.findElements(By.xpath("//*[@class='ui-menu-item']/a"));
		//Remember that it is driver.findElements plural and xpath should give all list of options exactly into the List
		//List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
			}
		}
		
		//Select cities
		//Dynamic dropdowns
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
		
		//Select date
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();
		
		//Verify if date2 is in disabled state
		
		if(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style").contains("1"))
		{
			System.out.println("Enabled state");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Disabled state");
			Assert.assertFalse(false);
		}
		
		//Select 3 Adults
		//Dropdown
		
		driver.findElement(By.xpath("//*[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
		for (int i=1;i<5;i++)
		{
			driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
		}
			
		driver.findElement(By.xpath("//*[@id='btnclosepaxoption']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());
		
		//Select from static dropdown
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		
		//Select the 1st checkbox
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		//click submit
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
	}

}
