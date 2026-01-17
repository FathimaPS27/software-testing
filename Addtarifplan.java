package datadriven_telecom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Addtarifplan {
	 
	WebDriver driver;
	
	@BeforeSuite
	public void openbrowser() {

		System.setProperty("WebDriver.Chrome.Driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/telecom/index.html");
	    System.out.println("Browser launched");
	}

	
	@Test
	public void addtarifplan() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[3]/div[1]/h3/a")).click();
		WebElement monthlyrent=driver.findElement(By.id("rental1"));
		monthlyrent.sendKeys("2000");
	
		
		WebElement FreeLocalMinutes=driver.findElement(By.id("local_minutes"));
		FreeLocalMinutes.sendKeys("50");
		
		WebElement FreeInternationalMinutes=driver.findElement(By.id("inter_minutes"));
		FreeInternationalMinutes.sendKeys("10");
		
		WebElement FreeSMSPack=driver.findElement(By.id("sms_pack"));
		FreeSMSPack.sendKeys("100");
		
		WebElement LocalPerMinutesCharges=driver.findElement(By.id("minutes_charges"));
		LocalPerMinutesCharges.sendKeys("1");
		
		WebElement InterPerMinutesCharges=driver.findElement(By.id("inter_charges"));
		InterPerMinutesCharges.sendKeys("3");
	
		WebElement SMSPerCharges=driver.findElement(By.id("sms_charges"));
		SMSPerCharges.sendKeys("1");
		
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[36]/ul/li[1]/input")).click();
		
		File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1,new File("C:\\image\\scrnsht1.png"));
		System.out.println("Screenshot saved successfully");
	    Thread.sleep(2000);
	}
	

	 @AfterSuite
		 public void closebrowser() {
			 driver.quit();
			 System.out.println("Browser closed successfully");
	 	}
	}






