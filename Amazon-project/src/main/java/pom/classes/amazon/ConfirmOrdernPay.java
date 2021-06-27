package pom.classes.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrdernPay {
	@FindBy(xpath = "(//input[@class='a-button-input a-button-text'])[2]")
	private WebElement orderPay;
	
	public ConfirmOrdernPay(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrderPay() 
	{
		orderPay.click();
	}
}
