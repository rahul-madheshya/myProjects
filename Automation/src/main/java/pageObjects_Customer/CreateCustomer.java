package pageObjects_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomer {

	WebDriver driver;

	public CreateCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Create Customer']")
	WebElement button_CreateCustomer;

	public void customerCreate() {

		button_CreateCustomer.click();
	}
}
