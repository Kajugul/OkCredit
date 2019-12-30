package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddCustomerPageFactory
{
    @AndroidFindBy(id = "in.okcredit.merchant:id/fabAddCustomer")
    public MobileElement addCustomerButton;

    @AndroidFindBy(id = "in.okcredit.merchant:id/input_name")
    public MobileElement customerName;

    @AndroidFindBy(id = "in.okcredit.merchant:id/name_button")
    public MobileElement customerName_okButton;

    @AndroidFindBy(id = "in.okcredit.merchant:id/input_phone")
    public MobileElement customerNumber;

    @AndroidFindBy(id = "in.okcredit.merchant:id/phone_button")
    public MobileElement customerNumber_okButton;

}
