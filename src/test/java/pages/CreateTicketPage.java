package pages;

import helpers.MyTestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTicketPage extends GlpiPageObject {
    private static final String url_page_ticket = "http://localhost/glpi_10_0_6/front/ticket.form.php";
    public CreateTicketPage(MyTestDriver driver) {
        super(driver, url_page_ticket);
    }

    public CreateTicketPage ticketTitleNDescription(String title, String desc) {

//        new LoginPage(this.driver).login(LoginPage.TEST_USER_OK, LoginPage.TEST_PASSWORD_OK);

//        System.out.println( driver.getCurrentUrl() );
        //driver.clickAndSendKeys(By.cssSelector("input[name='name']"), ticketObj.getString("titre"));
        driver.clickAndSendKeys(By.cssSelector("input[name='name']"), title);

        // Scrolle down to the title's element

        //15 | Change the selenium driver to the iframe
        WebDriver iframe  = driver.getDriver().switchTo().frame(driver.getDriver().findElement(By.className("tox-edit-area__iframe")));
        //iframe.findElement(By.id("tinymce")).sendKeys(ticketObj.getString("content"));
        iframe.findElement(By.id("tinymce")).sendKeys(desc);
        //16 | don't forget to change the focus from iframe to the default content

        driver.getDriver().switchTo().defaultContent();
        driver.click(By.cssSelector("button[name='add']"));

        return this;

    }

    public CreateTicketPage createATicket( ){
//        MyTestDriver test_driver = new MyTestDriver(driver);
//        TestElement assistance = test_driver.findElement(By.xpath("//*[@title= 'Assistance']"));
        driver.click( By.cssSelector(".navbar-toggler-icon") );
        driver.click( By.xpath("//*[@title= 'Assistance']") );
//        test_driver.click( By.cssSelector(".show > .menu-label") );
        driver.click(By.cssSelector("a[title= 'Cr\u00E9er un ticket']"));

        return new CreateTicketPage(driver);


    }

}
