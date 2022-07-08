Automated tests to PeselValidator REST API endpoint (https://peselvalidatorapitest.azurewebsites.net/swagger/index.html) written in Java, using rest-assured and TestNG libraries. Test cases were derived basing on documentation provided on Swegger, as well as the regulatory rules for assigning pesel numbers (https://www.gov.pl/web/gov/czym-jest-numer-pesel).

TEST VALID PESEL
BirthDate - XIX, XX and XXI Century
I checked the last days of each month

TEST INVALID PESEL
I check error codes and corresponding messages:
        "INVL", "Invalid length. Pesel should have exactly 11 digits.
        
        "NBRQ", "Invalid characters. Pesel should be a number."
        
        "INVY", "Invalid year."
        
        "INVM", "Invalid month."
        
        "INVD", "Invalid day." (for invalid day "last" of each month)
        
        "INVC", "Check sum is invalid. Check last digit."
        
REST API TEST
I check prise of gold - 2nd January 2013 and 2 nd January 2017
I check Dollar Exchange Rate 2022 February 24th
I got PhotoId
