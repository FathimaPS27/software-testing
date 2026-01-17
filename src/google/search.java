package google;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class search {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("APjFqb")).click();
		driver.findElement(By.id("APjFqb")).sendKeys("Apple");
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).click();
		//driver.close();

	}

}
