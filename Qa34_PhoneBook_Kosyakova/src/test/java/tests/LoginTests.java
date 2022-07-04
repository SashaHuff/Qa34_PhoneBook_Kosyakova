package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }


    // success login :
    @Test
    public void loginSuccess() {

        // 3.open form
        app.getHelperUser().openLoginRegistrationForm();
        // 4.fill form + valid data
        app.getHelperUser().fillLoginRegistrationForm("Test123@gmail.com", "Ttest123$");
        // 5.submit login
        app.getHelperUser().submitLogin();
        ;
        // 6.Assert ( is login success?)   logout present?PRESENT

    }

    // login negative
    @Test
    public void loginNegativeTestsWrongEmail() { 

        // 3.open form
        app.getHelperUser().openLoginRegistrationForm();
        // 4.fill form + invalid data
        app.getHelperUser().fillLoginRegistrationForm("Test123gmail.com", "Ttest123$");
        // 5.submit login
        app.getHelperUser().submitLogin();
        // 6.Assert ( is login unsuccessful?)   logout present? NOT

    }
}
