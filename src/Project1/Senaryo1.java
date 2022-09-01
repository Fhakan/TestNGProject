package Project1;

import Utils.GenelWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Senaryo1 extends GenelWebDriver {

    @Test
    void login() {

    Senaryo1_Elements elements = new Senaryo1_Elements(driver);

        elements.logIn.click();
        elements.emailBox.sendKeys("grup22@gmail.com");
        elements.passwordBox.sendKeys("12345622g");

        elements.logInBtn.click();

        Assert.assertTrue(elements.userNameVerify.getText().

    contains("grup22@gmail.com"));
}
    }

