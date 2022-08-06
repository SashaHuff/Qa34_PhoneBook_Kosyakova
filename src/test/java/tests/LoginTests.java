package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod (alwaysRun = true)
    public void preCondition() {
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }

    }
    @Test ()
    public void loginSuccess() {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("Test1234@gmail.com", "Ttest1234$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(6000);


    }

    // login negative
    @Test
    public void loginNegativeTestsWrongEmail() {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("Test123gmail.com", "Ttest123$");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorFormatDisplayed());

    }
    @Test
    public void loginSuccessN()
    {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("Test1234@gmail.com","Ttest1234$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(6000);




    }


}
