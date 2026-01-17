package selenium_first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginelement {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chorme.driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement user=driver.findElement(By.id("user-name"));
		user.click();
		user.sendKeys("standard_user");
		WebElement password=driver.findElement(By.id("password"));
		password.click();
		password.sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		//Thread.sleep(2000);

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		//Thread.sleep(2000);

		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(2000);

		//driver.close();
		

	}

}
