package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("Test1234@gmail.com").setPassword("Ttest1234$"));
        }

        app.getHelperContact().providerContactData();

    }

    @Test
    public void removeOneContactSuccess(){

        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);


    }

    @Test
    public void removeAllContactsSuccess(){
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperContact().isNoContactsHere());


    }
}