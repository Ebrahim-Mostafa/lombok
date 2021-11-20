package tests;

import BasePackage.BaseTest;
import Pages.contactUs;
import Utilities.ExcelUtils;
import Utilities.TimeUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;


public class contactUsTest extends BaseTest {

    private static contactUs contactUsObj;

    @BeforeClass
    public void initialization() {
        contactUsObj = new contactUs();
    }

    @DataProvider(name = "DataProviderForUsers")
    public Object[][] usersData() {
        return ExcelUtils.loadTabularData(System.getProperty("user.dir") + File.separator + "testData.xlsx", "ContactUsData");
    }


    @Test(priority = 1, dataProvider="DataProviderForUsers")
    public void contactUsPage(String name,String email,String mobile,String subject,String message) {
        contactUsObj.openContactUsForm();
        contactUsObj.fillAllData(name,email,mobile,subject,message);
        contactUsObj.clickSend();
        TimeUtils.mediumWait();
        contactUsObj.verifyInvalidEmailError();
    }
}