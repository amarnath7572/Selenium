import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://jqueryui.com/droppable/");
		
		//get the number of iframes first
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//Frames 
		// switch to frame using webelement
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		//driver.switchTo().frame(0); // 0th index is where the first frame is
		
		driver.findElement(By.xpath("//div[@id='draggable']")).isDisplayed();
		
		//Drag and drop into a frame
		Actions a = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dest = driver.findElement(By.xpath("//div[@id='droppable']"));
		a.dragAndDrop(src, dest).build().perform();
		
		//to switch to the parent window from the frame
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//a[text()='Accept']")).getText());
		
	}

}
