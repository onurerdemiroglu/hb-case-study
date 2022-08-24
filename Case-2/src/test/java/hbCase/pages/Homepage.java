package hbCase.pages;

import hbCase.utils.Driver;
import hbCase.utils.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Helper {
    public Homepage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = ".desktopOldAutosuggestTheme-input")
    public WebElement searchBox;
    @FindBy(css = ".SearchBoxOld-buttonContainer")
    public WebElement searchButton;
    public void Search(String text) {
        clickElement(searchBox);
        sendKeysElement(searchBox, text);
    }
    public void clickSearchBtn() {
        clickElement(searchButton);
    }
}
