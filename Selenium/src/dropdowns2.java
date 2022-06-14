import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dropdowns2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//test wont run in maximize mode
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
//		int i =1;
//		while(i<5)
//		{
//			driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
//			i++;
//		}
		System.out.println(driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());
		for (int i=1;i<5;i++)
		{
			driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
		}
			
		driver.findElement(By.xpath("//*[@id='btnclosepaxoption']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText(), "5 Adult");
	}

}
