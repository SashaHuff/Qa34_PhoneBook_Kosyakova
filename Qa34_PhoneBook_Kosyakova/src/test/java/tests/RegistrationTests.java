package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase
{
    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }

    }
    @Test
    public void registrationSuccess()
    {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("Test1278@gmail.com","Ttest1278$");
        app.getHelperUser().submitRegistration();
    }
}
