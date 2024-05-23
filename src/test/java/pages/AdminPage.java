package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminPage {
	WebDriver driver;

	By menuItems = By.xpath("//div[@class='oxd-sidepanel-body']//ul[@class='oxd-main-menu']/li");
	By adminTab = By.xpath("//li[1]//a[1]//span[1]");
	By usernameTextBox = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
	By searchButton = By.xpath("//button[@type='submit']");
	By userRoleDropdown = By
			.xpath("//div[@class='oxd-table-filter-area']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
	By statusDropdown = By.xpath("//div[4]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
	By resultCount = By.xpath("//span[@class='oxd-text oxd-text--span']");

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getMenuItemsCount() {
		List<WebElement> items = driver.findElements(menuItems);
		return items.size();
	}

	public void clickAdminTab() {
		driver.findElement(adminTab).click();
	}

	public void searchByUsername(String username) {
		driver.findElement(usernameTextBox).sendKeys(username);
		driver.findElement(searchButton).click();
	}

	public void searchByUserRole() {
		driver.findElement(userRoleDropdown).click();
		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/span"))
				.click();
		driver.findElement(searchButton).click();
	}

	public void searchByUserStatus() {
		driver.findElement(statusDropdown).click();
		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]/span"))
				.click();
		driver.findElement(searchButton).click();
	}

	public int getResultCount() {
		String resultText = driver.findElement(resultCount).getText();
		resultText = resultText.replaceAll("[^0-9]", "");
		return Integer.parseInt(resultText);
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}
}
