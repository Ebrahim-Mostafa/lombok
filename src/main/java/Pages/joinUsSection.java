package Pages;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static BasePackage.BaseTest.driver;

public class joinUsSection extends BasePage {

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

    public void filterByLocation() {
        //Filter by location Anywhere
        WebElement locationDDL = ObjectRepositoryJsonParser.getObjectLocator("$.careersPage.locationDDL");
        elementClick(locationDDL);
        WebElement anyWhereBtn = ObjectRepositoryJsonParser.getObjectLocator("$.careersPage.anyWhereBtn");
        elementClick(anyWhereBtn);
    }

    public void applyPosition() {
        WebElement position = ObjectRepositoryJsonParser.getObjectLocator("$.careersPage.position");
        elementClick(position);

        //Verify that 4 main sections and apply button are shown
        WebElement generalDescriptionSection = ObjectRepositoryJsonParser.getObjectLocator("$.positionPage.generalDescriptionSection");
        boolean generalDescriptionSectionDisplayed = elementIsDisplayed(generalDescriptionSection);
        String generalDescriptionSectionTxt = generalDescriptionSection.getText();
        softAssert.assertTrue(generalDescriptionSectionDisplayed, "General Description Section not displayed");
        softAssert.assertEquals(generalDescriptionSectionTxt, "General description", "General Description Section text is incorrect");

        WebElement requirementsSection = ObjectRepositoryJsonParser.getObjectLocator("$.positionPage.requirementsSection");
        boolean requirementsSectionDisplayed = elementIsDisplayed(requirementsSection);
        String requirementsSectionTxt = requirementsSection.getText();
        softAssert.assertTrue(requirementsSectionDisplayed, "Requirements Section not displayed");
        softAssert.assertEquals(requirementsSectionTxt, "Requirements", "Requirements Section text is incorrect");

        WebElement responsibilitiesSection = ObjectRepositoryJsonParser.getObjectLocator("$.positionPage.responsibilitiesSection");
        boolean responsibilitiesSectionDisplayed = elementIsDisplayed(responsibilitiesSection);
        String responsibilitiesSectionTxt = responsibilitiesSection.getText();
        softAssert.assertTrue(responsibilitiesSectionDisplayed, "Responsibilities Section not displayed");
        softAssert.assertEquals(responsibilitiesSectionTxt, "Responsibilities", "Responsibilities Section text is incorrect");

        WebElement whatWeOfferSection = ObjectRepositoryJsonParser.getObjectLocator("$.positionPage.whatWeOfferSection");
        boolean whatWeOfferSectionDisplayed = elementIsDisplayed(whatWeOfferSection);
        String whatWeOfferSectionTxt = whatWeOfferSection.getText();
        softAssert.assertTrue(whatWeOfferSectionDisplayed, "What we offer Section not displayed");
        softAssert.assertEquals(whatWeOfferSectionTxt, "What we offer", "What we offer Section text is incorrect");

        WebElement applyBtn = ObjectRepositoryJsonParser.getObjectLocator("$.positionPage.applyBtn");
        boolean applyBtnDisplayed = elementIsDisplayed(applyBtn);
        System.out.println(applyBtn.getText());
        softAssert.assertTrue(applyBtnDisplayed, "Apply Button not displayed");
        TimeUtils.explicitWait(applyBtn, 5);
        JSUtils.clickElementByJS(applyBtn);

        //Upload CV and click on send button
        WebElement uploadFileBtn = ObjectRepositoryJsonParser.getObjectLocator("$.applyForm.uploadFileBtn");
        uploadFileSendKeys(uploadFileBtn, "Amir AlaaElDin-CV.pdf");
        TimeUtils.mediumWait();

        WebElement sendBtn = ObjectRepositoryJsonParser.getObjectLocator("$.applyForm.sendBtn");
        JSUtils.clickElementByJS(sendBtn);
        TimeUtils.shortWait();
    }

    public void verifyRequiredErrorMessages() {

        //Check Multiple Error Messages form and close button
        WebElement errorForm = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.errorForm");
        boolean errorFormDisplayed = elementIsDisplayed(errorForm);
        softAssert.assertTrue(errorFormDisplayed, "Error Form Section not displayed");

        WebElement multipleErrors = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.multipleErrors");
        String multipleErrorsTxt = multipleErrors.getText();
        softAssert.assertEquals(multipleErrorsTxt, "One or more fields have an error. Please check and try again.",
                "Multiple Errors Message is incorrect");

        WebElement closeBtn = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.closeBtn");
        JSUtils.clickElementByJS(closeBtn);

        //Verify Required Error Messages
        WebElement nameError = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.nameError");
        String nameErrorTxt = nameError.getText();
        softAssert.assertEquals(nameErrorTxt, "The field is required.",
                "Name Required Error Message is incorrect");

        WebElement emailError = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.emailError");
        String emailErrorTxt = emailError.getText();
        softAssert.assertEquals(emailErrorTxt, "The field is required.",
                "Email Required Error Message is incorrect");

        WebElement mobileError = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.mobileError");
        String mobileErrorTxt = mobileError.getText();
        softAssert.assertEquals(mobileErrorTxt, "The field is required.",
                "Mobile Required Error Message is incorrect");

        WebElement messageError = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.messageError");
        String messageErrorTxt = messageError.getText();
        softAssert.assertEquals(messageErrorTxt, "The field is required.",
                "Message Required Error Message is incorrect");

        WebElement notARobotError = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.notARobotError");
        String notARobotErrorTxt = notARobotError.getText();
        softAssert.assertEquals(notARobotErrorTxt, "Please verify that you are not a robot.",
                "Not A Robot Error Message is incorrect");
    }

    public void verifyInvalidErrorMessages() {

        //Verify Invalid Scenarios
        WebElement emailTextBox = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.emailTextBox");
        elementSendKeys(emailTextBox, "amir.alaa@gmail");
        WebElement mobileTextBox = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.mobileTextBox");
        elementSendKeys(mobileTextBox, "AmirAlaa");
        TimeUtils.mediumWait();

        WebElement sendBtn = ObjectRepositoryJsonParser.getObjectLocator("$.applyForm.sendBtn");
        TimeUtils.explicitWait(sendBtn, 5);
        JSUtils.clickElementByJS(sendBtn);
        WebElement closeBtn = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.closeBtn");
        JSUtils.clickElementByJS(closeBtn);

        WebElement emailError = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.emailError");
        String invalidEmailErrorTxt = emailError.getText();
        softAssert.assertEquals(invalidEmailErrorTxt, "The e-mail address entered is invalid.",
                "Invalid Email Error Message is incorrect");

        WebElement mobileError = ObjectRepositoryJsonParser.getObjectLocator("$.errorMessages.mobileError");
        String invalidMobileErrorTxt = mobileError.getText();
        softAssert.assertEquals(invalidMobileErrorTxt, "The telephone number is invalid.",
                "Invalid Mobile Error Message is incorrect");

        softAssert.assertAll();
    }
}