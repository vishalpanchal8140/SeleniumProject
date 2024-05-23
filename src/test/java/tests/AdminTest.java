package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

public class AdminTest {
	WebDriver driver;
	AdminPage adminPage;
	LoginPage t1;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		t1 = new LoginPage(driver);
		adminPage = new AdminPage(driver);
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		t1.addUserName("Admin");
		t1.addPassword("admin123");
		t1.clickLogin();

		Thread.sleep(3000);

		int count = adminPage.getMenuItemsCount();
		assert count == 12 : "Menu items count is not 12";
		System.out.println("Total Menu records found: " + count);

		adminPage.clickAdminTab();
	}

	@Test(priority = 2)
	public void testSearchByUsername() throws InterruptedException {
		adminPage.searchByUsername("Admin");
		int results = adminPage.getResultCount();
		System.out.println("Total records found for Search By User Name : " + results);
		Thread.sleep(2000);
		adminPage.refreshPage();
	}

	@Test(priority = 3)
	public void testSearchByUserRole() throws InterruptedException {
		adminPage.searchByUserRole();
		int results = adminPage.getResultCount();
		System.out.println("Total records found for Search By User Role: " + results);
		Thread.sleep(2000);
		adminPage.refreshPage();
	}

	@Test(priority = 4)
	public void testSearchByUserStatus() {
		adminPage.searchByUserStatus();
		int results = adminPage.getResultCount();
		System.out.println("Total records found for Search By User Status: " + results);
	}
}
