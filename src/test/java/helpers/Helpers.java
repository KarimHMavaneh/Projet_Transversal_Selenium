package helpers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class Helpers {

    public static HomePage login(MyTestDriver driver, String username, String password) {
        return new LoginPage(driver)
                .gotoPage()
                .setUser(username)
                .setPassword(password)
                .clickLoginButton();
    }
}
