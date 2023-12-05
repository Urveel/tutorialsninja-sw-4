package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.Homepage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends TestBase {
    Homepage homePage = new Homepage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    AccountPage accountPage = new AccountPage();

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.clickOnElement(), "Returning Customer", "Not navigated to Login Page" );
    }


    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //first registering new account to check login functionality
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Testinghumsi2");
        registerPage.enterLastName("Sareshw");
        registerPage.enterEmailAddress("Testinghumsi2@gmail.com");
        registerPage.enterTelephoneNo("0789458585");
        registerPage.enterPassword("Password987");
        registerPage.enterConfirmPassword("Password987");
        registerPage.selectRadioButtonToSubscribe("Yes");
        registerPage.clickOnPrivacyPolicyCheckbox();
        registerPage.clickOnContinueToRegister();
        Assert.assertEquals(accountPage.verifyAccountCreatedText(), "Your Account Has Been Created!", "Account created text not displayed");
        accountPage.clickonContinueToNavigateToAccount();
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.verifyAccountLogoutText(), "Account Logout", "Not logged out of the account");
        accountPage.clickonContinueToNavigateToAccount();

        //testing the login functionality
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmailAddress("urveel2@gmail.com");
        loginPage.enterPassword("Password987");
        loginPage.clickOnElement();
        Assert.assertEquals(accountPage.verifyMyAccountPageName(), "My Account", "Not navigated to My account page");
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.verifyAccountLogoutText(), "Account Logout", "Not logged out of the account");
        accountPage.clickonContinueToNavigateToAccount();

    }

}
