Feature: Login Feature
    Verify if user is able to Login in to the site
    Scenario: Login with valid credentials
        Given I as a admin user navigate to Home page
        When I try to login with username "Admin" and password "Admin1234"
        Then I am logged in successfully


     Scenario: Login with invalid credentials
        Given I as a admin user navigate to Home page
        When I try to login with username "Admin1" and password "Admin1234"
        Then I am given an error message