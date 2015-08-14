package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	private WebDriver driver;
	String BASE_URL = "https://www.blueworkslive.com";
	By usernameLocator = By.id("txtLogin");
	By passwordLocator = By.id("txtPassword");
	By loginFormLocator = By.id("loginButton");

	public Login(WebDriver driver) {
		this.driver = driver;
		driver.get(BASE_URL);
		driver.findElement(By.xpath("//*[@id='ibm-primary-tabs']//em/a")).click();
	}

	public void with(String username, String password) {
		driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(loginFormLocator).click();
	}

}