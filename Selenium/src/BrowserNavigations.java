import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//test wont run in maximize mode
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

//driver.get() has inbuilt wait mechanism and webdriver waits until page completely loads.
//Driver.navigate().to() doesn’t wait for the page to load

		
		driver.navigate().back();
		driver.navigate().forward();

	}

}
