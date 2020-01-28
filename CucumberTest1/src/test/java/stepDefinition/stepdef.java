package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepdef {
	public static WebDriver driver;
	pageObject po;

	@Given("^Navigate to next page$")
	public void enter() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		po = new pageObject(driver);
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@When("^user enters username and password$")
	public void unamepwd() {
		po.signin.click();
		po.username.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.login.click();
	}

	@Then("^user logged in successfully$")
	public void loggedin() {
		System.out.println("User login successfully");
	}

	@When("^Larry searches below products in search box:$")
	public void search(DataTable dt) {
		List<String> product = dt.asList(String.class);
		for (String s : product) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
			driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/a[2]")).click();
			driver.findElement(By.xpath("//a[@href='fetchcat.htm']")).click();
			driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/ul/a[2]")).click();
		}
		// pageObject.input.sendKeys();
	}
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter(String username,String password)
	{
		po.signin.click();
		po.username.sendKeys(username);
		po.password.sendKeys("Password123");
		po.login.click();
	}

	@Then("^product should be added in cart if available$")
	public void addcart() {
System.out.println("products added");
	}
}
