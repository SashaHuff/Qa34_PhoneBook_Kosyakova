package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager
{
    WebDriver wd;
    HelperUser helperUser; // 1
    HelperContact helperContact;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init()
    {
        wd = new ChromeDriver();
        WebDriverListener webDriverListener = new MyListener();
        wd = new EventFiringDecorator(webDriverListener).decorate(wd);
        logger.info("All test run in chrome browser");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        logger.info("current url ---->"+ wd.getCurrentUrl());
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
