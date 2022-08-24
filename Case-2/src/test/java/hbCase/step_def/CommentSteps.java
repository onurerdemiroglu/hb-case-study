package hbCase.step_def;

import hbCase.pages.*;
import hbCase.pages.SearchResultPage;
import hbCase.utils.ConfigReader;
import hbCase.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommentSteps {
    Homepage _homePage = new Homepage();
    SearchResultPage _searchResultPage = new SearchResultPage();
    ProductDetailPage _productDetailPage = new ProductDetailPage();

    @Given("navigate to website")
    public void navigateToWebsite() {
        Driver.get().get(ConfigReader.get("baseUrl"));
    }
    @Given("I search for {string}")
    public void iSearchForKeyword(String keyword) {
        _homePage.Search(keyword);
    }
    @And("I click the search button")
    public void iClickTheSearchButton() {
        _homePage.clickSearchBtn();
    }
    @And("I select a product from the search result and go to the detail page")
    public void iChooseProductFromResultOfTheSearch() { 
        _searchResultPage.clickFirstProductFromResult();
    }
    @And("I go to the comments tab")
    public void iGoToTheCommentsTab() {
        _productDetailPage.goToCommentsSection();
    }
    @When("I click the yes button of the first comment")
    public void iClickTheYesButtonOfTheFirstComment() {
        _productDetailPage.clickFirstCommentYesButton();
    }
    @Then("I should see 'Teşekkür Ederiz.' message")
    public void iShouldSeeMessage() {
        _productDetailPage.verifyThankYouMessage();
    }
}
