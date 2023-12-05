package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {

    By components = By.cssSelector("#content h2");

    public String getTextComponents() {
        return getTextFromElement(components);
    }
}
