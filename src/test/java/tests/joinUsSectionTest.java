package tests;

import BasePackage.BaseTest;
import Pages.joinUsSection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class joinUsSectionTest extends BaseTest {

    private static joinUsSection joinUsSection;

    @BeforeClass
    public void initialization() {
        joinUsSection = new joinUsSection();
    }


    @Test(priority = 3)
    public void joinUsSection() {
        joinUsSection.joinUsSectionPage();
        joinUsSection.filterByLocation();
        joinUsSection.applyPosition();
        joinUsSection.verifyRequiredErrorMessages();
        joinUsSection.verifyInvalidErrorMessages();
    }
}