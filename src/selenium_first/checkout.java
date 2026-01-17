package selenium_first;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class checkout {

	public static void main(String[] args)throws InterruptedException {
		System.setProperty("webdriver.chorme.driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/inventory.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")).click();
		WebElement name=driver.findElement(By.id("first-name"));
		name.click();
		name.sendKeys("Fathima");
		WebElement lastname=driver.findElement(By.id("last-name"));
		lastname.click();
		lastname.sendKeys("p.s");
		WebElement pincode=driver.findElement(By.id("postal-code"));
		pincode.sendKeys("686512");
		driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();
        driver.close();

	}

}
