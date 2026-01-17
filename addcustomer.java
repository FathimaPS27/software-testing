package datadriven_telecom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
 class addcustomer {

    WebDriver driver;   
    XSSFSheet sh;       

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

@Test
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

       
        File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file1, new File("C:\\image\\addcustomer_row" + i + ".png"));
        System.out.println("Screenshot saved successfully");

        driver.get("https://demo.guru99.com/telecom/index.html");
    }
}


        
@AfterSuite
 public void closebrowser() {
	 if (driver != null) {
         driver.quit();
         System.out.println("Browser closed successfully");
     }
 }
}
       

