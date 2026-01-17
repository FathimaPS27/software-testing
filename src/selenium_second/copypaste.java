package selenium_second;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class copypaste {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("WebDriver.Chrome.Driver","C:\\\\Users\\\\Asus\\\\Desktop\\\\selenium webdriver\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		WebElement fullname=driver.findElement(By.id("userName"));
		fullname.sendKeys("Fathima P.S");
		WebElement email=driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));             // inputkeys donot need send click -> directly we can use send keys direc
		email.sendKeys("fathimaps0220@gmail.com");
		WebElement paddress=driver.findElement(By.id("currentAddress"));
		paddress.sendKeys("Padipurackal (H), Edakkunnam P.O, Kanjirappally");
		paddress.sendKeys(Keys.CONTROL+"a");                                                
		Thread.sleep(2000);
		paddress.sendKeys(Keys.CONTROL+"c");
		Thread.sleep(2000);

		WebElement caddress=driver.findElement(By.id("permanentAddress"));
		caddress.sendKeys(Keys.CONTROL+"V");
		Thread.sleep(2000);

		
		
		// TODO Auto-generated method stub

	}

}
