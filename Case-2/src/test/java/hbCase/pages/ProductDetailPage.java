package hbCase.pages;

import hbCase.utils.Driver;
import hbCase.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailPage extends Helper {
    public ProductDetailPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    public int numberOfComments;
    @FindBy(css = ".product-comments")
    public WebElement goToCommentsSection;
    @FindBy(id = "productReviewsTab")
    public WebElement numberOfEvaluation;
    @FindBy(css = ".thumbsUp")
    public List<WebElement> comments;
    @FindBy(xpath = "//span[contains(@class,'hermes-ReviewCard-module') and text()='Teşekkür Ederiz.']")
    public List<WebElement> thankYouMessage;

    public void goToCommentsSection() {
        switchLastTab();
        numberOfComments = Integer.parseInt(numberOfEvaluation.getText().replaceAll("\\D+",""));

        if (numberOfComments > 0) {
            clickElement(goToCommentsSection);
        }
    }
    public void clickFirstCommentYesButton() {
        if (numberOfComments > 0) {
            scrollIntoView(comments.get(0));
            clickElement(comments.get(0));
        }
    }
    public void verifyThankYouMessage() {
        if (numberOfComments > 0) {
            Assert.assertTrue(isDisplayed(thankYouMessage.get(0)));
        }
    }
}
