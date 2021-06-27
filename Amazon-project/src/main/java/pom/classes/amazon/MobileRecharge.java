package pom.classes.amazon;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileRecharge {
	@FindBy(xpath = "(//input[@type='tel'])[1]")
	private WebElement mobile;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement operator;
	
	@FindBy(xpath = "//input[contains(@value,'Airtel~AIRTEL_PRE')]")
	private WebElement airtel;
	
	@FindBy(xpath = "//span[text()='Maharashtra & Goa']")
	private WebElement circle;
	
	@FindBy(xpath = "//a[@id='viewPlanTriggerId']")
	private WebElement viewPlan;
	
	@FindBy(xpath = "//a[contains(text(),'Talktime')]")
	private WebElement talkTime;
	
	@FindBy(xpath = "//input[contains(@value,'Talktime~10~')]")
	private WebElement amt;
	
	@FindBy(xpath = "//span[text()='Continue to Pay ₹10']")
	private WebElement pay;
	
	public MobileRecharge(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void enterMobile() 
	{
		mobile.sendKeys("8237311639");
	}
	public void clickOperator() 
	{
		operator.click();
	}
	public void selectAirtel() 
	{
		airtel.click();
	}
	public void selectCircle() 
	{	
		circle.click();
	}
	public void clickViewPlan() 
	{
		viewPlan.click();
	}
	public void clickTalktime() 
	{
		talkTime.click();
	}
	public void selectAmt() 
	{
		amt.click();
	}
	public void clickPay() 
	{
		pay.click();
	}
}
