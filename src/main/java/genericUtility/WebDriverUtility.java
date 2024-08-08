package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class WebDriverUtility {

	

	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public WebDriverWait ObjectOFwait(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		return wait;
	}
	
	public void handlingExplicitelyWait(WebDriver driver,int sec,WebElement ele)
	{
		ObjectOFwait(driver, sec).until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	public void handlingExplicitelyWait(int sec,WebDriver driver,WebElement ele)
	{
		ObjectOFwait(driver, sec).until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	public void handlingExplicitelyWait(int sec,WebDriver driver)
	{
		ObjectOFwait(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	
	
	
	public void handleDropDown(WebDriver driver,WebElement ele,int index)
	{
		Select  select=new Select(ele);
		select.selectByIndex(index);
	}
	
	public void handleDropDown(WebElement ele,String value)
	{
		Select  select=new Select(ele);
		select.selectByValue(value);
	}
	
	public void handleDropDown(String text,WebElement ele)
	{
		Select  select=new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public Actions objectOfActions(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	
	public void mouseHoverAction(WebDriver driver,WebElement ele)
	{
		objectOfActions(driver).click(ele).perform();
	}
	
	public void mouseHoverAction(WebDriver driver,WebElement src,WebElement dst)
	{
		objectOfActions(driver).dragAndDrop(src, dst).perform();
	}
	
	public void mouseHoverAction(WebElement ele,WebDriver driver)
	{
		objectOfActions(driver).doubleClick(ele).perform();
	}
	
	
	public void switchingFramework(WebDriver driver,String expTitle) {
	
	Set<String> allId = driver.getWindowHandles();
	for(String id:allId)
	{
		String title=driver.switchTo().window(id).getTitle();
		if(title.equals(expTitle))
		{
			break;
		}
	}
	
}
	
	public static String  takesScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
	 JavaLib lib=new JavaLib();
	 TakesScreenshot ts=(TakesScreenshot) driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 String path=".\\screenshot\\"+screenshotName+lib.dateFormat()+".png";
	 File dst=new File(path);
	 String srcpath = dst.getAbsolutePath();
	 FileHandler.copy(src, dst);
	return srcpath;
	
	}
	
	
	
	
	
	
	
	
}
