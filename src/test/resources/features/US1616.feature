Feature: Joint Applicant Feature
    Verify if Quote is sent with joint applicant when the join applicant checkbox is enabled
    
    Scenario: Create Quote with joint applicant checked and only 1 individual applicant
        Given I as a admin user navigate to Home page
        When I try to login with username "Admin" and password "Admin1234"
        Then I am logged in successfully


     Scenario: Create Quote withnot joint applicant checked and adding 2 individual applicant
        Given I as a admin user navigate to Home page
        When I try to login with username "Admin1" and password "Admin1234"
        Then I am given an error message
        
     Scenario: Create Quote with joint applicant and delete the joint applicant before recalculate
        Given I as a admin user navigate to Home page
        When I try to login with username "Admin1" and password "Admin1234"
        Then I am given an error message
        
     Scenario: Create Quote with 2 joint applicants and delete 1 joint applicant before recalculate
        Given I as a admin user navigate to Home page
        When I try to login with username "Admin1" and password "Admin1234"
        Then I am given an error message
