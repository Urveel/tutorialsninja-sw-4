package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.Homepage;
import com.tutorialsninja.pages.LaptopAndNotebookPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LaptopsAndNotebooksTest extends TestBase {
    Homepage homePage = new Homepage();
    LaptopsAndNotebooksTest laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    MacBookPage macBookPage = new MacBookPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.hoverOnlaptopsAndNotebooksAndClick();
        //1.2 Click on “Show All Laptops & Notebooks
        homePage.callSelectMenuMethodAndClick("Show AllLaptops & Notebooks");
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.clickOnSortByDropDown();
        laptopsAndNotebooksPage.selectPriceHighToLowFromDropdown();
        //1.4 Verify the Product price will arrange in High to Low order.
        laptopsAndNotebooksPage.verifyProductsArrangedByPriceHighToLow();
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.hoverOnlaptopsAndNotebooksAndClick();
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.callSelectMenuMethodAndClick("Show AllLaptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.clickOnSortByDropDown();
        laptopsAndNotebooksPage.selectPriceHighToLowFromDropdown();
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectProductMacBook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(macBookPage.getTextMacBook(), "MacBook", "Error");
        //2.6 Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertEquals(macBookPage.getTextSuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error");
        //2.8 Click on link “shopping cart” display into success message
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        macBookPage.clickLinkShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertEquals(shoppingCartPage.getTextShoppingCart(), "Shopping Cart  (0.00kg)", "Error");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getTextMacBook(), "MacBook", "Error");
        //2.11 Change Quantity "2"
        shoppingCartPage.changeQuantity();
        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTab();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals(shoppingCartPage.getTextMessage(), "Success: You have modified your shopping cart!\n" +
                "×", "Error");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.getTextTotal1(), "$1,204.00", "Error");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(shoppingCartPage.getTextCheckOut(), "Checkout", "Error");
        //2.17 Verify the Text “New Customer”
        // Assert.assertEquals(shoppingCartPage.getTextNewCustomer(),"New Customer","Error");
        //2.18 Click on “Guest Checkout” radio button
        shoppingCartPage.clickOnGuestCheckOutRadio();
        //2.19 Click on “Continue” tab
        shoppingCartPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        shoppingCartPage.fillInMandatoryFields();
        //2.21 Click on “Continue” Button
        shoppingCartPage.clickOnContinueButton1();
        //2.22 Add Comments About your order into text area
        shoppingCartPage.addCommentsAboutOrder();
        //2.23 Check the Terms & Conditions check box
        shoppingCartPage.clickOnTermsAndConditionCheckbox();
        //2.24 Click on “Continue” button
        shoppingCartPage.clickOnContinueButton2();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(shoppingCartPage.getTextWarningMessage(), "Warning: Payment method required!\n" +
                "×", "Error");
    }

}
