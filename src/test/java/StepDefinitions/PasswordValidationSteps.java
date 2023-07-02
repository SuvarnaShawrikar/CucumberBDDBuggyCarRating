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

public class PasswordValidationSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("user is on the registration page")
	public void user_is_on_the_registration_page() {
		//Invoke browser and navigate to website
		driver.navigate().to("https://buggy.justtestit.org/");

		//Click on Register button
		WebElement register = driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));
		register.click();
	}

	@When("user enters JohnDoe1 and password@{int}")
	public void user_enters_john_doe1_and_password(Integer int1) {
		// Define variables for registration
		String userName = "User";
		String firstName = "John";
		String lastName = "Doe";
		String password = "password@123";

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

	@When("user enters JohnDoe2 and Password123")
	public void user_enters_john_doe2_and_password123() {
		// Define variables for registration
		String userName = "User";
		String firstName = "John";
		String lastName = "Doe";
		String password = "Password123";

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

	@When("user enters JohnDoe3 and PASSWORD@{int}")
	public void user_enters_john_doe3_and_password(Integer int1) {
		// Define variables for registration
		String userName = "User";
		String firstName = "John";
		String lastName = "Doe";
		String password = "PASSWORD@123";

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

	@When("user enters JohnDoe4 and Pass@{int}")
	public void user_enters_john_doe4_and_pass(Integer int1) {
		// Define variables for registration
		String userName = "User";
		String firstName = "John";
		String lastName = "Doe";
		String password = "Pass@12";

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


	@And("user click on the register button")
	public void user_click_on_the_register_button() {
		// Click on the registration button.
		driver.findElement(By.xpath("/html/body/my-app/div/main/my-register/div/div/form/button")).click();
	}

	@Then("user see an error message indicating the password requirements")
	public void user_see_an_error_message_indicating_the_password_requirements() throws InterruptedException {
		//Wait
		Thread.sleep(3000);

		//Call errorMessageCheck Method
		errorMessageCheck();

		//Close browser
		driver.close();
	}

	void errorMessageCheck() {
		// Check whether the message on the registration was successful or not
		WebElement errorMessage = driver.findElement(By.cssSelector("body > my-app > div > main > my-register > div > div > form > div.result.alert.alert-danger"));
		String actualString = errorMessage.getText();
		System.out.println("Error Message: " + actualString);
		if(actualString.contains("Password must have uppercase characters")) {
			assertTrue(actualString.contains("InvalidPasswordException: Password did not conform with policy: Password must have uppercase characters"));
		}
		else if(actualString.contains("Password must have symbol characters")){
			assertTrue(actualString.contains("InvalidPasswordException: Password did not conform with policy: Password must have symbol characters"));
		}
		else if(actualString.contains("Password must have lowercase characters")){
			assertTrue(actualString.contains("InvalidPasswordException: Password did not conform with policy: Password must have lowercase characters"));
		}
		else {
			assertTrue(actualString.contains("InvalidPasswordException: Password did not conform with policy: Password not long enough"));
		}

	}

}
