package proschool.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.ScreenshotUtils;

public class LoginTest {
	
	public String baseUrl = "https://proschool.ai/login";
	public WebDriver driver;
	
	public String email = "";
	public String pwd = "";
	
	@BeforeTest
	public void setUp() {
		System.out.println("Before test execution");
		
		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--headless");
		driver = new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	@Test
	public void loginToProSchool() {
		LoginPage lp = new LoginPage(driver);
		lp.selectStudent();
		
		lp.enterEmail(email);
		lp.enterPassword(pwd);
		lp.clickLogin();
		
		HomePage hm = new HomePage(driver);
		String expectedToastMessage = "Login successful.";
		
		try {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		String actualToastMessage = hm.getToastMessage();
		Assert.assertEquals(actualToastMessage, expectedToastMessage, "Toast message text is not as expected");
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		System.out.println("tear down execution");
		
		ScreenshotUtils.captureScreenshot(driver);
		
		Thread.sleep(5000);
		driver.quit();
	}

}
