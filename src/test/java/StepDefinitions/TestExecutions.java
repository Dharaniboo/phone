package StepDefinitions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecutions {
	public   WebDriver driver;
	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		File file = new File("lib/chromedriver.exe");
		String filePath = file.getAbsolutePath();
		System.out.println(filePath);
		System.setProperty("webdriver.chrome.driver", filePath);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		driver =  new ChromeDriver(chromeOptions);
         driver.get("https://www.thechennaimobiles.com/");
       
 	
	}
	
	@Before
	public void openbrowser()
	{
	System.out.println(" browser gets opened");
	}
	
	@When("^user click login$")
	public void user_click_login() throws Throwable {
		driver.findElement(By.xpath("//a[@href='#']")).click();
	}
	
	@Then("^it will navigate to login page$")
	public void it_will_navigate_to_login_page() throws Throwable {
		driver.findElement(By.xpath("//a[@href='https://www.thechennaimobiles.com/index.php?route=account/login']")).click();
			}

	
	@Then("^user enters email_id and password$")
	public void user_enters_email_id_and_password() throws Throwable {
		driver.findElement(By.id("input-email")).sendKeys("dharaniboopalan1026@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Dharani@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	

@When("^user search product$")
public void user_search_product() throws Throwable {
	driver.findElement(By.id("text-search")).sendKeys("realme X7 Max 12GB RAM - 256GB Mercury Silver");
}

@Then("^it will show list of particular products$")
public void it_will_show_list_of_particular_products() throws Throwable {
	driver.findElement(By.id("btn-search-category")).click();	
}

@Then("^user select product$")
public void user_select_product() throws Throwable {
	try {
		driver.findElement(By.className("product-search home1")).click();	
	} catch (NoSuchElementException e) {
	e.printStackTrace();
	}

}

@After
public void closebrowser()
{
System.out.println(" browser gets closed");
//driver.close();
driver.quit();
}
}
