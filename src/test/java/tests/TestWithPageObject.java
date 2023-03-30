package tests;

import helpers.Helpers;
import helpers.MyTestDriver;
import helpers.TestDriver;
import helpers.TestElement;
//import org.json.JSONObject;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import pages.CreerPageTicket;
import pages.GlpiPageObject;
import pages.HomePage;
import pages.LoginPage;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
//https://www.jetbrains.com/help/idea/work-with-gradle-dependency-diagram.html#gradle_generate
public class TestWithPageObject {

    //    private static final String TEST_USER = "admin";
//    private static final String TEST_PASSWORD = "#g9eYkRd9dYHFeXiaof987";\
    //Pour creer un nouneau ticket on faire passer son json object dans la methode defini
    private static final JSONObject ticketObj = new JSONObject()
            .put("titre", "Kamkam RH")
            .put("content","Mananger d'equipe veuillez valider la fiche de demande s'il vous plait. \n   Cordialement  \n  Carole Manager RH");
    private static final String TEST_USER = "glpi";
    private static final String TEST_PASSWORD = "glpi";
    //    private HomePage page = null;
    private CreerPageTicket page = null;
    private ChromeDriver driver = null;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        Optional.ofNullable(page).map(GlpiPageObject::close);
    }

    @Test
    public void testLoginToGlpi() throws InterruptedException {
        // Arrange - nothing
        System.out.println(ticketObj);
        // Act

        this.page = new LoginPage(new MyTestDriver(driver))
                .gotoPage()
                .setUser(TEST_USER)
                .setPassword(TEST_PASSWORD)
                .clickLoginButton()
                .creerUnTicket();
        Thread.sleep(5000);//wait until the web element be available
        this.page.saisirTitreDescrip( ticketObj);
//                Thread.sleep(2000);


        //
        // Assert
        assertEquals(
                "The ticket's page is expected",
                page.getExpectedUrl(),
                page.getCurrentUrl()
        );
//        assertEquals(ticktId, ticket_id_existsInTicketsList);
    }
}
