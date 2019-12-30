package Utility;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Constant
{
    public static String MOBILE_NUMBER = "8000787739";
    public static String PASSWORD = "123456";
    private static String customer_A_NUMBER;
    private static String randomName;
    private static String amountGenerator;

    static
    {
        // random mobile number generator
        long ss = 100000000 + new Random().nextInt(900000000);
        customer_A_NUMBER = Long.toString(ss);

        // random amount generator
        amountGenerator = String.valueOf(new Random().nextInt(100));

        // random name generator of 4 char.
        randomName = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
    }

    public static String CUSTOMER_NAME = randomName;
    public static String CUSTOMER_MOBILE_NUMBER = "9" + customer_A_NUMBER;
    public static String CREDIT_AMOUNT = amountGenerator;

}
