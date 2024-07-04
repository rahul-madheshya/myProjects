package pageObjects_DatePicker;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusable.AbstractUtility;

public class DatePicker extends AbstractUtility {

	WebDriver driver;

	public DatePicker(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Choose date']")
	WebElement datePicker;

	@FindBy(xpath = "//div[@class='css-epd502']/div/div/div/div/div")
	WebElement viewYear;

	@FindBy(xpath = "(//div[@class='PrivatePickersYear-root PrivatePickersYear-modeDesktop css-j9zntq']/button)")
	List<WebElement> selectYear;

	@FindBy(xpath = "//button[@title='Next month']")
	WebElement selectMonth;

	@FindBy(xpath = "(//div[@role='row']/button)")
	List<WebElement> selectDay;

	public void selectDate(String year, String month, String day) throws InterruptedException {
		datePicker.click();
		waitforSecond(2);
		viewYear.click();
		waitforSecond(2);
		for (int i = 0; i < selectYear.size(); i++) {
			if (selectYear.get(i).getText().equalsIgnoreCase(year)) {
				selectYear.get(i).click();
			}
		}
		waitforSecond(2);
		for (int i = 1; i < Integer.parseInt(month); i++) {
			if (i != Integer.parseInt(month)) {
				selectMonth.click();
			} else {
				break;
			}
		}
		waitforSecond(2);
		for (int i = 0; i < selectDay.size(); i++) {
			if (selectDay.get(i).getText().equalsIgnoreCase(day)) {
				selectDay.get(i).click();
			}
		}
	}
}
