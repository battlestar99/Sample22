package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class StepDef {
	//hooks
	@Before
	public void init() {
		
	}
	
	WebDriver driver;
	
	@Given("user is in login page")
	public void user_login_page() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("headless");
		

		WebDriver driver = new ChromeDriver(options);

//		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Given("user is in login page using {string}")
	public void user_is_in_login_page_using(String browserName) {
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agile1Tech\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Agile1Tech\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.saucedemo.com/");
	}

	@When("user insert {string} in the user name text box")
	public void user_insert_in_the_user_name_text_box(String un) {
		WebElement userNameTextbox = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input"));
		userNameTextbox.sendKeys(un);
	}
	
	@When("user insert user name in the user name text box")
	public void user_insert_user_name_in_the_user_name_text_box() {
		WebElement userNameTextbox = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input"));
		userNameTextbox.sendKeys("standard_user");
	}
	
	@When("user insert standard user in the user name text box")
	public void user_insert_standard_user_in_the_user_name_text_box() {
		WebElement userNameTextbox = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input"));
		userNameTextbox.sendKeys("standard_user");
	}

	@When("user insert problem user in the user name text box")
	public void user_insert_problem_user_in_the_user_name_text_box() {
		WebElement userNameTextbox = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input"));
		userNameTextbox.sendKeys("problem_user");
	}

	@When("user insert locked out user in the user name text box")
	public void user_insert_locked_out_user_in_the_user_name_text_box() {
		WebElement userNameTextbox = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input"));
		userNameTextbox.sendKeys("locked_out_user");
	}

	@When("user insert performance glitch user in the user name text box")
	public void user_insert_performance_glitch_user_in_the_user_name_text_box() {
		WebElement userNameTextbox = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input"));
		userNameTextbox.sendKeys("performance_glitch_user");
	}

	
	@And("user insert password in the password text box")
	public void user_insert_password_in_the_password_text_box() {
		WebElement passwordTextbox = driver.findElement(By.name("password"));
		passwordTextbox.sendKeys("secret_sauce");
	}
	
	@When("user insert {string} in the password text box")
	public void user_insert_in_the_password_text_box(String pwd) {
		WebElement passwordTextbox = driver.findElement(By.name("password"));
		passwordTextbox.sendKeys(pwd);
	}

	@When("user click on the login button")
	public void user_click_on_the_login_button() {
		WebElement loginButton = driver.findElement(By.xpath("//input[@type = 'submit']"));
		loginButton.click();
	}

	@Then("user able to login")
	public void user_able_to_login() {
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		System.out.println(expectedUrl);
		
		if(expectedUrl.equals(actualUrl)) {
			System.out.println("URL mathed - test passed");
		}else {
			System.out.println("URL didn't match - test failed");
		}
	}
	
	@After
	public void closeBr() {
		driver.close();
	}

}
