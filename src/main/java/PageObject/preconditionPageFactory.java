package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class preconditionPageFactory
{
    @AndroidFindBy(id = "in.okcredit.merchant:id/english")
    public MobileElement language;

    @AndroidFindBy(xpath = "//android.widget.TextView\n[@text='English']")
    public MobileElement languageNewUI;

    @AndroidFindBy(id = "in.okcredit.merchant:id/getStarted")
    public MobileElement started;

    @AndroidFindBy(id = "in.okcredit.merchant:id/mobile")
    public MobileElement mobileNumber;

    @AndroidFindBy(id="in.okcredit.merchant:id/ok")
    public MobileElement OK_number;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    public MobileElement pwd;

    @AndroidFindBy(id="in.okcredit.merchant:id/ok")
    public MobileElement OK_pwd;

}
