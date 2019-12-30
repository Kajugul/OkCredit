package Test;

import Pages.AddCustomer;
import Pages.Dashboard;
import Pages.GiveCredit;
import Pages.precondition;
import Utility.Constant;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01 extends initializeAppium
{
    Pages.precondition precondition;
    Dashboard dashboard;
    AddCustomer addCustomer;
    GiveCredit giveCredit;

    @Test(priority = 0, description = "This test cases is for select english language.")
    public void selectLanguage() throws InterruptedException
    {
        logger = extent.createTest("selectLanguage");
        logger.log(Status.INFO, "Selecting the language for oKCredit");
        precondition = new precondition(driver);
        precondition.selectLanguage();
        precondition.getStarted();
        logger.log(Status.INFO, "Lanugage is selected successfully.");
    }

    @Test(priority = 1, description = "Validate that, user can able to login.")
    public void doLogin()
    {
        logger = extent.createTest("doLogin");
        logger.log(Status.INFO, "user is trying to login into application using username [" + Constant.MOBILE_NUMBER + "] and pssword [" + Constant.PASSWORD + "]");
        dashboard = precondition.login(Constant.MOBILE_NUMBER, Constant.PASSWORD);
        Assert.assertNotNull(dashboard, "Dashboard class object found as null.");
        Assert.assertTrue(dashboard.isThisDashboardPage(), "user is failed to login into application, please check credentials.");
        logger.log(Status.INFO, "User is successfully logged-in into application.");
    }

    @Test(priority = 2, description = "This TC will add customer into application", dependsOnMethods = "doLogin")
    public void addCustomer()
    {
        logger = extent.createTest("addCustomer");
        logger.log(Status.INFO, "Please add customer name as [" + Constant.CUSTOMER_NAME + "] " + "and" + " mobile no as [" + Constant.CUSTOMER_MOBILE_NUMBER + "]");
        giveCredit = dashboard.addCustomer(Constant.CUSTOMER_NAME, Constant.CUSTOMER_MOBILE_NUMBER);
        Assert.assertNotNull(giveCredit, "GiveCredit class object found as null.");
        logger.log(Status.INFO, "Customer is added successfully.");
    }

    @Test(priority = 3, description = "This TC will add credit into customer account.", dependsOnMethods = "addCustomer")
    public void addGiveCredit() throws InterruptedException
    {
        logger = extent.createTest("addGiveCredit");
        logger.log(Status.INFO, "Please add credit amount as [" + Constant.CUSTOMER_MOBILE_NUMBER + "]");
        giveCredit.addCredit(Constant.CREDIT_AMOUNT, "Please add [" + Constant.CREDIT_AMOUNT + "] amount into Account.");
        logger.log(Status.INFO, "Credit Amount is added successfully.");
    }

    @Test(priority = 4, description = "This TC will validate the, credit amount into credit page.", dependsOnMethods = "addGiveCredit")
    public void validateCreditAmount() throws InterruptedException
    {
        logger = extent.createTest("validateCreditAmount");
        logger.log(Status.INFO, "Validate the, credit amount as [" + Constant.CREDIT_AMOUNT + "]");
        Assert.assertTrue(giveCredit.validateCreditAmount(Constant.CREDIT_AMOUNT), "Expected Credit Amount: [" + Constant.CREDIT_AMOUNT + "] is not same as actual credit amount.");
        dashboard = giveCredit.clickBack();
        logger.log(Status.INFO, "Validated the, Credit Amount successfully.");
    }

    @Test(priority = 5, description = "This TC will validate the, credited amount into dashboard page.", dependsOnMethods = "validateCreditAmount")
    public void validateCreditAmountOnDashboard() throws InterruptedException
    {
        logger = extent.createTest("validateCreditAmountOnDashboard");
        logger.log(Status.INFO, "Validate that, credit amount as [" + Constant.CREDIT_AMOUNT + "] " + "and customer name as [" + Constant.CUSTOMER_NAME + "]");
        Assert.assertTrue(dashboard.validateCreditAmountOnDashboard(Constant.CUSTOMER_NAME, Constant.CREDIT_AMOUNT), "customer name [" + Constant.CUSTOMER_NAME + "] and credit amount [" + Constant.CREDIT_AMOUNT + "] is not found on displayed page");
    }
}
