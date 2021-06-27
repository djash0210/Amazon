package pom.ngtestclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BrowserSetup.Pojo;
import pom.classes.amazon.APay;
import pom.classes.amazon.HomePage;
import pom.classes.amazon.LogInPage;
import utilitypack.UtilityImport;

public class AmazontestNg {
	private WebDriver driver;
	private HomePage hp;
	private APay apay;
	private SoftAssert soft;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	private UtilityImport ui;
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) 
	{
			reporter = new ExtentHtmlReporter("test-output//ExtentReort/Extent.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter);
			if(browser.equalsIgnoreCase("Chrome"))
			{
				driver=Pojo.openChromeBrowser();
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				driver=Pojo.openFirefoxDriver();
			}
			ui = new UtilityImport();
	}
	
	
	@BeforeMethod
	public void beforeMethod() 
	{
		LogInPage lp = new LogInPage(driver);
		lp.enterPhone();
		lp.clickContinue();
		lp.enterPassword();
		lp.clickSubmit();
		hp.clickAmazonPay();
	}
	
	@Test
	public void mobileRecharge() 
	{
		apay = new APay(driver);
		apay.clickMobRecharge();
		String url = driver.getCurrentUrl();
//		if(url.equals("https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_MobileRecharge")) {
//			System.out.println("Mobile Recharge pass 1");
//		}
//		else {
//			System.out.println("Mobile Recharge fail");
//		}
		
		//Assert.assertEquals(url, "https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_MobileRecharge");
		
		soft = new SoftAssert();
		soft.assertEquals(url, "https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_Mobile");
		soft.assertAll();
	}
	
	@Test(enabled = false)
	public void electricityClick() 
	{
		apay = new APay(driver);
		apay.clickElectricity();
		String url = driver.getCurrentUrl();
//		if(url.equals("https://www.amazon.in/hfc/bill/electricity?ref_=apay_deskhome_Electricity")) {
//			System.out.println("Electricity pass 2");
//		}
//		else {
//			System.out.println("Electricity fail");
//		}
		
		Assert.assertEquals(url, "https://www.amazon.in/hfc/bill/electricity?ref_=apay_deskhome_Electricity");
	}
	
	@Test(enabled = false)
	public void dthRechargeClick() 
	{
		apay = new APay(driver);
		apay.clickDTHRecharge();
		String url = driver.getCurrentUrl();
//		if(url.equals("https://www.amazon.in/hfc/dth?ref_=apay_deskhome_DTH")) {
//			System.out.println("DTH Recharge pass 3");
//		}
//		else {
//			System.out.println("DTH Recharge fail");
//		}
		
		Assert.assertEquals(url, "https://www.amazon.in/hfc/dth?ref_=apay_deskhome_DTH");
	}
	
	@Test(enabled = false)
	public void mobilePostpaid() 
	{
		apay = new APay(driver);
		apay.clickMobilePostpaid();
		String url = driver.getCurrentUrl();
//		if(url.equals("https://www.amazon.in/hfc/bill/mobile_postpaid?ref_=apay_deskhome_MobilePostpaid")) {
//			System.out.println("Mobile Postpaid pass 4");
//		}
//		else {
//			System.out.println("Mobile Postpaid fail");
//		}
		
		Assert.assertEquals(url, "https://www.amazon.in/hfc/bill/mobile_postpaid?ref_=apay_deskhome_MobilePostpaid");
	}
	
	@Test(enabled = false)
	public void insurancePremium() 
	{
		apay = new APay(driver);
		apay.clickInsurancePremium();
		String url = driver.getCurrentUrl();
//		if(url.equals("https://www.amazon.in/hfc/bill/insurance?ref_=apay_deskhome_Insurance")) {
//			System.out.println("Insurance Premium pass 5");
//		}
//		else {
//			System.out.println("Insurance Premium fail");
//		}
		
		Assert.assertEquals(url, "https://www.amazon.in/hfc/bill/insurance?ref_=apay_deskhome_Insurance");
	}
	
	@Test(enabled = false)
	public void pipedGas() 
	{
		apay = new APay(driver);
		apay.clickPipedGas();
		String url = driver.getCurrentUrl();
//		if(url.equals("https://www.amazon.in/hfc/bill/gas?ref_=apay_deskhome_PipedGas")) {
//			System.out.println("Piped Gas pass 6");
//		}
//		else {
//			System.out.println("Piped Gas fail");
//		}
		
		Assert.assertEquals(url, "https://www.amazon.in/hfc/bill/gas?ref_=apay_deskhome_PipedGas");
	}
	
	@AfterMethod
	public void logoutAccount(ITestResult result) throws InterruptedException, IOException 
	{
		//soft.assertAll();
		if(ITestResult.FAILURE == result.getStatus()) 
		{
			ui.takeScreenshot(driver);
		}
		Thread.sleep(3000);
		apay.clickDownArrow();
		apay.clickSignOut();
	}
	
	@AfterClass
	public void afterClass() 
	{
		driver.close();
	}
}
