Feature: Hepsiburada - Generator Swagger Integration Tests

  Scenario: Generates a client library
    Given I send post request for client library
    Then  I verify status code is 200

  Scenario: Returns options for a client library
    Given I send get request for a client library
    Then  I verify status code is 200
