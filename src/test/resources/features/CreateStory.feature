@inProgress
Feature: Create Story Feature
    Verify if user is able to create story
@adminUserLoggedIn
    Scenario: Create a new story
        Given I am in the dashboard page
        When I try to create a new story "Test"
        Then the story "Test" should be displayed in the dashboard
