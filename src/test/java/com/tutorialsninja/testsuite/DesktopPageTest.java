package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.Homepage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopPageTest extends TestBase {
    Homepage homepage = new Homepage();
    DesktopsPage desktopsPage = new DesktopsPage();

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
//1.1 Mouse hover on destops Tab. and Click
        //1.1 Mouse hover on Desktops Tab.and click
        homepage.MouseHoverOnDesktopsTab();
        //1.2 Click on “Show All Desktops”
        homepage.SelectShowAllDesktops();
        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.SelectNameZtoA("Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        desktopsPage.ListDescendingOrder();
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        //2.1 Mouse hover on Desktops Tab. and click
        homepage.MouseHoverOnDesktopsTab();
        //2.2 Click on “Show All Desktops”
        homepage.SelectShowAllDesktops();
        //2.3 Select Sort By position "Name: A to Z"
        desktopsPage.SelectNameAtoZ("Name (A - Z)");
        //2.4 Select product “HP LP3065”
        desktopsPage.clickOnHPLP3065Link();
        //2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = desktopsPage.getHPLP3065text();
        Assert.assertEquals(actualText,expectedText,"HP LP3065 text is not found");
        //2.6 Select Delivery Date "2023-07-09"
        desktopsPage.selectDeliveryDate("2023-07-09");
        //2.7.Enter Qty "1” using Select class.
        desktopsPage.Quantitychange("1");
        //2.8 Click on “Add to Cart” button
        desktopsPage.clickOnAddCartButton();
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!\n×";
        String actualText1 = desktopsPage.getMessagedisplay();
        Assert.assertEquals(actualText1,expectedText1,"Sucess message  is not found");
        //2.10 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingcart();
        //2.11 Verify the text "Shopping Cart"
        String expectedText2 = "Shopping Cart  (1.00kg)";
        String actualText2 = shoppingCartPage.getShoppingcartText();
        Assert.assertEquals(actualText2,expectedText2,"Shopping Cart text is not found");
        //2.12 Verify the Product name "HP LP3065"
        String expectedText3 = "HP LP3065";
        String actualText3 = shoppingCartPage.getProductNameText();
        Assert.assertEquals(actualText3,expectedText3,"HP LP3065 text is not found");
        //2.13 Verify the Delivery Date "2023-07-09"
        String expectedText4 = "Delivery Date:2023-07-09";
        String actualText4 = shoppingCartPage.getDeliveryDateText();
        Assert.assertEquals(actualText3,expectedText3,"Delivery Date:2023-07-09 text is not found");
        //2.14 Verify the Model "Product21"
        String expectedText5 = "Product 21";
        String actualText5 = shoppingCartPage.getProduct21Text();
        Assert.assertEquals(actualText5,expectedText5,"Product 21 text is not found");
        //2.15 Verify the Total "$122.00"
        String expectedText6 = "$122.00";
        String actualText6 = shoppingCartPage.get$122Text();
        Assert.assertEquals(actualText6,expectedText6," Total $122.00 text is not found");

    }
}
