# java-lotto-precourse

## Feature

- [ ] get price, winning numbers and bonus number and print rate of return
    - [ ] throw error when invalid input is given
        - [ ] throw error when price is invalid
        - [ ] throw error when winning numbers are invalid
        - [ ] throw error when bonus number is invalid
        - [ ] continue accepting input
    - [ ] get the number of lottery to publish
    - [ ] split winning numbers string
    - [ ] calculate each lottery prize
        - [ ] pick 6 numbers in range 1~45
    - [ ] calculate rate of return
    - [ ] print lottery results and rate of return

## Spec

- The range of lottery number is between 1 to 45.
- Pick 6 unique numbers when issuing a new lottery.
- Draw 6 winning and 1 bonus numbers for the lottery.
- There are five prize tiers, from 1st to 5th place. The winning criteria and
prize amounts are listed below.
- 1st: match 6 numbers / 2,000,000,000won
- 2nd: match 5 numbers and bonus number / 30,000,000won
- 3rd: match 5 numbers / 1,500,000won
- 4th: match 4 numbers  / 50,000won
- 5th: match 3 numbers  / 5,000won
- When user pay a price, corresponding amount of lottery should be issued.
- A lottery costs 1000won.
- Get winning numbers and bonus number as user input
- Compare numbers of lottery to the winning numbers and prints winning result
and rate of return. The exit program
- Throws IllegalArgumentException and print the message starts with "[ERROR]"
when user gives invalid input. Then continues the process of getting 
remaining inputs.
- Use specific exception classes like IllegalArgumentException,
IllegalStateException rather then Exception to clarify the situation.
