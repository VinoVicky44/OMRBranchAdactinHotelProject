@SearchHotel
Feature: Verifying Adactin search hotels functionality

  Background: 
    Given User is on the adactin login page

  @AllFields
  Scenario Outline: Verifying Adactin search hotel functionality by selecting all fields
    When User should perform login "<userName>" , "<password>"
    Then User should verify the login sucessfuly "Hello vinothkumar008!"
    And User should perform search hotel "<loactions>","<hotels>","<roomType>","<roomNo>","<chekInDate>","<checkOuDate>","<adultsRoomNo>" and "<childRoomNo>"
    Then User should verify the message after clicking search "Select Hotel"

    Examples: 
      | userName       | password  | loactions | hotels         | roomType | roomNo  | chekInDate | checkOuDate | adultsRoomNo | childRoomNo |
      | vinothkumar008 | Vino@0440 | Sydney    | Hotel Sunshine | Deluxe   | 1 - One | 19/07/2022 | 28/07/2022  | 1 - One      | 1 - One     |

  @MandFields
  Scenario Outline: Verifying Adactin search hotel functionality by selecting only the mandatory fields
    When User should perform login "<userName>" , "<password>"
    Then User should verify the login sucessfuly "Hello vinothkumar008!"
    And User should select only the mandatory fields "<loactions>","<roomNo>","<chekInDate>","<checkOuDate>" and "<adultsRoomNo>"
    Then User should verify the message after clicking search "Select Hotel"

    Examples: 
      | userName       | password  | loactions | roomNo  | chekInDate | checkOuDate | adultsRoomNo |
      | vinothkumar008 | Vino@0440 | Sydney    | 1 - One | 19/07/2022 | 27/07/2022  | 1 - One      |

  @DateFields
  Scenario Outline: Verifying Adactin search hotel functionality by changing checkout date before than the checkin date
    When User should perform login "<userName>" , "<password>"
    Then User should verify the login sucessfuly "Hello vinothkumar008!"
    And User should perform search hotel "<loactions>","<hotels>","<roomType>","<roomNo>","<chekInDate>","<checkOuDate>","<adultsRoomNo>" and "<childRoomNo>"
    Then User should verify the error message after clicking search in search hotel "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName       | password  | loactions | hotels         | roomType | roomNo  | chekInDate | checkOuDate | adultsRoomNo | childRoomNo |
      | vinothkumar008 | Vino@0440 | Sydney    | Hotel Sunshine | Deluxe   | 1 - One | 19/07/2022 | 18/07/2022  | 1 - One      | 1 - One     |

  @WithoutField
  Scenario Outline: Verifying Adactin search hotel functionality by without selecting any fields
    When User should perform login "<userName>" , "<password>"
    Then User should verify the login sucessfuly "Hello vinothkumar008!"
    And User should perform search hotel without fields
    Then User should verify the error message after clicking search in search hotel "Please Select a Location"

    Examples: 
      | userName       | password  |
      | vinothkumar008 | Vino@0440 |
