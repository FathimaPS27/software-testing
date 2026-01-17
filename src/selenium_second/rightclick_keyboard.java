package selenium_second;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class rightclick_keyboard {

	public static void main(String[] args) {
		System.setProperty("WebDriver.Chrome.Driver","C:\\\\Users\\\\Asus\\\\Desktop\\\\selenium webdriver\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		// right ckick
		WebElement electronics=driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a"));
		act.contextClick(electronics).build().perform();
		
		
		
		//Keyboard action without capslock
		WebElement searchBoxElement=driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
		act.moveToElement(searchBoxElement).click().keyDown(Keys.SHIFT).sendKeys("computers").build().perform();
	}}