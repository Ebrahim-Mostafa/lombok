package Pages;

import BasePackage.BasePage;
import Utilities.JSUtils;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

@Data
public class contactUs extends BasePage {

    SoftAssert softAssert = new SoftAssert();
    
    public void openContactUsForm() {
        //Open Contact Form
        WebElement contactUsBtn = ObjectRepositoryJsonParser.getObjectLocator("$.homePageMenu.contactUsBtn");
        JSUtils.scrollIntoView(contactUsBtn);
        JSUtils.clickElementByJS(contactUsBtn);
        TimeUtils.mediumWait();
    }

    public void fillAllData(String userName,String userEmail,String userMobile,String userSubject,String userMessage) {
        //Fill all data but enter invalid email
        WebElement name = ObjectRepositoryJsonParser.getObjectLocator("$.contactUsForm.nameTextBox");
        elementClear(name);
        elementClick(name);
        elementSendKeys(name,userName);

        WebElement email = ObjectRepositoryJsonParser.getObjectLocator("$.contactUsForm.emailTextBox");
        elementClear(email);
        elementClick(email);
        elementSendKeys(email,userEmail);

        WebElement mobile = ObjectRepositoryJsonParser.getObjectLocator("$.contactUsForm.mobileTextBox");
        elementClear(mobile);
        elementClick(mobile);
        elementSendKeys(mobile,userMobile);

        WebElement subject = ObjectRepositoryJsonParser.getObjectLocator("$.contactUsForm.subjectTextBox");
        elementClear(subject);
        elementClick(subject);
        elementSendKeys(subject,userSubject);

        WebElement message = ObjectRepositoryJsonParser.getObjectLocator("$.contactUsForm.messagesTextBox");
        elementClear(message);
        elementClick(message);
        elementSendKeys(message,userMessage);

    }

    public void clickSend() {
        //Click on Send Button
        WebElement sendBtn = ObjectRepositoryJsonParser.getObjectLocator("$.contactUsForm.sendBtn");
        elementClick(sendBtn);
    }

    public void verifyInvalidEmailError() {
        //Verify that error message appear
        WebElement emailError = ObjectRepositoryJsonParser.getObjectLocator("$.contactUsForm.emailError");
        String invalidEmailErrorTxt = emailError.getText();
        softAssert.assertTrue(elementIsDisplayed(emailError));
        System.out.println(invalidEmailErrorTxt);
        softAssert.assertEquals(invalidEmailErrorTxt, "The e-mail address entered is invalid.",
                "Invalid Email Error Message is incorrect");
        softAssert.assertAll();
    }

}