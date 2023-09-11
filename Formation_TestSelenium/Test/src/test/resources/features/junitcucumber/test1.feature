Feature:

  Example: A user logs in on the M2ISign website and sign for the current period
    Given A user goes to "https://sign.m2iformation.fr/signin"
    When He fills in the Email or phone number field with "alexandre.renaud.08@gmail.com"
    Then The field  Email or phone number is fill with "alexandre.renaud.08@gmail.com"
    When He fills in the Pin code field with "39116"
    Then The field Pin code is fill with "39116"
    When He clicks on the login button
    Then He arrives on M2ISign signature page
    When He clicks on the button timesheet
    Then He arrives on the timesheet page
    When He clicks on the current period
    Then The current period is signed
    When He validate and log out
    Then He arrives on the login page
