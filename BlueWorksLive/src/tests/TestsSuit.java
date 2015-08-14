package tests;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestsSuit {

	WebDriver driver;
	Login login;
	String BASE_URL = "https://www.blueworkslive.com";
	String LOGIN = "Ruslan.pasichniuk@gmail.com";
	String PASSWORD = "qwerty12345";

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		login = new Login(driver);
	}

	@Test
	public void task1() throws InterruptedException {
		driver.get(BASE_URL);
		driver.findElement(By.xpath("//*[@id='ibm-leadspace-body']//a")).click();
		// can be replaced with WebDriverWait
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='Ecom_ShipTo_Postal_Company']")).sendKeys("A123456789");
		driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Ivan");
		driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Ivanov");
		// TODO change every run.
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("metall322123290@ukr.net");
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
		login.with(LOGIN, PASSWORD);
		Thread.sleep(10000);
		WebElement dialog = driver.findElement(By.className("bpDialogHeaderXButtonImage"));
		Actions builder = new Actions(driver);
		builder.moveToElement(dialog).click(dialog);
		Action mouseoverAndClick = builder.build();
		mouseoverAndClick.perform();
		By logoutLocator = By.xpath("//*[@id='pageHeaderOtherControls']/ul/li[4]/div/a");
		driver.findElement(logoutLocator).click();
	}

	// @Test
	public void task3() throws InterruptedException {
		login.with(LOGIN, PASSWORD);
		Thread.sleep(10000);
		WebElement dialog = driver.findElement(By.className("bpDialogHeaderXButtonImage"));
		Actions builder = new Actions(driver);
		builder.moveToElement(dialog).click(dialog);
		Action mouseoverAndClick = builder.build();
		mouseoverAndClick.perform();
		List<WebElement> links = driver.findElements(By.xpath("//*[@id='pageHeaderContent']/ul/li"));
		for (WebElement link : links) {
			System.out.println(link.getText() + " page load ");
			Calendar data = Calendar.getInstance();
			long startTime = data.getTimeInMillis();
			System.out.println("startTime: " + startTime);
			long endTime = 0;
			link.click();
			By work = By.className("listInline");
			By community = By.className("squareTextButtonList");
			By library = By.className("listInline");
			builder.moveToElement(link).click(link);
			mouseoverAndClick = builder.build();
			mouseoverAndClick.perform();
			if (driver.findElement(work).isDisplayed() || driver.findElement(community).isDisplayed() || driver.findElement(library).isDisplayed()) {
				endTime = data.getTimeInMillis();
				System.out.println("endTime: " + endTime);
			}
			long pageLoadTime = (endTime - startTime) / 1000;
			assertTrue(link.getText() + " page loading was less than 3 seconds", pageLoadTime <= 3);
		}
		By logoutLocator = By.xpath("//*[@id='pageHeaderOtherControls']/ul/li[4]/div/a");
		driver.findElement(logoutLocator).click();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
