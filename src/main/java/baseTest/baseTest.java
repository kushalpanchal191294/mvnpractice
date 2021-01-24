package baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class baseTest {
	public static	WebDriver driver;
	public static	Properties prop;
	
	
	public baseTest() throws IOException{
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
		prop = new Properties();
		prop.load(f);
	}

	public void openBrowser(){
		
	
		if (prop.getProperty("Browser").equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "K:\\selenium\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (prop.getProperty("Browser").equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", "K:\\selenium\\SeleniumJars\\chromedriver.exe");
				driver = new ChromeDriver();
				}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	public void closeBrowser(){
		driver.close();
	}
	
	public void openUrl (){
		driver.get(prop.getProperty("Url"));
	}
}


