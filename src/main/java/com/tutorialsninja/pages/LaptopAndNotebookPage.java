package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LaptopAndNotebookPage extends Utility {

    By returningCustomer = By.xpath("//h2[contains(text(),'Returning Customer')]");
    By emailAddressField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");


    public String verifyLoginPageText(){
        return getTextFromElement(returningCustomer);
    }

    public void enterEmailAddress(String text){
        sendTextToElement(emailAddressField, text);
    }
    public void enterPassword(String text){
        sendTextToElement(passwordField, text);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
}
