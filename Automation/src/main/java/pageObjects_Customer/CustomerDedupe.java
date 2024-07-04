package pageObjects_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDedupe {

	WebDriver driver;

	public CustomerDedupe(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/input[@name='firstName']")
	WebElement input_FirstName;

	@FindBy(xpath = "//div/input[@name='lastName']")
	WebElement input_lastName;

	@FindBy(xpath = "//div/input[@name='fatherName']")
	WebElement input_FatherName;

	@FindBy(xpath = "//div/input[@name='pan']")
	WebElement input_PanNumber;

	@FindBy(xpath = "//div/input[@name='mobileNumber']")
	WebElement input_MobileNumber;
	
	@FindBy(xpath = "//button[text()='Customer De-dupe']")
	WebElement button_customerDedupeSearch;
	
	@FindBy(xpath = "//button[text()='Create Customer']")
	WebElement createCustomer;

	public void customerDedupe(String fisrtName, String lastName, String fatherName, String pan, String mobileNumber) {
		input_FirstName.sendKeys(fisrtName);
		input_lastName.sendKeys(lastName);
		input_FatherName.sendKeys(fatherName);
		input_PanNumber.sendKeys(pan);
		input_MobileNumber.sendKeys(mobileNumber);
		button_customerDedupeSearch.click();
	}
}
