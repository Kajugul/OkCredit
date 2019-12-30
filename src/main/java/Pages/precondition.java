package Pages;

import PageObject.preconditionPageFactory;
import Utility.BaseAppiumMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class precondition extends BaseAppiumMethods
{

    public preconditionPageFactory factory = new preconditionPageFactory();

    public precondition(AppiumDriver<MobileElement> driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), factory);
    }

    /**
     * This method is used to select language
     */
    public void selectLanguage()
    {
        if (factory.language.isDisplayed())
        {
            factory.language.click();
        }
        else
        {
            factory.languageNewUI.click();
        }
    }

    public void getStarted()
    {
        factory.started.click();
    }

    /**
     * This method is used to login into application.
     * @param m_number mobile number
     * @param pwd      password
     * @return dashobard class obj.
     */
    public Dashboard login(String m_number, String pwd)
    {
        factory.mobileNumber.sendKeys(m_number);
        factory.OK_number.click();
        factory.pwd.sendKeys(pwd);
        factory.OK_pwd.click();

        return new Dashboard(driver);

    }
}
