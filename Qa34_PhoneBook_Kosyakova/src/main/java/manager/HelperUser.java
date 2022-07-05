package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
        loginTab.click();
    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[1]")).click();
    }

    public void submitRegistration() {
        wd.findElement(By.xpath("//button[2]")).click();
    }

    public void fillLoginRegistrationForm(User user)
    {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }
    public void fillLoginRegistrationForm(String email, String password) {

        // find +click+clear+sendKey
        type(By.xpath("//input[1]"), email);

        // find +click+clear+sendKey
        type(By.xpath("//input[2]"), password);
    }

    public boolean isLogged() {
        // sign out present? --> logged
        List<WebElement > list =wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size()>0;
    }

    public void logOut() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertDisplayed() {

        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        if (alert == null)
        {
            return false;
        }
        return true;
    }

    public boolean isErrorFormatDisplayed()
    {
        Alert alert = wd.switchTo().alert();
        String errorText = alert.getText();
        System.out.println(errorText);
        alert.accept();

 //       alert.getText(); /// if we want read text
 //       alert.sendKeys("Hello world"); // type text
 //       alert.accept(); // click OK BUTTON
 //       alert.dismiss(); // click CANCEL button
        return errorText.contains("Wrong email or password format"); //equals - full text of alert
    }
}
