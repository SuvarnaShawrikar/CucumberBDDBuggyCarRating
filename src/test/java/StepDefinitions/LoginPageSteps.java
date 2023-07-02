package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	WebDriver driver = null;

	@Given("browser is opened")
	public void browser_is_opened() {
		System.out.println("inside open browser");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		//Invoke browser
		driver.navigate().to("https://buggy.justtestit.org/");
	}

	@When("user enters Buggy1234 and Abcd@{int}")
	public void user_enters_buggy1234_and_abcd(Integer int1) {
		// Define variables for login
		String userName = "Buggy1234";
		String password = "Abcd@123";

		// Enter Username & password to login.
		WebElement username = driver.findElement(By.name("login"));
		username.sendKeys(userName);
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys(password);		
		System.out.println("User enters username and password");
	}

	@And("click on login button")
	public void click_on_login_button() {
		// Click on the Login button.
		driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/button")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		//System.out.println("User is navigated to home page");
	}

	@And("click on logout button")
	public void click_on_logout_button() throws InterruptedException {

		//Wait
		Thread.sleep(3000);

		// Click on the Logout button.
		driver.findElement(By.cssSelector("body > my-app > header > nav > div > my-login > div > ul > li:nth-child(3) > a")).click();

		//Close the browser
		driver.close();
	}


}
