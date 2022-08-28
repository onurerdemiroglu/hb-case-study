package hbCase.pages;

import hbCase.utils.Driver;
import hbCase.utils.Helper;
import hbCase.utils.Log4j;
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

    public void search(String keyword) {
        clickElement(searchBox);
        sendKeysElement(searchBox, keyword);
        Log4j.info(String.format("I type '%s' in the search box.", keyword));
    }

    public void clickSearchBtn() {
        clickElement(searchButton);
        Log4j.info("I click the search button.");
    }
}
