package selenium_second;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileupload {

	public static void main(String[] args)throws InterruptedException {

		System.setProperty("WebDriver.Chrome.Driver","C:\\\\Users\\\\Asus\\\\Desktop\\\\selenium webdriver\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/upload");
		WebElement choose=driver.findElement(By.id("file-upload"));
		choose.sendKeys("C:\\Users\\Asus\\OneDrive\\Pictures\\bg\\1.jpg");
		WebElement upload=driver.findElement(By.id("file-submit"));
		upload.click();
		

	}

}




