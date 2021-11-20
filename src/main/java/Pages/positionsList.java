package Pages;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.List;

import static BasePackage.BaseTest.driver;

public class positionsList extends BasePage {

    SoftAssert softAssert = new SoftAssert();

    public void joinUsSectionPage() {

        driver.get("https://www.musala.com/");
        //Click on Careers button and verify the URL
        WebElement careersBtn = ObjectRepositoryJsonParser.getObjectLocator("$.homePageMenu.careersBtn");
        JSUtils.clickElementByJS(careersBtn);
        WebElement checkOurOpenPositionsBtn = ObjectRepositoryJsonParser.getObjectLocator("$.careersPage.checkOurOpenPositionsBtn");
        elementClick(checkOurOpenPositionsBtn);
        TimeUtils.mediumWait();
        String currentUrl = getPageCurrentURL();
        System.out.println("The Current URL is: " + currentUrl);
        softAssert.assertEquals(currentUrl, "https://www.musala.com/careers/join-us/", "URL of Careers Section not loaded successfully");
    }

    public void filterBySofiaLocation() {
        //Filter by location Sofia
        WebElement locationDDL = ObjectRepositoryJsonParser.getObjectLocator("$.careersPage.locationDDL");
        elementClick(locationDDL);
        WebElement sofiaLocation = ObjectRepositoryJsonParser.getObjectLocator("$.careersPage.sofiaLocation");
        elementClick(sofiaLocation);

        //Get all positions in sofia location
        List<WebElement> openPositions = ObjectRepositoryJsonParser.getObjectLocatorList("$.positionList.openPositions");
        int count = openPositions.size();
        System.out.println("Number of Positions in Sofia location is " + count);
        List<WebElement> positionInfoLink = ObjectRepositoryJsonParser.getObjectLocatorList("$.positionList.positionInfoLink");
        int countLink = positionInfoLink.size();
        System.out.println(countLink);

        System.out.println("Sofia");
        //iterate through list
        Iterator<WebElement> it = openPositions.iterator();
        for (int i = 0; i < openPositions.size(); i++) {

            WebElement position;
            position = it.next();
            String positionTitle = position.getText();
            String[] data = positionTitle.split("\n");
            System.out.println("Position: " + data[0]);

            WebElement ele = positionInfoLink.get(i);
            String url = ele.getAttribute("href");
            System.out.println("More info: " + url);
        }
    }


    public void filterBySkopjeLocation() {

        //Filter by location Skopje
        WebElement locationDDL = ObjectRepositoryJsonParser.getObjectLocator("$.careersPage.locationDDL");
        elementClick(locationDDL);
        WebElement skopjeLocation = ObjectRepositoryJsonParser.getObjectLocator("$.careersPage.skopjeLocation");
        elementClick(skopjeLocation);

        //Get all positions in Skopje location
        List<WebElement> openPositions = ObjectRepositoryJsonParser.getObjectLocatorList("$.positionList.openPositions");
        int count = openPositions.size();
        System.out.println("Number of Positions in Skopje location is " + count);
        List<WebElement> positionInfoLink = ObjectRepositoryJsonParser.getObjectLocatorList("$.positionList.positionInfoLink");
        int countLink = positionInfoLink.size();
        System.out.println(countLink);

        System.out.println("Skopje");
        //iterate through list
        Iterator<WebElement> it = openPositions.iterator();
        for (int i = 0; i < openPositions.size(); i++) {

            WebElement position;
            position = it.next();
            String positionTitle = position.getText();
            String[] data = positionTitle.split("\n");
            System.out.println("Position: " + data[0]);

            WebElement ele = positionInfoLink.get(i);
            String url = ele.getAttribute("href");
            System.out.println("More info: " + url);
        }
    }
}