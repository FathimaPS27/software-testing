package selenium_second;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class alert {

	
	// 18-09-25   To Handle alerts
	
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.Chrome.Driver","C:\\\\Users\\\\Asus\\\\Desktop\\\\selenium webdriver\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url="https://demoqa.com/alerts";
		driver.get(url);
		WebElement alert=driver.findElement(By.id("alertButton"));
		alert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		WebElement click2=driver.findElement(By.id("confirmButton"));
		click2.click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		WebElement click3=driver.findElement(By.id("promtButton"));
		click3.click();
		driver.switchTo().alert().sendKeys("Fathima");
		driver.switchTo().alert().accept();
		
		
		
	}

}
