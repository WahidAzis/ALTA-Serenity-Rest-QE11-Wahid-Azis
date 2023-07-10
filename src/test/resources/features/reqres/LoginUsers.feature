Feature: POST Login User - API Automation Testing ALTA QE-11
  @Tugas @Positive-Case
  Scenario: Login user with valid json should success then return 200 response code
    Given Login user with valid json
    When Send post login user
    Then Status code should be 200 OK
    And Response body token exist for login
    And Validate successful post login user json schema

  @Tugas @Positive-Case
  Scenario:  Login user without request body password should failed then return 400 response code
    Given Login user without request body password
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing password" for login
    And Validate post unsuccessful login user json schema

  @Tugas @Positive-Case
  Scenario:  Login user without request body email should failed then return 400 response code
    Given Login user without request body email
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing email or username" for login
    And Validate post unsuccessful login user json schema

  @Tugas @Positive-Case
  Scenario:  Login user without request body email and password should failed then return 400 response code
    Given Login user without request body email and password
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing email or username" for login
    And Validate post unsuccessful login user json schema

  @Tugas @Negative-Case
  Scenario:  Login for unregistered user should failed then return 404 response code
    Given Login for unregistered user
    When Send post login user
    Then Status code should be 404 Not Found

  @Tugas @NegativeCase
  Scenario: Login user with invalid format email should failed then return 400 response code
    Given Login user with invalid format email
    When Send post login user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Login user with invalid password should failed then return 400 response code
    Given Login user with invalid password
    When Send post login user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Login user with invalid email and password should failed then return 400 response code
    Given Login user with invalid email and password
    When Send post login user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Login user with empty password should failed then return 400 response code
    Given Login user with empty password
    When Send post login user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Login user with empty email should failed then return 400 response code
    Given Login user with empty email
    When Send post login user
    Then Status code should be 400 Bad Request