package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.Homepage;
import com.tutorialsninja.pages.LaptopAndNotebookPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutPage extends TestBase {
    Homepage homePage = new Homepage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LaptopAndNotebookPage laptopsAndNotebooksPage = new LaptopAndNotebookPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{
        homePage.changeCurrency("£ Pound Sterling");
        homePage.mouseHoverOnLaptopsAndNotebooksTabAndClick();
        homePage.selectShowAllLaptopsAndNotebooksFromDropDown();
        laptopsAndNotebooksPage.selectSortByPrice("Price (High > Low)");
        laptopsAndNotebooksPage.clickOnProductMacBook();
        Assert.assertEquals(laptopsAndNotebooksPage.getProductName(), "MacBook", "MacBook Product not display");
        laptopsAndNotebooksPage.clickOnAddToCartButton();
        Assert.assertTrue(laptopsAndNotebooksPage.getTextToConfirmProductAddedToCart().contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        shoppingCartPage.clickOnShoppingCartLinkInSuccessMessage();
        Assert.assertTrue(shoppingCartPage.getPageNameShoppingCart().contains("Shopping Cart"), "Not navigated to Shopping Cart Page" );
        Assert.assertEquals(shoppingCartPage.confirmMacBkProductName(), "MacBook", "Product name does not match");
        shoppingCartPage.updateQuantityToTwo("2");
        shoppingCartPage.clickToUpdateQty();
        Assert.assertTrue(shoppingCartPage.confirmQtyUpdatedMessage().contains("Success: You have modified your shopping cart!"), "Cart not modified");
        Assert.assertEquals(shoppingCartPage.getTheTotalAmount(), "£737.45", "Total does not match");
        shoppingCartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkOutPage.getPageNameCheckout(), "Checkout", "Not navigated to checkout");
        Thread.sleep(2000);
        Assert.assertEquals(checkOutPage.verifyNewCustomerText(), "New Customer", "New Customer text not seen");
        checkOutPage.clickOnGuestCheckoutRadioButton();
        Thread.sleep(2000);
        checkOutPage.clickOnNewCustomerContinueButton();
        checkOutPage.enterFirstName("Testerhv"+ getAlphaNumericString(2));
        checkOutPage.enterLastName("Automater"+ getAlphaNumericString(2));
        checkOutPage.enterEmail("Testerhv"+getAlphaNumericString(2)+ "@gmail.com");
        checkOutPage.enterPhoneNo("07889966541");
        checkOutPage.enterAddressLn1("House 204");
        checkOutPage.enterCity("Manchester");
        checkOutPage.enterPostCode("M12 9AL");
        checkOutPage.selectCountryFromDropDown("United Kingdom");
        checkOutPage.selectRegionFromDropDown("Greater Manchester");
        checkOutPage.clickOnContinueGuestButton();
        checkOutPage.addCommentsAboutYourOrder("Thank You");
        checkOutPage.clickOnTermsAndConditionsCheckBox();
        checkOutPage.clickOnContinueButtonToProceedToPayment();
        Assert.assertEquals(checkOutPage.getPaymentWarningMessage(), "Warning: Payment method required!\n" + "×", "Warning message not displayed");
    }
}
