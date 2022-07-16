package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager
{
    WebDriver wd;
    HelperUser helperUser; // 1
    HelperContact helperContact;

    public void init()
    {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        helperUser = new HelperUser(wd); // 2
        helperContact = new HelperContact(wd);
    }

    public void stop()
    {
        wd.quit();
    }
        // 3
    public HelperUser getHelperUser()
    {
        return helperUser;
    }
    public HelperContact getHelperContact()
    {
        return helperContact;
    }
}
