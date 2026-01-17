package allinone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Guru99_test {

	  WebDriver driver;   
	    XSSFSheet sh;   
		String textToCopy;

	@BeforeSuite
	 public void launchbrowser() throws IOException, InterruptedException {
		System.setProperty("Webdriver.Chrome.Driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");

	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demo.guru99.com/telecom/index.html");

	    FileInputStream excel = new FileInputStream("C:\\Users\\Asus\\Desktop\\excels\\guru99.xlsx");
	    XSSFWorkbook wb = new XSSFWorkbook(excel);
	    sh = wb.getSheet("Sheet1");
	    Thread.sleep(2000);
	 }

	@Test (priority = 1)
	 public void addCustomerDataDriven() throws IOException, InterruptedException {
		for (int i = 1; i <= sh.getLastRowNum(); i++) {

	        driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")).click();

	        WebElement radiobtn = driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[2]/label"));
	        radiobtn.click();
	       
	        System.out.println("Radio button selected: " + radiobtn.isSelected());
	        driver.findElement(By.id("fname")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
	        driver.findElement(By.id("lname")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
	        driver.findElement(By.id("email")).sendKeys("fathimaps022002@gmail.com");
	        driver.findElement(By.name("addr")).sendKeys("Kanjirappally Kottayam");
	        driver.findElement(By.id("telephoneno")).sendKeys("9755678900");

	        driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[9]/ul/li[1]/input")).click();
            
	        WebElement source = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]/h3"));
			textToCopy = source.getText(); 
	       
	        File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(file1, new File("C:\\image\\addcustomer_row" + i + ".png"));
	        System.out.println("Screenshot saved successfully");

	        driver.get("https://demo.guru99.com/telecom/index.html");
	    }
	}


	@Test(priority = 2)
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

@Test(priority = 3)

	public void addtarifplanToCustomer() throws IOException, InterruptedException {
		

	    driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();

		
		driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[1]/div[2]/h3/a")).click();
		
		WebElement target = driver.findElement(By.xpath("//*[@id=\"customer_id\"]"));
		target.sendKeys(textToCopy);

		



		driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[6]/input")).click();
		WebElement add =driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div[2]/input"));
		add.click();
		
		
		File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1,new File("C:\\image\\addcustomerdd.png"));
		System.out.println("Screenshot saved successfully");
		Thread.sleep(2000);
		
		
		
	}

		@Test(priority = 4)
		public void paybill() throws IOException, InterruptedException {
		
			
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();

				
			
		driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[3]/div[2]/h3/a")).click();
		
		WebElement target = driver.findElement(By.xpath("//*[@id=\"customer_id\"]"));
		target.sendKeys(textToCopy);
		
		
		
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		
		
		String loc="C:\\image\\paybilling";
		File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
		FileUtils.copyFile(file1,new File(loc+"top_jpg.jpg"));  
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
