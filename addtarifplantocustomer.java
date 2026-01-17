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

public class addtarifplantocustomer {


	WebDriver driver;
	String textToCopy;
   
@BeforeSuite
 public void openbrowser() throws IOException {
		System.setProperty("WebDriver.Chrome.Driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/telecom/index.html");
	
		
		
		
		
 }

@Test(priority = 1)

	public void addcustomerdetails() throws InterruptedException {
		
			    driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")).click();

		        WebElement radiobtn = driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[2]/label"));
		        radiobtn.click();
			


		WebElement firstnm=driver.findElement(By.id("fname"));
		firstnm.sendKeys("Arundhadi");
	    WebElement lname=driver.findElement(By.id("lname"));
	    lname.sendKeys("R V");
		
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("arund@gmail.co");
		
		WebElement address=driver.findElement(By.name("addr"));
		address.sendKeys("Ramapuram Kottayam");
	   

		WebElement phnumber=driver.findElement(By.name("telephoneno"));
		phnumber.sendKeys("9766789066");
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[9]/ul/li[1]/input")).click();
		
		WebElement source = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]/h3"));
		textToCopy = source.getText(); 
		Thread.sleep(2000);
		}
	

@Test(priority = 2)

	public void addtarifplanToCustomer() throws IOException, InterruptedException {
		

		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/ul/li/a")).click();
		driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[1]/div[2]/h3/a")).click();
		
		WebElement target = driver.findElement(By.xpath("//*[@id=\"customer_id\"]"));
		target.sendKeys(textToCopy);

		
//		WebElement enterid=driver.findElement(By.id("customer_id"));
//		enterid.sendKeys(Keys.CONTROL+"v");
		
		
//		driver.findElement(By.name("submit")).click();
//		
//	    JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("scrollBy(0,250)"); 
//		Thread.sleep(2000);
		
	    
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='sele']")));
//		label.click();


		driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[6]/input")).click();
		WebElement add =driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div[2]/input"));
		add.click();
		//driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div[2]/input")).click();
		
		File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1,new File("C:\\image\\addcustomerdd.png"));
		System.out.println("Screenshot saved successfully");
		
		
		
	}

@AfterSuite
public void closebrowser() throws IOException {
	
	 driver.quit();
	 System.out.println("Browser closed successfully");
	//driver.close();
		}
	}

