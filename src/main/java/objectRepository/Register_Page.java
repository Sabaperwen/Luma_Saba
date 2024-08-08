package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Page {

	@FindBy(xpath = "//div[@class='panel header']/descendant::a[text()='Create an Account']")
	private WebElement createAccount;
	
	
	@FindBy(xpath="//input[@id='firstname']")
	private WebElement Firstname;
	
	
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastName;
	
	
	@FindBy(xpath="//input[@id='email_address']")
	private WebElement email;
	
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pswrd;
	
	
	@FindBy(xpath = "//input[@id='password-confirmation']")
	private WebElement cnfrmPswrd;
	
	@FindBy(xpath = "//button[@class='action submit primary']")
	private WebElement submitBtn;
	
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public WebElement getCreateAccount() {
		return createAccount;
	}


	public WebElement getFirstname() {
		return Firstname;
	}


	public WebElement getLastName() {
		return lastName;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getPswrd() {
		return pswrd;
	}


	public WebElement getCnfrmPswrd() {
		return cnfrmPswrd;
	}


	public Register_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void register_App(String fstName,String lastname,String emailid,String pswrdd,String cnfrmPwrd)
	{
		Firstname.sendKeys(fstName);
		lastName.sendKeys(lastname);
		email.sendKeys(emailid);
		pswrd.sendKeys(pswrdd);
		cnfrmPswrd.sendKeys(cnfrmPwrd);
		submitBtn.click();
	}
	
	
	
	
	
	
	
}
