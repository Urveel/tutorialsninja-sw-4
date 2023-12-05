package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.Homepage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComponentsPageTest extends TestBase {
    Homepage homePage = new Homepage();
    ComponentsPage componentsPage = new ComponentsPage();

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homePage.mouseHoverOnComponentsTabAndClick();
        homePage.selectShowAllComponentsFromDropDown();
        Assert.assertEquals(componentsPage.getPageName(), "Components", "Not navigated to the Components Page");
    }
}
