package tests;

import models.User;
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
    @Test
    public void registrationSuccess2()
    {

        int i = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User().setEmail("Ttest"+i+"@gmail.com").setPassword("Ttest"+i+"$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
    }


}
