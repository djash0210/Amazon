package pom.classes.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APay {
	private WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Mobile Recharge']")
	private WebElement mobRecharge;
	
	@FindBy(xpath = "//span[text()='Electricity']")
	private WebElement electricity;
	
	@FindBy(xpath = "//span[text()='DTH Recharge']")
	private WebElement dthRecharge;
	
	@FindBy(xpath = "//span[text()='Mobile Postpaid']")
	private WebElement mobPostpaid;
	
	@FindBy(xpath = "//span[text()=' Insurance Premium']")
	private WebElement insurancePremium;
	
	@FindBy(xpath = "//span[text()='Piped Gas']")
	private WebElement pipedGas;
	
	@FindBy(xpath = "(//span[@class='nav-icon nav-arrow'])[2]")
	private WebElement downArrow;
	
	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement signOut;
	
	public APay(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickMobRecharge() 
	{
		mobRecharge.click();
	}
	
	public void clickElectricity() 
	{
		electricity.click();
	}
	
	public void clickDTHRecharge() 
	{
		dthRecharge.click();
	}
	
	public void clickMobilePostpaid() 
	{
		mobPostpaid.click();
	}
	
	public void clickInsurancePremium() 
	{
		insurancePremium.click();
	}
	
	public void clickPipedGas() 
	{
		pipedGas.click();
	}
	
	public void clickDownArrow() 
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(downArrow).perform();
	}
	
	public void clickSignOut() 
	{
		signOut.click();
	}
}
