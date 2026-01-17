package selenium_second;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class dropdown {

	
	// 18-09-2025    To select frim dropdown list
	                 
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.Chrome.Driver","C:\\\\Users\\\\Asus\\\\Desktop\\\\selenium webdriver\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		WebElement username=driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		
		WebElement list=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
		Thread.sleep(2000);
		Select obj=new Select(list);
		
		
// diffrent seleection methods
		
		//obj.selectByIndex(2);
		//obj.selectByValue("za");
		obj.selectByVisibleText("Price (high to low)");
		
		
// for forward and backward page
		driver.navigate().back();
		driver.navigate().forward();
		
	}

}
