package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase
{
    @Test
    public void registrationSuccess(){
        openLoginRegistrationForm();
        fillLoginRegistrationForm("Test123@gmail.com","Ttest123$");
        submitRegistration();

    }
}
