Feature: Infrastructure
  Ensures that hosting infrastructure is up and running.

  @infrastructure
  @bpa
  Scenario: Check BPA health
    Given instance name is <instance name>
    When I open the BPA health end point
    Then the status should be "OK"
    Examples:
      | instance name |
      | test          |
      | pentest1      |
      | pentest2      |
    
  @infrastructure
  @acapy
  Scenario: Check ACApy health
    Given instance name is <instance name>
    When I open the ACApy health end point
    Then the status should be "OK"
    Examples:
      | instance name |
      | test          |
      | pentest1      |
      | pentest2      |

  @infrastructure
  @tails
  Scenario: Check Tails health
    Given instance name is tails
    When I open the Tails health end point
    Then the status should be "OK"

  @infrastructure
  @manual
  @manual-result:passed
  Scenario: Check DEV deployment
    Given I can access the Azure subscription "bosch-iob-pau-ssi"
    When I accept the connection invitation
    Then the response code should be 200

