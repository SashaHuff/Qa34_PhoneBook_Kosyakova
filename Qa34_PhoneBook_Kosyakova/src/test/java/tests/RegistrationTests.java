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
        int i = (int)System.currentTimeMillis()/1000;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("Test"+i+"@gmail.com","Ttest"+i+"$");
        app.getHelperUser().submitRegistration();

    }


}
