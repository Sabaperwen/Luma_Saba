package com.Register;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.Register_Page;
@Listeners(genericUtility.ItestListenerImplClass.class)
public class Register_Test extends BaseClass  {
WebDriverUtility utility=new WebDriverUtility();
PropertyFileUtility pf=new PropertyFileUtility();


	@Test
	public void registerApp() throws IOException
	{
		
		System.out.println("start");
		
       String Frstname=pf.readDataFromPropertyFile("dirstName");
       String lstName=pf.readDataFromPropertyFile("LastName");
       String email = pf.readDataFromPropertyFile("Email");
       String pswrd=pf.readDataFromPropertyFile("Pswrd");
       String cnfrm= pf.readDataFromPropertyFile("CnfrmPswrd");
        
		Register_Page r=new Register_Page(driver);
		r.getCreateAccount().click();
		r.register_App(Frstname, lstName, email, pswrd, cnfrm);
		
				
		
		
		
	}
}
