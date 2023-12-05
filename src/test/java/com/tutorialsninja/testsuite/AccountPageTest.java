package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.Homepage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountPageTest extends TestBase {
    Homepage homePage = new Homepage();
    RegisterPage registerPage = new RegisterPage();
    AccountPage accountPage = new AccountPage();

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Test"+ toString());
        registerPage.enterLastName("Automode"+ toString());
        registerPage.enterEmailAddress("Testinghv"+ toString());
        registerPage.enterTelephoneNo("07552141254");
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
    }
}

