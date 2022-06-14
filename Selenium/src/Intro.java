import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Intro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Invoking browser
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com");
		
		//Firefox driver
		//gecko driver
		
		//System.setProperty("webdriver.gecko.driver", "path");
		//WebDriver driver2 = new FirefoxDriver();
		
		//Edge Driver
		
		//System.setProperty("webdriver.edge.driver", "path");
		//WebDriver driver3 = new EdgeDriver();
		
		System.out.println(driver.getTitle());
		//get title of the window tab
		System.out.println(driver.getCurrentUrl());
		
		
		 driver.findElement(By.id("email")).sendKeys("amarnath538@gmail.com");
		 driver.findElement(By.id("pass")).sendKeys("Amarkav123");
		 driver.findElement(By.name("login")).click();
		
		
		
		//closes the chrome window
		driver.quit();
		
//		driver.findElement(By.xpath("//*[@id='pass']")).clear();
		//Clears the value in the text box
	}

}
