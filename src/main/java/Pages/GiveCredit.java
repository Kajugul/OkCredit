package Pages;

import PageObject.GiveCreditPageFactory;
import Utility.BaseAppiumMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class GiveCredit extends BaseAppiumMethods
{
    private GiveCreditPageFactory creditPageFactory = new GiveCreditPageFactory();

    public GiveCredit(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), creditPageFactory);
    }

    /**
     * This method is used to add credit into customer account
     * @param amount credit amount
     * @param note note for credit
     * @throws InterruptedException
     */
    public void addCredit(String amount, String note) throws InterruptedException
    {
        wait(1000);
        if (creditPageFactory.givecre.isEnabled())
        {
            creditPageFactory.givecre.click();
        }
        else
        {
            System.out.println("Failed to find give credit button..");
        }

        String[] amnt = amount.split("");

        try
        {
            for (int i = 0; i < amnt.length; i++)
            {
                wait(500);
                driver.findElement(By.xpath("//android.widget.Button\n[@text='" + amnt[i] + "']")).click();
            }

            if (note.length() > 0)
            {
                wait(1000);
                creditPageFactory.addNote.sendKeys(note);
            }
            else
            {
                System.out.println("[" + amount + "] is credited without any notes");
            }

            wait(1000);
            creditPageFactory.creditokbutton.click();

        } catch (Exception e)
        {
            System.out.println("Failure cause : " + e.getCause());
            System.out.println("Message cause : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * this method will validate the customer  amount from the dashboard page.
     * @param expectedAmonut expected amount
     * @return true
     * @throws InterruptedException
     */
    public boolean validateCreditAmount(String expectedAmonut) throws InterruptedException
    {
        if (expectedAmonut.equals("") || expectedAmonut == "")
        {
            System.out.println("expected amount is null. please check..");
            return false;
        }

        wait(1000);
        String actualCreditAmount = driver.findElement(By.xpath("//android.widget.TextView\n[@index='2']")).getText().replace("₹", "");

        if (isEqual(actualCreditAmount, expectedAmonut))
        {
            return true;
        }
        return false;
    }

    /**
     * This method is used to navigate back from current page to dashboard page.
     * @return dashboard class object
     */
    public Dashboard clickBack()
    {
        driver.navigate().back();
        return new Dashboard(driver);
    }

}
