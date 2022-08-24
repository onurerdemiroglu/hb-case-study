Feature: Hepsiburada Case Study

  Background:
    Given navigate to website

  @positive
  Scenario Outline: Successful product comment approval
    Given I search for "<searchKeyword>"
    And   I click the search button
    And   I select a product from the search result and go to the detail page
    And   I go to the comments tab
    When  I click the yes button of the first comment
    Then  I should see 'Teşekkür Ederiz.' message

    Examples:
      | searchKeyword                              |
      | iPhone                                     |
      | Dünyamızı Koruyalım - Havayı Temiz Tutalım |