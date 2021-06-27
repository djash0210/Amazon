package pom.testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.classes.amazon.APay;
import pom.classes.amazon.ConfirmOrdernPay;
import pom.classes.amazon.HomePage;
import pom.classes.amazon.LogInPage;
import pom.classes.amazon.MobileRecharge;

public class AmazonSignIn {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tushar\\Desktop\\Selenium Folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		HomePage hp = new HomePage(driver);
		hp.clickSignIn();
		
		LogInPage lp = new LogInPage(driver);
		lp.enterPhone();
		lp.clickContinue();
		lp.enterPassword();
		lp.clickSubmit();
		
		Thread.sleep(5000);
		
		hp = new HomePage(driver);
		hp.clickAmazonPay();
		
		APay ap = new APay(driver);
		ap.clickMobRecharge();
		
		MobileRecharge mr = new MobileRecharge(driver);
		mr.enterMobile();
		//mr.clickOperator();
		//mr.selectAirtel();
		//mr.selectCircle();
		mr.clickViewPlan();
		Thread.sleep(4000);
		mr.clickTalktime();
		mr.selectAmt();
		mr.clickPay();
		
		ConfirmOrdernPay op = new ConfirmOrdernPay(driver);
		op.clickOrderPay();
	}

}
