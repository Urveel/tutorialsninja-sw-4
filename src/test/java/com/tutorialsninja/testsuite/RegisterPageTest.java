package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.Homepage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
    Homepage homePage = new Homepage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(registerPage.verifyTextRegisterAccount(), "Register Account", "Not navigated to Register Page" );
    }

}
