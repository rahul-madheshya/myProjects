package pageObjects_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusable.AbstractUtility;

public class LoginPage extends AbstractUtility {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//div/input[@role='combobox']")
	WebElement branch;
	
	@FindBy(xpath = "//li[@id='auto-complete-option-0']")
	WebElement selectEnteredBranch;
	
	@FindBy(xpath = "//div/button[@type='submit']")
	WebElement submit;

	public void loginGoldLoan(String emailId, String userPassword, String branchCode) throws InterruptedException {
		email.sendKeys(emailId);
		password.sendKeys(userPassword);
		loginButton.click();
		wiatForElementToBeVisisble(branch);
		branch.sendKeys(branchCode);
		selectEnteredBranch.click();
		submit.click();
	}
}
