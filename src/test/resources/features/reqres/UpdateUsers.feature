Feature: PUT Update User - API Automation Testing ALTA QE-11
  @Tugas @Positive-Case
  Scenario Outline: Put update user with valid json and id should success then return 200 response code
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body for update name was "morpheus" and job was "zion resident"
    And Validate put update user json schema
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas @Positive-Case
  Scenario Outline: Put update user with valid json and id and add age should success then return 200 response code
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body for update name was "morpheus" and job was "zion resident"
    And Put update user with age <age>
    Examples:
      | id | age |
      | 1  | 26  |

  @Tugas @Positive-Case
  Scenario Outline: Put update user with valid json and id and add address should success then return 200 response code
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body for update name was "morpheus" and job was "zion resident"
    And Put update user with address "<address>"
    Examples:
      | id | address         |
      | 1  | Zion Street, 12 |

  @Tugas @Negative-Case
  Scenario Outline: Put update user with valid json and invalid id should failed then return 400 response code
    Given Put update user with valid json and invalid id "<id>"
    When Send put update user
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | X  |
      | *  |

  @Tugas @Negative-Case
  Scenario: Put update user with valid json and empty id should failed then return 400 response code
    Given Put update user with valid json and empty id
    When Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Put update user with empty request body and valid id should failed then return 400 response code
    Given Put update user with empty request body and valid id 1
    When Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Put update user with valid id and request body without name should failed then return 400 response code
    Given Put update user with valid id 1 and request body without name
    When Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Put update user with valid id and request body without job should failed then return 400 response code
    Given Put update user with valid id 1 and request body without job
    When Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Put update user with valid id and request body with empty name should failed then return 400 response code
    Given Put update user with valid id 1 and request body with empty name
    When Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Put update user with valid id and request body with empty job should failed then return 400 response code
    Given Put update user with valid id 1 and request body with empty job
    When Send put update user
    Then Status code should be 400 Bad Request