package pom.classes.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Hello, Sign in']")
	private WebElement signIn;
	
	@FindBy(xpath = "//a[text()='Amazon Pay']")
	private WebElement amazonPay;
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickSignIn() 
	{
		signIn.click();
	}
	
	public void clickAmazonPay() 
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(amazonPay)).click();
		//amazonPay.click();
	}
}
