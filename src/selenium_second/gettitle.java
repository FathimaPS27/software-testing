package selenium_second;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gettitle {

	public static void main(String[] args)throws InterruptedException {
        System.setProperty("WebDriver.Chrome.Driver","C:\\\\Users\\\\Asus\\\\Desktop\\\\selenium webdriver\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		int A = pageTitle.length();
		System.out.println("Length of the page title is" +A);
		String pageurl=driver.getCurrentUrl();
		System.out.println(pageurl);
		if(pageurl.equals("https://demoqa.com/text-box"))
		{
			System.out.println("Actual url is same as expected");
		}else{System.out.println("Actual result is not as expected");
		
		}

	}

}
