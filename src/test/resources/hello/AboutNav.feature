# Created by andrewevans at 20/08/2017
Feature: About page exists
  # Enter feature description here

  Scenario: I want to navigate to the about page
    Given I want to go to the about page
    When I click the nav about button
    Then I should be on the about page