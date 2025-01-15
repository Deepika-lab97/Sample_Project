package TestNGTC1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjectModel.LoginPage;

public class LoginTest {
	WebDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        // Here you could read data from an external file (e.g., Excel)
        return new Object[][] {
            {"user1", "password1"},
            {"user2", "password2"},
            {"user3", "password3"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        driver = new ChromeDriver();
        driver.get("http://example.com/login");

        // Use the POM class to interact with the login page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        
        // Assertions (e.g., check if login is successful)
        // Example: Assert.assertTrue(driver.getTitle().contains("Welcome"));

        driver.quit();
        // quiting the driver
    }

}
