Feature: This is a sample test for AdactIn

  Scenario: Making a successful hotel booking
    Given I want to make a hotel booking through AdactIn
    And I try to search a hotel
    When I select the hotel
    And fill in my details
    Then I see a hotel booking confirmation
    And I logout