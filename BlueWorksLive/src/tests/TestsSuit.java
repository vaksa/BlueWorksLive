package tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestsSuit {

	WebDriver driver;
	String BASE_URL = "https://www.blueworkslive.com";
	String LOGIN = "automation.user.smtp@gmail.com";
	String PASSWORD = "qwerty1234";

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}

	// @Test
	public void task1() throws InterruptedException {
		driver.get(BASE_URL);
		driver.findElement(By.xpath("//*[@id='ibm-leadspace-body']//a")).click();
		// can be replaced with WebDriverWait
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='Ecom_ShipTo_Postal_Company']")).sendKeys("A123456789");
		driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Ivan");
		driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Ivanov");
		// change every run.
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("metall32213290@ukr.net");
		driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("0661144282");
		driver.findElement(By.xpath("//*[@name='jobTitle']")).sendKeys("JOB_TITLE");
		driver.findElement(By.xpath("//*[@name='promotionCode']")).sendKeys("98798798798");
		driver.findElement(By.xpath("//*[@name='Ecom_ShipTo_Postal_CountryCode']")).sendKeys("Georgia");
		driver.findElement(By.xpath("//*[@id='gwt-uid-2']")).click();
		driver.findElement(By.className("squareTextButton")).click();
		driver.findElement(By.className("squareTextButtonList")).findElement(By.xpath("button[2]")).click();
		Thread.sleep(20000);
		List<WebElement> icons = driver.findElements(By.className("bpIconAccountGood"));
		assertTrue("Success", icons.size() == 2);
	}

	@Test
	public void task2() throws InterruptedException {
		driver.get(BASE_URL);
		driver.findElement(By.xpath("//*[@id='ibm-primary-tabs']//em/a")).click();
		driver.findElement(By.id("txtLogin")).sendKeys(LOGIN);
		driver.findElement(By.id("txtPassword")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);

		driver.findElement(By.className("bp_goprobutton")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='pageHeaderOtherControls']/ul/li[4]/div/a")).click();

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
