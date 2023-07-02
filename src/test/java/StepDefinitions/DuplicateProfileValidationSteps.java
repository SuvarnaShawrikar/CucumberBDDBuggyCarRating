package StepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuplicateProfileValidationSteps {

	WebDriver driver = null;

	@Given("invoke browser")
	public void invoke_browser() {

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("user is on registration page")
	public void user_is_on_registration_page() {
		//Invoke browser
		driver.navigate().to("https://buggy.justtestit.org/");

		//Click on Register button
		WebElement register = driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));
		register.click();
	}

	@When("user enters Buggy123, John, Doe Abcd@{int} and Abcd@{int}")
	public void user_enters_buggy123_john_doe_abcd_and_abcd(Integer int1, Integer int2) throws InterruptedException {
		// Define variables for registration
		String userName = "Buggy123";
		String firstName = "John";
		String lastName = "Doe";
		String password = "Password@123";

		// Enter Username, Firstname, Lastname & password on registration form.
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(userName);
		WebElement firstname = driver.findElement(By.id("firstName"));
		firstname.sendKeys(firstName);
		WebElement lastname = driver.findElement(By.id("lastName"));
		lastname.sendKeys(lastName);
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys(password);
		WebElement conPwd = driver.findElement(By.name("confirmPassword"));
		conPwd.sendKeys(password);
	}

	@And("click on the register button")
	public void click_on_the_register_button() throws InterruptedException {
		// Click on the registration button to register as new user.
		driver.findElement(By.xpath("/html/body/my-app/div/main/my-register/div/div/form/button")).click();
	}

	@Then("user is already registered")
	public void user_is_already_registered() throws InterruptedException {

		//Wait after registration to validate result.
		Thread.sleep(3000);

		// Check whether the message on the registration was successful or not
		WebElement errorMessage = driver.findElement(By.cssSelector("body > my-app > div > main > my-register > div > div > form > div.result.alert.alert-danger"));
		String actualString = errorMessage.getText();
		System.out.println("Error Message: " + actualString);
		assertTrue(actualString.contains("UsernameExistsException: User already exists"));

		//Close browser
		driver.close();
	}

}
