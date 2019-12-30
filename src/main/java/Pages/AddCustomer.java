package Pages;

import Utility.BaseAppiumMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer extends BaseAppiumMethods
{
    public AddCustomer(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        PageFactory.initElements(driver, this);
    }
}
