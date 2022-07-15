@CancelBooking
Feature: Verifying Adactin Cancel Booking functionality

  Background: 
    Given User is on the adactin login page

  @AutoGenOrderId
  Scenario Outline: Verifying Adactin Cancel Booking functionality
    When User should perform login "<userName>" , "<password>"
    Then User should verify the login sucessfuly "Hello vinothkumar008!"
    And User should perform search hotel "<loactions>","<hotels>","<roomType>","<roomNo>","<chekInDate>","<checkOuDate>","<adultsRoomNo>" and "<childRoomNo>"
    Then User should verify the message after clicking search "Select Hotel"
    And User should perform select hotel
    Then User should verify the message after clicking continue "Book A Hotel"
    And User should perform book hotel"<firstName>","<lastName>"and"<address>"
      | cardNo           | cardType         | expMon   | expYear | cvv  |
      | 9876543214567890 | American Express | August   |    2022 | 5645 |
      | 6876543214567840 | VISA             | November |    2022 | 6543 |
      | 5776543214567894 | Master Card      | December |    2022 | 7890 |
      | 2379543214567894 | Others           | October  |    2022 | 7890 |
    Then User should verify the message after clicking book now "Booking Confirmation"
    And User should perform cancel booking
    Then User should verify the message after cancel booking contains"The booking has been cancelled."

    Examples: 
      | userName       | password  | loactions | hotels         | roomType | roomNo  | chekInDate | checkOuDate | adultsRoomNo | childRoomNo | firstName | lastName | address   |
      | vinothkumar008 | Vino@0440 | Sydney    | Hotel Sunshine | Deluxe   | 1 - One | 17/07/2022 | 18/07/2022  | 1 - One      | 1 - One     | Vinoth    | Kumar    | Tuticorin |

  @ExistingOrderId
  Scenario Outline: Verifying Adactin Cancel Booking functionality by existing order id
    When User should perform login "<userName>" , "<password>"
    And User should perform cancel booking by existing order id "<orderId>"
    Then User should verify the message after cancel booking contains"The booking has been cancelled."

    Examples: 
      | userName       | password  | orderId    |
      | vinothkumar008 | Vino@0440 | T2A9B09082 |
