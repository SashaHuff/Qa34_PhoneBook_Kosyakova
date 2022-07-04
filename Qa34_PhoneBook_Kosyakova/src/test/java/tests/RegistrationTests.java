package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase
{
    @Test
    public void registrationSuccess()
    {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("Test1234@gmail.com","Ttest1234$");
        app.getHelperUser().submitRegistration();
    }
}
