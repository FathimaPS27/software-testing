package selenium_second;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class test {
		public static void main(String[] args)throws InterruptedException{
			System.setProperty("WebDriver.Chrome.Driver","C:\\Users\\angel\\OneDrive\\Desktop\\seleniumwebdriver\\chromedriver-win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.ironspider.ca/forms/checkradio.htm");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			WebElement blue=driver.findElement(By.xpath("//*[@id=\"Content\"]/div[1]/blockquote[1]/form/input[3]"));
			blue.click();
			System.out.println(blue.isSelected());
			List<WebElement>chklist=driver.findElements(By.xpath("//input[@name = 'color']"));//
			for(int i=0;i<chklist.size();i++)  
				
			{
				chklist.get(i).click();
				//System.out.println(chkList.get(i).getAttribute("value"));
				
				System.out.println(chklist.get(i).getDomAttribute("value"));
			}
			

		}}
	
	
	
	