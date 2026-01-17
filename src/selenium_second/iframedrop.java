package selenium_second;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class iframedrop {

	public static void main(String[] args) {
		System.setProperty("WebDriver.Chrome.Driver","C:\\\\Users\\\\Asus\\\\Desktop\\\\selenium webdriver\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dst=driver.findElement(By.id("droppable"));
		act.dragAndDrop(src,dst).build().perform();
		
	}}