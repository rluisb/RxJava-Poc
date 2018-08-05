Feature:
  As an User
  I want to be able to audit payment transactions

  Scenario: emmit event to Audit stream
    Given a running app
    When emmit some event
    Then audit stream should be aware of it

  Scenario: not emmit event to Audit stream
    Given a running app
    When no event is emmited
    Then audit stream should receive anything
