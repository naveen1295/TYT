Feature: Joint Applicant Feature
    Verify if Quote is sent with joint applicant when the join applicant checkbox is enabled
    
    Scenario: Create Quote with joint applicant checked and only 1 individual applicant
        Given I as a admin user navigate to "stg2" Home page
        When I try to login with username "joshua_ndc" and password "Pega123!"
        Then I am logged in successfully