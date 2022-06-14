import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		// All window ID strings are stored in the object windows now
		Set<String> windows = driver.getWindowHandles(); 
		//To get the IDs of the windows we need an iterator on the windows object
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID= it.next();
		//pass the child window ID to the driver
		driver.switchTo().window(childID);
		
		//paragrpah splitting and get emailID
		String paragraph = driver.findElement(By.xpath("//*[@class='im-para red']")).getText();
		String[] pieces = paragraph.split("at");
		String emailID = pieces[1].trim().split(" ")[0];
		
		//single line code
		String emailID2 = driver.findElement(By.xpath("//*[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentID);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailID);
		
	}

}
