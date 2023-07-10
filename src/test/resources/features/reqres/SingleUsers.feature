Feature: GET Single User - API Automation Testing ALTA QE-11
  @Tugas @Positive-Case
  Scenario Outline: Get Single User with user id should success then return 200 response code
    Given Single user with id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Response body id was <id> and email was "<email>"
    And Validate get single user json schema
    Examples:
      | id | email                  |
      | 1  | george.bluth@reqres.in |
      | 2  | janet.weaver@reqres.in |
      | 3  | emma.wong@reqres.in    |

  @Tugas @Positive-Case
  Scenario Outline: Get Single User with user id should success then return 200 response code
    Given Single user with id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Response body contains <email> <first_name> <last_name> <avatar>
    And Validate get single user json schema
    Examples:
      |id|        email           | first_name  |  last_name  |                 avatar                 |
      |1 |george.bluth@reqres.in  |   George    |    Bluth    |https://reqres.in/img/faces/1-image.jpg |
      |2 |janet.weaver@reqres.in  |   Janet     |    Weaver   |https://reqres.in/img/faces/2-image.jpg |
      |3 |emma.wong@reqres.in     |   Emma      |    Wong     |https://reqres.in/img/faces/3-image.jpg |
      |4 |eve.holt@reqres.in      |   Eve       |    Holt     |https://reqres.in/img/faces/4-image.jpg |
      |5 |charles.morris@reqres.in|   Charles   |    Morris   |https://reqres.in/img/faces/5-image.jpg |

  @Tugas @Positive-Case
  Scenario Outline: Get Single User with unregistered id should failed then return 404 response code
    Given Single user with unregistered id <id>
    When Send request get single user
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 23 |
      | 99 |

  @Tugas @Negative-Case
  Scenario Outline: Get Single User with invalid id should failed then return 400 response code
    Given Single user with invalid id "<id>"
    When Send request get single user
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    | X  |
    | !  |

  @Tugas @Negative-Case
  Scenario: Get Single User with empty id should failed then return 400 response code
    Given Single with empty id
    When Send request get single user
    Then Status code should be 400 Bad Request