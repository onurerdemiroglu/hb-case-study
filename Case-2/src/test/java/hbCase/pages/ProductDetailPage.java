package hbCase.pages;

import hbCase.utils.Driver;
import hbCase.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hbCase.utils.Log4j;

import java.util.List;

import static org.junit.Assume.*;

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
        numberOfComments = Integer.parseInt(numberOfEvaluation.getText().replaceAll("\\D+", ""));

        if (numberOfComments > 0) {
            clickElement(goToCommentsSection);
            Log4j.info("Going to the Evaluation section.");
        } else {
            Log4j.info("The step was skipped because no evaluation was found.");
            assumeTrue("The step was skipped because no evaluation was found.", false);
        }
    }

    public void clickFirstCommentYesButton() {
        scrollIntoView(comments.get(0));
        clickElement(comments.get(0));
        Log4j.info("The confirmation button of the first evaluation was clicked.");
    }

    public void verifyThankYouMessage() {
        Assert.assertTrue(isDisplayed(thankYouMessage.get(0)));
        Log4j.info("I saw the 'Tesekkur Ederiz.' notification.");
    }
}
