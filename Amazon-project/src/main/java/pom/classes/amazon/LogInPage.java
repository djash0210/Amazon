package pom.classes.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	@FindBy(xpath = "//input[@type='email']")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continue1;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement submit;
	
	public LogInPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPhone() 
	{
		phone.sendKeys("8408950364");
	}
	
	public void clickContinue() 
	{
		continue1.click();
	}
	
	public void enterPassword() 
	{
		password.sendKeys(Password.data("pwd"));
	}
	
	public void clickSubmit() 
	{
		submit.click();
	}
}
