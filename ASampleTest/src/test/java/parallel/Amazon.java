package parallel;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;
//import com.util.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	static String username;
	static String password;
	static String item;

	WebDriver driver;
		@Given("user is already on Login Page")
		public void user_is_already_on_login_page() {
		    // Write code here that turns the phrase above into concrete actions
			//System.setProperty("webdriver.chrome.driver","D:\\3PL\\Test29\\Drivers\\chromedriver2.exe");
			//driver = new ChromeDriver();
			DriverFactory.getDriver().get("https://www.amazon.com/");
		}

 public static void details(String sheetName,int rowNumber) throws InvalidFormatException, IOException {
	 ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("src\\test\\resources\\TestData\\TestData.xlsx", sheetName);
		
		 username = testData.get(rowNumber).get("username");
		 password = testData.get(rowNumber).get("password");
		 item = testData.get(rowNumber).get("item");
 }
		
		@When("title of login page is Amazon")
		public void title_of_login_page_is_amazon() {
			title=loginPage.getLoginPageTitle();
			 System.out.println(title);
			Assert.assertEquals("Amazon.com. Spend less. Smile more.", title);
		}
		
		
		@Then("user enters {string} and {int}")
		public void user_enters_and(String login, int rowNumber) throws InvalidFormatException, IOException {
			
			details(login,rowNumber);
			System.out.println("user"+username);
			loginPage.clickOnMenu();
			loginPage.enterUserName(username);
			 loginPage.clickOnContinue();
			 loginPage.enterPassword(password);
		}
		@Then("user clicks on login button")
		public void user_clicks_on_login_button() throws InterruptedException {
			loginPage.clickOnLogin();
			 Thread.sleep(5000);
		}
		@Then("user is on home page")
		public void user_is_on_home_page() {
			title=loginPage.getLoginPageTitle();
			 System.out.println("Home Page title ::"+ title);
			Assert.assertEquals("Amazon.com. Spend less. Smile more.", title);
		}
		@Then("Search the product from list")
		public void search_the_product_from_list() throws InvalidFormatException, IOException {
			// System.out.println("Home Page title ::"+  driver.findElement(By.id("twotabsearchtextbox")));
			 loginPage.search(item);
			 List<WebElement> list=loginPage.productCost();
			 for(WebElement i:list)
				 System.out.println(i.getText());
			
		}
		@Then("Close the browser")
		public void close_the_browser() {
			DriverFactory.getDriver().quit();
		}




}
