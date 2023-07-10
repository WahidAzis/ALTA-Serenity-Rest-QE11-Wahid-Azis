Feature: POST Register User - API Automation Testing ALTA QE-11
  @Tugas @Positive-Case
  Scenario: Register new user with valid json should success then return 200 response code
    Given Register new user with valid json
    When Send post register user
    Then Status code should be 200 OK
    And Response body token exist
    And Validate successful post register user json schema

  @Tugas @Positive-Case
  Scenario:  Register new user without request body password should failed then return 400 response code
    Given Register new user without request body password
    When Send post register user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing password"
    And Validate unsuccessful post register user json schema

  @Tugas @Positive-Case
  Scenario:  Register new user without request body email should failed then return 400 response code
    Given Register new user without request body email
    When Send post register user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing email or username"
    And Validate unsuccessful post register user json schema

  @Tugas @Positive-Case
  Scenario:  Register new user empty request body should failed then return 400 response code
    Given Register new user empty request body
    When Send post register user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing email or username"
    And Validate unsuccessful post register user json schema

  @Tugas @Negative-Case
  Scenario: Register new user with invalid format email should failed then return 400 response code
    Given Register new user with invalid format email
    When Send post register user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Register new user with invalid password should failed then return 400 response code
    Given Register new user with invalid password
    When Send post register user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Register new user with invalid email and password should failed then return 400 response code
    Given Register new user with invalid email and password
    When Send post register user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Register new user with empty password should failed then return 400 response code
    Given Register new user with empty password
    When Send post register user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Register new user with empty email should failed then return 400 response code
    Given Register new user with empty email
    When Send post register user
    Then Status code should be 400 Bad Request

