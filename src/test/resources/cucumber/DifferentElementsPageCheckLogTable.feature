Feature: Different Elements page check log table

  Scenario: Different Elements page. Check buttons and logs are correct
    Given I open JDI GitHub site
    And I login as user Roman Iovlev
    And I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    When I select checkbox Water with index 0
    And I select checkbox Wind with index 2
    And I select radio Selen with index 3
    And I select 'Yellow' in dropdown
    Then Log rows should contain following values:
      | Water          | true            |
      | Wind           | true            |
      | Selen          | metal           |
      | Yellow         | Colors          |
