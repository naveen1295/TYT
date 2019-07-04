@inProgress
Feature: Attach File to Story Feature
    Verify if user is able to attach a file to story
    
@adminUserLoggedIn
    Scenario: Attach a file to a story
        Given I am in the dashboard page
        When I try to attach a file to a story "Test"
        Then the story should be updated with the attachment