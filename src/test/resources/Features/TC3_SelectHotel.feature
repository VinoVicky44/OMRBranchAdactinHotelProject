@SelectHotel
Feature: Verifying Adactin select hotels functionality

  Background: 
    Given User is on the adactin login page

  @WithHotel
  Scenario Outline: Verifying Adactin select hotel functionality
    When User should perform login "<userName>" , "<password>"
    Then User should verify the login sucessfuly "Hello vinothkumar008!"
    And User should perform search hotel "<loactions>","<hotels>","<roomType>","<roomNo>","<chekInDate>","<checkOuDate>","<adultsRoomNo>" and "<childRoomNo>"
    Then User should verify the message after clicking search "Select Hotel"
    And User should perform select hotel
    Then User should verify the message after clicking continue "Book A Hotel"

    Examples: 
      | userName       | password  | loactions | hotels         | roomType | roomNo  | chekInDate | checkOuDate | adultsRoomNo | childRoomNo |
      | vinothkumar008 | Vino@0440 | Sydney    | Hotel Sunshine | Deluxe   | 1 - One | 18/07/2022 | 19/07/2022  | 1 - One      | 1 - One     |

  @WithoutHotel
  Scenario Outline: Verifying Adactin select hotel functionality without selecting hotel
    When User should perform login "<userName>" , "<password>"
    Then User should verify the login sucessfuly "Hello vinothkumar008!"
    And User should perform search hotel "<loactions>","<hotels>","<roomType>","<roomNo>","<chekInDate>","<checkOuDate>","<adultsRoomNo>" and "<childRoomNo>"
    Then User should verify the message after clicking search "Select Hotel"
    And User should perform continue without selecting any hotels
    Then User should verify the error message in select hotel "Please Select a Hotel"

    Examples: 
      | userName       | password  | loactions | hotels         | roomType | roomNo  | chekInDate | checkOuDate | adultsRoomNo | childRoomNo |
      | vinothkumar008 | Vino@0440 | Sydney    | Hotel Sunshine | Deluxe   | 1 - One | 18/07/2022 | 19/07/2022  | 1 - One      | 1 - One     |
