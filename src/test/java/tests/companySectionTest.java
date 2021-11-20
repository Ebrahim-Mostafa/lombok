package tests;

import BasePackage.BaseTest;
import Pages.companySection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class companySectionTest extends BaseTest {

    private static companySection companySection;

    @BeforeClass
    public void initialization() {
        companySection = new companySection();
    }


    @Test(priority = 2)
    public void companySection() {
        companySection.companySectionPage();
        companySection.leaderShipSection();
        companySection.facebookSection();
    }
}