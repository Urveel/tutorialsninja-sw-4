package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By MyAccountLink= (By.xpath("//a[@title='My Account']"));
    By selectLogOut = (By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
    By AccountLogoutText = (By.xpath("//h1[normalize-space()='Account Logout']"));
    By ReturningCustomerText =(By.xpath("//h2[contains(text(),'Returning Customer')]"));
    By EmailField = (By.xpath("//input[@id='input-email']"));
    By PasswordField = (By.xpath("//input[@id='input-password']"));
    By LoginButton = (By.xpath("//input[@value='Login']"));
    By MyAccountText =(By.xpath("//h2[contains(text(),'My Account')]"));
    By ContinueButton = (By.xpath("//a[contains(text(),'Continue')]"));

    public void clickOnMyAccountLink(){
        clickOnElement(MyAccountLink);
    }
    public void selectLogout(){
        mouseHoverToElementAndClick(selectLogOut);
    }
    public void verifyAccountLogoutText(String expected,String text){
        assertVerifyText(AccountLogoutText,expected,text);
    }
    public void verifyReturningCustomerText(String expected,String text){
        assertVerifyText(ReturningCustomerText,expected,text);
    }
    public void enterEmail(String text){
        sendTextToElement( EmailField,text);
    }
    public void enterPassword(String text){
        sendTextToElement(PasswordField,text);
    }
    public void clickOnLoginButton(){
        clickOnElement(LoginButton);
    }
    public void verifyMyAccountText(String expected,String text){
        assertVerifyText(MyAccountText,expected,text);
    }
    public void ClickOnContinueButton(){
        clickOnElement(ContinueButton);
    }
}
