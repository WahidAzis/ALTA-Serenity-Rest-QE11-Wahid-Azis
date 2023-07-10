Feature: DELETE User - API Automation Testing ALTA QE-11
  @Tugas @Positive-Case
  Scenario Outline: Delete user with valid parameter id should success then return 204 response code
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @Negative-Case
  Scenario Outline: Delete user with beyond parameter id should failed then return 404 response code
    Given Delete user with beyond parameter id <id>
    When Send request delete user
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 99  |
      | 198 |

  @Tugas @Negative-Case
  Scenario Outline: Delete user with invalid parameter id should failed then return 400 response code
    Given Delete user with invalid parameter id "<id>"
    When Send request delete user
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | X  |
      | !  |

  @Tugas @Negative-Case
  Scenario: Delete user with empty parameter id should failed then return 400 response code
    Given Delete user with empty parameter id
    When Send request delete user
    Then Status code should be 400 Bad Request