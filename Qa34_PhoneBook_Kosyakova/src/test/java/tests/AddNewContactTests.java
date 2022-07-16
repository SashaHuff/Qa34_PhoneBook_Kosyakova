package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("Test1234@gmail.com").setPassword("Ttest1234$"));
        }

    }

    @Test (invocationCount = 1)
    public void addNewContactSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact = Contact.builder()
                .name("Snow"+i)
                .lastName("White")
                .email("snowW@mail.com")
                .phone("123123"+i)
                .address("TelAviv")
                .description("The best friend").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact2();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));

        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));


    }
}