package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {

	WebDriver driver = null;

	@Given("browser is invoked")
	public void browser_is_invoked() {

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("user is on register page")
	public void user_is_on_register_page() {
		//Invoke browser
		driver.navigate().to("https://buggy.justtestit.org/");

		//Click on Register button
		WebElement register = driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));
		register.click();
	}

	@When("user enters JohnDoe, John, Doe Abcd@{int} and Abcd@{int}")
	public void user_enters_john_doe_john_doe_abcd_and_abcd(Integer int1, Integer int2) {
		// Define variables for registration
		String userName = "User"+System.currentTimeMillis();
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

	@And("click on register button")
	public void click_on_register_button() throws InterruptedException {
		// Click on the registration button to register as new user.
		driver.findElement(By.xpath("/html/body/my-app/div/main/my-register/div/div/form/button")).click();
	}

	@Then("user is registered")
	public void user_is_registered() throws InterruptedException {
		//Wait
		Thread.sleep(3000);

		// Check whether the message on the registration was successful or not
		WebElement successMessage = driver.findElement(By.cssSelector("body > my-app > div > main > my-register > div > div > form > div.result.alert.alert-success"));
		String actualString = successMessage.getText();
		//System.out.println("Success Message: " + actualString);
		assertTrue(actualString.contains("Registration is successful"));
		
		//Close browser
		driver.close();
	}



}
