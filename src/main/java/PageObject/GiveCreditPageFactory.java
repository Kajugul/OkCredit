package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GiveCreditPageFactory
{
    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    public MobileElement givecre;

    @AndroidFindBy(xpath = "android.widget.TextView\n[@text='Add Credit']")
    public MobileElement addAmount;

    @AndroidFindBy(id = "in.okcredit.merchant:id/bottom_container_text")
    public MobileElement addNote;

    @AndroidFindBy(id = "in.okcredit.merchant:id/btn_submit")
    public MobileElement creditokbutton;
}
