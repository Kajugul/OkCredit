import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCode
{
    static AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException
    {
        DesiredCapabilities cab = new DesiredCapabilities();
        cab.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 5 pro");
        cab.setCapability(MobileCapabilityType.UDID, "192.168.1.5:5555");//ab01dcd
        cab.setCapability("platformName", "Android");
        cab.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        cab.setCapability("appPackage", "in.okcredit.merchant");
        cab.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        cab.setCapability("appActivity", "in.okcredit.app.ui.launcher.LauncherActivity");
        cab.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apkFolder/okcredit.apk");
        cab.setCapability(MobileCapabilityType.NO_RESET, "true");
        cab.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 2);
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, cab);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void LaunchDialer() throws Exception
    {

        driver.openNotifications();
        Thread.sleep(2000);
        List<MobileElement> allNotifications = driver.findElements(By.id("android:id/title"));
        for (MobileElement webElement : allNotifications)
        {
            System.out.println(webElement.getText());
            webElement.click();
            System.out.println("no of notifications " + allNotifications.size());
        }

        driver.quit();
        System.out.println("Finish......................................");
    }
}