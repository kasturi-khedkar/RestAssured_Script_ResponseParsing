Feature: feature to test the response code received from foreign exchange api

  Scenario: validate the response for script and log it on console
    Given api for foreign exchange
    When posted with correct information
    Then validate the response and log it on console
