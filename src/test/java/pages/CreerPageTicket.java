package pages;

import helpers.TestDriver;
import org.openqa.selenium.By;

public class CreerPageTicket extends GlpiPageObject {
    private static final String url_page_ticket = "http://kamkam.infinityfreeapp.com/glpi_10_0_6/front/ticket.form.php";
    protected CreerPageTicket(TestDriver driver) {
        super(driver, url_page_ticket);
    }

    public CreerPageTicket saisirTitre(String titre){
        System.out.println(driver.getCurrentUrl());

        driver.clickAndSendKeys(By.cssSelector("input[name='name']"), titre);
//        test_driver.click(By.xpath("//form[@id='itil-form']/div/div/div/div/div/div[2]/span/div/div[2]/div/div/input"));
        return this;

    }
}
