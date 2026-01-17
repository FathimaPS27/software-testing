package selenium_second;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkbox {

	public static void main(String[] args)throws InterruptedException{
		System.setProperty("webdriver.chorme.driver","C:\\Users\\Asus\\Desktop\\selenium webdriver\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement purplebtn=driver.findElement(By.xpath("//*[@id=\"Content\"]/div[1]/blockquote[1]/form/input[6]"));
		purplebtn.click();
		System.out.println(purplebtn.isSelected());
		
		List<WebElement>chkList=driver.findElements(By.xpath("//input[@name = 'color']"));//
		for(int i=0;i<chkList.size();i++)   // for select all list
											//tagname[@attribute name='value'];
											   //input [@type='checkbox']; or input[@name = color];
			
		{
			chkList.get(i).click();
			//System.out.println(chkList.get(i).getAttribute("value"));
			
			System.out.println(chkList.get(i).getDomAttribute("value"));
		}
		

	}

}
