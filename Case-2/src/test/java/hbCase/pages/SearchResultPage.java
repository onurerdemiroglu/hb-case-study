package hbCase.pages;

import hbCase.utils.Driver;
import hbCase.utils.Helper;
import hbCase.utils.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends Helper {
    public SearchResultPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = ".productListContent-item")
    public List<WebElement> products;
    public void clickFirstProductFromResult(){
        clickElement(products.get(0));
        Log4j.info("I click on the detail page of the first product in the results.");
    }
}
