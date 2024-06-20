package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// find web elements on webpage
	@FindBy(xpath = "//button[text()='Student']")
	WebElement selectStudent;

	@FindBy(xpath = "//button[text()='Teacher']")
	WebElement selectTeacher;

	@FindBy(xpath = "//input[@name='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//input[@name='password']")
	WebElement enterPwd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	// method to interact to the WebElements
	// select student or teacher
	public void selectStudent() {
		selectStudent.click();
	}

	// select student or teacher
	public void selectTeacher() {
		selectTeacher.click();
	}

	// enter email
	public void enterEmail(String email) {
		enterEmail.sendKeys(email);
	}

	// enter password
	public void enterPassword(String pwd) {
		enterPwd.sendKeys(pwd);
	}

	public void clickLogin() {
		loginButton.click();
	}

}
