Feature: Invitation Management
  Allows initiating and receiving connection requests between partners.

  @manual
  @manual-result:passed
  Scenario: Send connection invitation
    Given partner is "BPA2"
    When I create a connection invitation
    Then the response code should be 200
    
  @manual
  @manual-result:passed
  Scenario: Receive connection invitation
    Given partner is "BPA2"
    When I receive a connection invitation
    Then the response should contain an invitation URI

  @manual
  Scenario: Accept connection invitation
    Given I received a connection invitation
    When I accept the connection invitation
    Then the response code should be 200

 @manual
  Scenario: Reject connection invitation
    Given I received a connection invitation
    When I reject the connection invitation
    Then the response code should be 200
