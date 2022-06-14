import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// to get the number of links in the entire webpage
		System.out.println(driver.findElements(By.xpath("//a")).size());

		// links in the footer section
		WebElement miniDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(miniDriver.findElements(By.tagName("a")).size());

		// WebElement column1 = driver.findElement(By.xpath("//ul[@xpath='1']"));
		// links in a column
		WebElement column = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());

		// click on each link in column in a new tab and get the titles of the pages
		List<WebElement> linksList = column.findElements(By.tagName("a"));
		for (WebElement i : linksList) 
		{
			String clickNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			i.sendKeys(clickNewTab);

		}

		// click only links 1-4
		for (int i = 1; i < column.findElements(By.tagName("a")).size(); i++) 
		{
			String clickNewTab2 = Keys.chord(Keys.CONTROL, Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(clickNewTab2);
		}

		// Get the titles of each window and print in the output
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		Iterator<String> it = windows.iterator();
		String[] IDs = new String[windows.size()];
		for (int i = 0; i < windows.size(); i++) 
		{
			IDs[i] = it.next();
			driver.switchTo().window(IDs[i]);
			System.out.println(driver.getTitle());
			driver.switchTo().window(IDs[0]);

		}

		// Another way to get the titles - Rahul Shetty's
		Set<String> windows2 = driver.getWindowHandles();
		Iterator<String> it2 = windows2.iterator();
		while (it2.hasNext()) 
		{
			driver.switchTo().window(it2.next());
			System.out.println(driver.getTitle());
		}
	}

}
