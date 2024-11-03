# java-lotto-precourse

# Lotto 

This project is a application that simulates a lottery system. Users can purchase lottery tickets, check if they match the winning numbers, and calculate the total prize amount and profit rate based on their winnings.


## Features Implemented

### Input Validation

- String to Integer Conversion with Error Handling: Converts a string to an integer and checks if the input is valid. Throws an error for non-numeric inputs.

- Purchase Amount Validation: Validates that the purchase amount is in increments of 1,000. Throws an error if the condition is not met.

- Lotto Number Length Validation: Ensures that a set of lotto numbers contains exactly 6 numbers.

- Duplicate Number Check: Verifies that the lotto numbers do not contain duplicates.

- Lotto Number Range Validation: Confirms that each lotto number is within the valid range of 1 to 45. Throws an IllegalArgumentException if the number is out of range.

### Additional Functionalities
- Random Lottery Number Generation: Generates a set of unique, random lottery numbers within the specified range of 1 to 45.


## 'Lotto' Class Implementation
### Validation Functions

- Lotto Number Length Validation: Checks that the lotto ticket has exactly 6 numbers.

- Duplicate Number Validation: Ensures that there are no repeated numbers on the ticket.

### Core Methods

- Count Matching Winning Numbers: Calculates how many numbers on a lotto ticket match the winning numbers.

- Check Matching Bonus Number: Determines if the ticket contains the specified bonus number.