Feature: POST Create User - API Automation Testing ALTA QE-11
  @Tugas @Positive-Case
  Scenario: Post create user with valid json should success then return 201 code
  Given Post create new user with valid json
  When Send post create user
  Then Status code should be 201 created
  And Response body name was "Wahid Abdul Azis" and job was "QA Engineer"
  And Validate post create user json schema

  @Tugas @Negative-Case
  Scenario: Post create new user empty request body should failed then return 400 response code
  Given Post create new user without request body
  When Send post create user
  Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Post create new user without job should failed then return 400 response code
  Given Post create new user without job
  When Send post create user
  Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Post create new user without name should failed then return 400 response code
  Given Post create new user without name
  When Send post create user
  Then Status code should be 400 Bad Request