package Pages;

import PageObject.AddCustomerPageFactory;
import PageObject.DashboardPageFactory;
import Utility.BaseAppiumMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends BaseAppiumMethods
{
    private DashboardPageFactory dashboardPageFactory = new DashboardPageFactory();
    private AddCustomerPageFactory addCustomerPageFactory = new AddCustomerPageFactory();

    public Dashboard(AppiumDriver<MobileElement> driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageFactory);
        PageFactory.initElements(new AppiumFieldDecorator(driver), addCustomerPageFactory);
    }

    /**
     * This method is to verify the, is dashboard page available or not.
     *
     * @return boolean true
     */
    public boolean isThisDashboardPage()
    {
        try
        {
            return dashboardPageFactory.dashboard_username.isDisplayed();
        } catch (Exception e)
        {
            System.out.println("Failure cause : " + e.getCause());
            System.out.println("Message cause : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is used to add customer into okcredit app.
     *
     * @param c_name   customer name
     * @param c_number customer number
     * @return give credit class object.
     */
    public GiveCredit addCustomer(String c_name, String c_number)
    {
        try
        {
            // add and click on ok button.
            addCustomerPageFactory.addCustomerButton.click();
            addCustomerPageFactory.customerName.sendKeys(c_name);
            addCustomerPageFactory.customerName_okButton.click();

            // mobile number and click on ok button
            addCustomerPageFactory.customerNumber.sendKeys(c_number);
            addCustomerPageFactory.customerNumber_okButton.click();

            return new GiveCredit(driver);
        } catch (Exception e)
        {
            System.out.println("Failure cause : " + e.getCause());
            System.out.println("Message cause : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to validate, credit amount on dashboard
     * @param customerName   customer name
     * @param expectedAmonut expected amount
     * @return true if condition meet.
     * @throws InterruptedException
     */
    public boolean validateCreditAmountOnDashboard(String customerName, String expectedAmonut) throws InterruptedException
    {
        if (customerName.equals("") || customerName == "")
        {
            System.out.println("expected customer name is null. please check..");
            return false;
        }

        if (expectedAmonut.equals("") || expectedAmonut == "")
        {
            System.out.println("expected amount is null. please check..");
            return false;
        }

        // fetching the latest transaction record
        dashboardPageFactory.filterButton.click();

        if (dashboardPageFactory.latest.isDisplayed())
        {
            dashboardPageFactory.latest.click();
        }
        else
        {
            System.out.println("Failed to click on Latest menu option...");
        }

        wait(1000);
        dashboardPageFactory.searchbar.sendKeys(customerName);
        wait(1000);
        if (driver.findElement(By.id("in.okcredit.merchant:id/desc")).isDisplayed())
        {

            if (driver.findElement(By.id("in.okcredit.merchant:id/balance")).getText().replace("₹", "").equals(expectedAmonut))
            {
                return true;
            }
            else
            {
                System.out.println("Customer Amount doesn't match.. terminated..");
                return false;
            }
        }
        else
        {
            System.out.println("Customer Name doesn't match.. terminated..");
            return false;
        }
    }
}
