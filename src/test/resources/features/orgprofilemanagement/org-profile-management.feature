Feature: Organization Profile Management
  Manages the public profile information of the organization.

  Scenario: List documents of empty wallet
    When I list all wallet documents
    Then I receive an empty list
    
  Scenario: Add organization profile
    Given There does not exist a document of type "ORGANIZATIONAL_PROFILE_CREDENTIAL" in the wallet 
    When I create a new organization profile
    Then the profile information is stored in the wallet
