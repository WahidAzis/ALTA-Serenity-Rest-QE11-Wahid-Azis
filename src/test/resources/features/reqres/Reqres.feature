Feature: API Automation Testing ALTA QE Batch 11
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    And Print if status code 200 OK
    And Get log body
    And Get log all
    Examples:
     | page |
     | 1    |
     | 2    |

  @Latihan
  Scenario: Post create new user with valid JSON
    Given Post create new user with valid json
    When Send post create user
    Then Status code should be 201 created
    And Response body name was "Wahid" and job was "CEO"

  @Latihan
 Scenario Outline: Put update user with valid parameter id and JSON
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body name was "Wahid Abdul Azis Edit" and job was "QA Engineer Edit"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Latihan
 Scenario Outline: Delete user with valid parameter id
      Given Delete user with valid id <id>
      When Send request delete user
      Then Status code should be 204 No Content
      Examples:
        | id |
        | 1  |
        | 2  |
        | 3  |