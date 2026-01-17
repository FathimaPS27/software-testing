package datadriven_telecom;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class paybilling_dd {

	 WebDriver driver;
	 String textToCopy;



 @BeforeClass
 public void openbrowser() throws IOException {
System.setProperty("WebDriver.Chrome.Driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");

driver=new ChromeDriver();

driver.get("https://demo.guru99.com/telecom/index.html");
driver.manage().window().maximize();

	
 }

	@Test (priority = 1)
	public void copyuserid()throws Exception{
	driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")).click();
	WebElement radiobtn=driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[2]/label"));
	radiobtn.click();
	System.out.println(radiobtn.isSelected());


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
public void paybill() throws IOException, InterruptedException {

driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/ul/li/a")).click();
driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[3]/div[2]/h3/a")).click();

WebElement target = driver.findElement(By.xpath("//*[@id=\"customer_id\"]"));
target.sendKeys(textToCopy);



driver.findElement(By.name("submit")).click();
Thread.sleep(2000);


	String loc="C:\\image\\paybilling";
	File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   //this is for take screenshot//
    FileUtils.copyFile(file1,new File(loc+"top_jpg.jpg"));  //this is for save the screenshot in defined location ( loc )// 
    Thread.sleep(3000);
   
    JavascriptExecutor js= (JavascriptExecutor)driver;
    js.executeScript("scrollBy(0,250)");   
    Thread.sleep(5000);
    File file2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file2, new File(loc+"second_jpg.jpg"));
    

}


@AfterSuite
public void closebrowser()  {
	
	 driver.quit();
	 System.out.println("Browser closed successfully");
	
	}
}
