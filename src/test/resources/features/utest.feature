@stories
  Feature: utest
    As a user, I want to sign up at utest webpage with my log information, to access to utest services

  @scenario1
  Scenario Outline:
    Given than the user wants to sign up at utest

    When it enters its log information
      | strFirstName |  strLastName|  strEmail| strBirthDay | strBirthMonth | strBirthYear |  strLanguages| strCity | strZipCode |  strCountry| strOSPC  | strVersionPC    | strLanguagePC   | strMobileDeviceBrand  | strMobileDeviceModel  | strMobileDeviceOS   |strPassword |
      |<strFirstName>|<strLastName>|<strEmail>|<strBirthDay>|<strBirthMonth>|<strBirthYear>|<strLanguages>|<strCity>|<strZipCode>|<strCountry>|<strOSPC> | <strVersionPC>  | <strLanguagePC> |<strMobileDeviceBrand> | <strMobileDeviceModel>| <strMobileDeviceOS> |<strPassword>|
    Then it can read
      |strMessage  |
      |<strMessage>|

    Examples:
      | strFirstName |  strLastName|  strEmail        | strBirthDay | strBirthMonth | strBirthYear |strLanguages   | strCity | strZipCode | strCountry | strOSPC  | strVersionPC    | strLanguagePC   | strMobileDeviceBrand  | strMobileDeviceModel  | strMobileDeviceOS   |strPassword  | strMessage      |
      | Sandra       |  Lopez      |slopez@example.com| 10          | April         | 1995         |Spanish,Arabic |Malaga   |29007       | Spain      | Linux    | Ubuntu          | Arabic          |  Apple                | iPhone 4              | iOS 11.2            |Holi12346*   | Complete Setup  |

