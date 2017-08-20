# Created by andrewevans at 20/08/2017
Feature: Orders page exists
  # Enter feature description here

  Scenario: I want to navigate to the orders page
    Given I want to go to the orders page
    When I click the Move! about button
    Then I should be on the orders page