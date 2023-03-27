package tests;
import helpers.MyTestDriver;
import helpers.TestDriver;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.sql.Driver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TestImplementation {

    private static final String TEST_USER = "kamkam";
    private static final String TEST_PASSWORD = "Alwaysdata@123";
//    private static final String TEST_USER = "admin";
//    private static final String TEST_PASSWORD = "#g9eYkRd9dYHFeXiaof987";


    private WebDriver driver;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // for Firefox 
        // System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        // for Firefox
        // driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginToGlpi() throws InterruptedException {

        // Test name: Glpi_Ticket

        // 1 | open | /glpi_10_0_6/index.php |
        driver.get("http://kamkam.infinityfreeapp.com/glpi_10_0_6/index.php");
        // 2 | setWindowSize | 974x1040 |
        driver.manage().window().setSize(new Dimension(974, 1040));
        // 3 | click | id=login_name |
        driver.findElement(By.id("login_name")).click();
        // 4 | type | id=login_name | kamkam
        driver.findElement(By.id("login_name")).sendKeys("kamkam");
        // 5 | click | name=fieldb6412edb15732d |
        driver.findElement(By.cssSelector("input[type= 'password']")).click();
        // 6 | type | name=fieldb6412edb15732d | Alwaysdata@123
        driver.findElement(By.cssSelector("input[type= 'password']")).sendKeys("Alwaysdata@123");
        // 7 | click | name=submit |
        driver.findElement(By.name("submit")).click();
        // mettre a jour mon driver
        driver.get("http://kamkam.infinityfreeapp.com/glpi_10_0_6/front/central.php");

        // 10 | click | css=.navbar-toggler-icon |
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        // 11 | click | css=.navbar-toggler-icon |
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();

        //12 | cliquer sur Assistance
         driver.findElement(By.xpath("//*[@title= 'Assistance']")).click();
        //13 | cliquer sur Creer un ticket
        driver.findElement(By.xpath("//*[@title= 'Cr\u00E9er un ticket']")).click();
//        driver.get("http://kamkam.infinityfreeapp.com/glpi_10_0_6/front/ticket.form.php");
        Thread.sleep(2000);

        // find the title inside the form
//        WebElement form = driver.findElement(By.xpath("//form[@id='itil-form']"));
//        form.findElements(By.xpath("//input[@id='name_871795173']"));
//       Using helpers
//        WebElement ticket_title = driver.findElement(By.xpath("//form[@id='itil-form']/div/div/div/div/div/div[2]/span/div/div[2]/div/div/input"));
//        MyTestDriver titleT  = new MyTestDriver(driver);
//        titleT.scrollToElement( ticket_title );
//        ticket_title.sendKeys("Kamkam Rh");

        //14 | Trouber le titre et envoyer la veleur souhaite
        WebElement title = driver.findElement(By.xpath("//form[@id='itil-form']/div/div/div/div/div/div[2]/span/div/div[2]/div/div/input"));
        title.sendKeys("kamkam RH");

        // Scrolle down to the title's element
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", title);

        //15 | Change the selenium driver to the iframe
        WebDriver iframe  = driver.switchTo().frame(driver.findElement(By.className("tox-edit-area__iframe")));
        iframe.findElement(By.id("tinymce")).sendKeys("Mananger d'equipe veuillez valider la fiche de demande s'il vous plait. \n   Cordialement  \n  Carole Manager RH");
        //16 | don't forget to change the focus from iframe to the default content
        driver.switchTo().defaultContent().findElement(By.cssSelector("button[name='add']")).click();


        Thread.sleep(5000);


//        WebDriverWait wait = new WebDriverWait(driver,1 );
//

//        driver.get("http://kamkam.infinityfreeapp.com/glpi_10_0_6/ajax/fileupload.php");
//        driver.findElement(By.xpath("//div[@id='dropdoc1692614969']/input"));
//        driver.findElement(By.tagName(">input")).sendKeys("file.pdf");

//        driver.findElement(By.xpath("//p[@id='doc_uploader_filename2049626323']/b"));
//        WebElement iframe = driver.findElement(By.className("tox-edit-area__iframe")).findElement(By.id("tinymce")).findElement(By.xpath());
//        WebElement body = (WebElement) iframe.findElements(By.id("tinymce"));
//        body.findElements(By.)
//        WebElement body = (WebElement) iframe.findElements(By.xpath("//body[@id='tinymce']"));
//        System.out.println(iframe);
//        paraghraphe.sendKeys("Description");

//        driver.findElement(By.xpath("//*body[@id='tinymce']/p"));




//        WebElement ticket = driver.findElement(By.xpath("//*[@id='name_1807603398']"));
//        WebElement ticket = driver.findElement(By.cssSelector("#name_1807603398"));

//        WebElement formControl = driver.findElement(By.cssSelector(".form-control "));
//        driver.get("http://kamkam.infinityfreeapp.com/glpi_10_0_6/front/ticket.form.php");
//        WebElement formControl = driver.findElement(By.cssSelector("#name_1807603398"));

//        ticket.sendKeys("tickets Carole");
//        Thread.sleep(1000);
//        WebElement description = driver.findElement(By.id("content_1019081324_ifr"));

//        description.sendKeys("Manager d'equipe veuillez valider la demande svp :");





//          driver.findElement(By.cssSelector("'fa-fw  ti ti-plus'")).click();




        // Arrange
////        driver.get("https://tomavt.with16.glpi-network.cloud/index.php");
//        driver.get("http://kamkam.infinityfreeapp.com/glpi_10_0_6/index.php");
//
//        // Act
//        WebElement loginName = driver.findElement(By.id("login_name"));
//        loginName.click();
//        loginName.sendKeys(TEST_USER);
//
//        WebElement passwd = driver.findElement(By.cssSelector("input[type='password']"));
//        passwd .click();
//        passwd .sendKeys(TEST_PASSWORD);
//
//        WebElement loginButton = driver.findElement(By.cssSelector("button[name='submit']"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].scrollIntoView(true);", loginButton);
//        loginButton.click();
//
//        // Go to Assistance drop down list'
////        driver.findElement(By.className("css=navbar-menav-link dropdown-toggle show")).click();
//
//        // Assert
////        String HOME_URL = "https://tomavt.with16.glpi-network.cloud/front/central.php";
//        String HOME_URL = "http://kamkam.infinityfreeapp.com/glpi_10_0_6/front/central.php";
//
//        assertEquals("The home page is expected",
//                HOME_URL,
//                driver.getCurrentUrl());
    }

}
