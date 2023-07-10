Feature: GET List User - API Automation Testing ALTA QE-11
  @Tugas @Positive-Case
  Scenario Outline: Get List Users with valid parameter should success then return 200 response code
    Given Get list <page> as valid parameter page
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas @Negative-Case
  Scenario Outline: Get List Users with beyond parameter should failed then return 404 response code
    Given Get list <page> as beyond parameter page
    When Send request get list users
    Then Status code should be 404 Not Found
    Examples:
      | page |
      | 3    |

  @Tugas @Negative-Case
  Scenario Outline: Get List Users with invalid parameters should failed then return 400 response code
    Given Get list "<invalidParams>" as invalid parameters
    When Send request get list users
    Then Status code should be 400 Bad Request
    Examples:
      | invalidParams |
      | zzzLapet      |
      | @/-%$         |

  @Tugas @Negative-Case
  Scenario: Get List Users with empty parameter should failed then return 400 response code
    Given Get list with empty parameter
    When Send request get list users
    Then Status code should be 400 Bad Request