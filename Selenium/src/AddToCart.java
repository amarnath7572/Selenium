import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		String[] cartArray = {"Cucumber", "Brocolli", "Beetroot"};
		int ArrayLength= cartArray.length;
		//Convert Array to Arraylist
		List cartList = Arrays.asList(cartArray);
		int j=0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//get all the list of webelements
		List <WebElement> products = driver.findElements(By.xpath("//*[@class='product-name']"));
		// products will have names like Cucumber - 1Kg
		
		for (int i=0;i<products.size();i++)
		{
			//Split the product names and take the 0th index after trimming
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			//now compare the trimmed name with the items in Arraylist(cartList)
			
			if(cartList.contains(formattedName))
			{
				j++;
				//Click to add to cart
				//driver.findElements(By.xpath("//*[text()='ADD TO CART']")).get(i).click();
				//Add to cart text might change and if it changes, items would not be clicked correctly
				driver.findElements(By.xpath("//*[@class='product-action']/button")).get(i).click();
				// to avoid for looping for 30 times, restrict once you found the number of items present in Arraylist
				if (j==ArrayLength)
				{
					break;
				}
				
			}
				
				
		}
	}

}
