package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addUserName(String un) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
	}

	public void addPassword(String ps) {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
	}

	public void clickLogin() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
