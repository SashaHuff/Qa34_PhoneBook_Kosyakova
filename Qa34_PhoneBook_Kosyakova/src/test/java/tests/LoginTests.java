package tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    // success login :
    @Test
    public void successLogin() {

        WebDriver wd;

        // 3.open form
        openLoginRegistrationForm();
        // 4.fill form + valid data
        fillLoginRegistrationForm("Test123@gmail.com","Ttest123$");
        // 5.submit login
        submitLogin();
        // 6.Assert ( is login success?)   logout present?PRESENT

    }
    // login negative
    @Test
    public void loginNegativeTestsWrongEmail() {

        // 3.open form
        openLoginRegistrationForm();
        // 4.fill form + invalid data
        fillLoginRegistrationForm("Test123gmail.com","Ttest123$");
        // 5.submit login
        submitLogin();
        // 6.Assert ( is login unsuccessful?)   logout present? NOT

    }
}
