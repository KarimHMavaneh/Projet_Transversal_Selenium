package pages;

import helpers.Helpers;
import helpers.MyTestDriver;
import helpers.TestDriver;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreerPageTicket extends GlpiPageObject {
    private static final String url_page_ticket = "http://localhost/glpi_10_0_6/front/ticket.form.php";
    protected CreerPageTicket(MyTestDriver driver) {
        super(driver, url_page_ticket);
    }

    public CreerPageTicket saisirTitreDescrip(JSONObject ticketObj){
        System.out.println( driver.getCurrentUrl() );
        driver.clickAndSendKeys(By.cssSelector("input[name='name']"), ticketObj.getString("titre"));

        // Scrolle down to the title's element


        //15 | Change the selenium driver to the iframe
        WebDriver iframe  = driver.getDriver().switchTo().frame(driver.getDriver().findElement(By.className("tox-edit-area__iframe")));
        iframe.findElement(By.id("tinymce")).sendKeys(ticketObj.getString("content"));
        //16 | don't forget to change the focus from iframe to the default content

        driver.getDriver().switchTo().defaultContent().findElement(By.cssSelector("button[name='add']")).click();
        return this;

    }

}
