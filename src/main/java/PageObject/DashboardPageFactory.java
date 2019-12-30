package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DashboardPageFactory
{
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sandeep']")
    public MobileElement dashboard_username;

    @AndroidFindBy(id = "in.okcredit.merchant:id/sort")
    public MobileElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView\n[@text='Latest']")
    public MobileElement latest;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search Customer']")
    public MobileElement searchbar;

}
