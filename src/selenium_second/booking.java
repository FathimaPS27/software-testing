package selenium_second;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class booking {

	public static void main(String[] args) throws InterruptedException, IOException{
		
		System.setProperty("webdriver.chorme.driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.musafir.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[1]/ul[1]/li[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[1]/ul[2]/li[2]/label")).click();
		WebElement from=driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[3]/input"));
		from.sendKeys("Kochi, India (COK)");
		WebElement to=driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[4]/input"));
		to.sendKeys("Delhi, India (DEL)");
		WebElement calender=driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[10]/input"));
		calender.sendKeys("30/09/25");
		calender.sendKeys(Keys.TAB);
		
	
		WebElement adult = driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[12]/div[1]/select"));
		Select obj = new Select(adult);
		obj.selectByIndex(2);  

		
		WebElement infant = driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[12]/div[2]/select"));
		Select obj2 = new Select(infant);
		obj2.selectByValue("3");  

		
		WebElement child = driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[12]/div[3]/select"));
		Select obj3 = new Select(child);
		obj3.selectByVisibleText("2 infants");
		
		driver.findElement(By.xpath("//*[@id=\"build\"]/fieldset[14]/a[2]")).click();
		
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[@id=\"flightScreenRight\"]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[4]/button")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"flightScreenRight\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);

		File filez=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(filez,new File("C:\\image\\muzafir_booking.png"));
		System.out.println("Screenshot saved successfully");
		}

		

	}


