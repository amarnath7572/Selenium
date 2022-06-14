import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsJava {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String name = "Amar";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='enter-name']")).click();
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
//		Thread.sleep(1000);
		// Switching the context from browser to Alert and accept the alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		// Switching the context to alert and dismissing the alert box
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
//		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println("test");

	}

}
