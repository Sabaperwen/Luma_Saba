package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
public static	WebDriver driver;
	PropertyFileUtility pf = new PropertyFileUtility();
    WebDriverUtility wb=new  WebDriverUtility();
@BeforeClass
  public void launchBrowser() throws IOException
 {
	String browser=pf.readDataFromPropertyFile("Browser");
	if(browser.equals("chrome"))
	{
     driver=new ChromeDriver();	
    }
	else if(browser.equals("fireFox")) {
		driver=new FirefoxDriver();
	}
	else if(browser.equals("EdgeDriver")) {
		driver=new EdgeDriver();
	}
	wb.maximizeBrowser(driver);
	wb.waitForPageLoad(driver);
	String url=pf.readDataFromPropertyFile("URL");
	driver.get(url);

  }
}
