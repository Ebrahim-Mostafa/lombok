package Pages;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.Set;

import static BasePackage.BaseTest.driver;

public class companySection extends BasePage {

    SoftAssert softAssert = new SoftAssert();

    public void companySectionPage() {

        driver.get("https://www.musala.com/");
        //Click on Company button and verify the URL
        WebElement companyBtn = ObjectRepositoryJsonParser.getObjectLocator("$.homePageMenu.companyBtn");
        JSUtils.clickElementByJS(companyBtn);
        TimeUtils.mediumWait();
        String currentUrl = getPageCurrentURL();
        System.out.println("The Current URL is: " + currentUrl);
        softAssert.assertEquals(currentUrl, "https://www.musala.com/company/", "URL of Company Section not loaded successfully");
    }

    public void leaderShipSection() {
        //Verify LeaderShip Section is displayed
        WebElement leaderShipSection = ObjectRepositoryJsonParser.getObjectLocator("$.companyPage.leaderShipSection");
        boolean leaderShipSectionDisplayed = elementIsDisplayed(leaderShipSection);
        softAssert.assertTrue(leaderShipSectionDisplayed, "Leadership Section not displayed");

        //Verify LeaderShip Text is displayed
        WebElement leaderShipText = ObjectRepositoryJsonParser.getObjectLocator("$.companyPage.leaderShipText");
        boolean leaderShipTextDisplayed = elementIsDisplayed(leaderShipText);
        String leaderShipTxt = leaderShipText.getText();
        softAssert.assertTrue(leaderShipTextDisplayed, "Leadership text not displayed");
        softAssert.assertEquals(leaderShipTxt, "Leadership", "Leadership text is incorrect");
    }

    public void facebookSection() {
        //Click on Facebook Button
        WebElement facebookBtn = ObjectRepositoryJsonParser.getObjectLocator("$.companyPage.facebookBtn");
        elementClick(facebookBtn);

        //Switch to Facebook Page
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
            }
        }

        //Verify FB URL
        TimeUtils.mediumWait();
        String facebookUrl = getPageCurrentURL();
        System.out.println("The Current URL is: " + facebookUrl);
        softAssert.assertEquals(facebookUrl, "https://www.facebook.com/MusalaSoft?fref=ts", "URL of facebook page not loaded successfully");

        //Verify FB Page Name and Image
        WebElement pageName = ObjectRepositoryJsonParser.getObjectLocator("$.facebookPage.pageName");
        boolean pageNameTxtDisplayed = elementIsDisplayed(pageName);
        String pageNameTxt = pageName.getText();
        softAssert.assertTrue(pageNameTxtDisplayed, "Page Name text not displayed");
        softAssert.assertEquals(pageNameTxt, "Musala Soft", "Page Name text is incorrect");

        WebElement pageProfilePicture = ObjectRepositoryJsonParser.getObjectLocator("$.facebookPage.pageProfilePicture");
        boolean pageProfilePictureDisplayed = elementIsDisplayed(pageProfilePicture);
        softAssert.assertTrue(pageProfilePictureDisplayed, "Image not displayed");
        boolean ImagePresent = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete &&" +
                " typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", pageProfilePicture);
        if (!ImagePresent) {
            System.out.println("Image not displayed.");
        } else {
            System.out.println("Image displayed.");
        }
        //Close FB Page
        driver.close();
        //switch to the parent window
        driver.switchTo().window(parent);
        softAssert.assertAll();
    }
}