package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects_Customer.CustomerHomePage;
import pageObjects_Customer.CustomerSearch;
import pageObjects_DatePicker.DatePicker;
import pageObjects_Customer.CustomerDedupe;
import pageObjects_Login.LoginPage;

public class Login {

	WebDriver driver;

	@Test
	void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cggl-dev.capriglobal.in/");
		driver.manage().window().maximize();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginGoldLoan("aatest@capriglobal.in", "9S*L7Wn0UO&A", "GLB0001");

		CustomerHomePage customerHomePage = new CustomerHomePage(driver);
		customerHomePage.goToCustomerCreation();

		CustomerSearch customerSearch = new CustomerSearch(driver);
		customerSearch.goToCustomerDedupe();

		CustomerDedupe customerdedupe = new CustomerDedupe(driver);
		customerdedupe.customerDedupe("Rahul", "Madheshya", "Ashok Kumar Madheshya", "CTEPM1874K", "9455247324");
		
		DatePicker datePicker = new DatePicker(driver);
		datePicker.selectDate("2022", "12", "2");
		
	}
}
