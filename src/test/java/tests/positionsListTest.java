package tests;

import BasePackage.BaseTest;
import Pages.joinUsSection;
import Pages.positionsList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class positionsListTest extends BaseTest {

    private static positionsList positionsList;

    @BeforeClass
    public void initialization() {
        positionsList = new positionsList();
    }


    @Test(priority = 4)
    public void positionsList() {
        positionsList.joinUsSectionPage();
        positionsList.filterBySofiaLocation();
        positionsList.filterBySkopjeLocation();
    }
}