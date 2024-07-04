package reusable;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractUtility {

	WebDriver driver;

	public AbstractUtility(WebDriver driver) {
		this.driver = driver;
	}

	protected void wiatForElementToBeVisisble(WebElement selectYear) {
		String xpath = selectYear.toString();
		xpath = xpath.substring(xpath.lastIndexOf(" ") + 1);
		if (xpath.substring(xpath.length() - 1, xpath.length()).equalsIgnoreCase("'")
				|| xpath.substring(xpath.length() - 1, xpath.length()).equalsIgnoreCase("]")) {
			xpath = xpath.substring(0, xpath.length() - 1);
		}
		System.out.println("xpath=" + xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	protected void waitforSecond(int sec) throws InterruptedException
	{
		Thread.sleep(sec*1000);
	}
}
