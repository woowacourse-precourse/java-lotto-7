# Lotto Machine

---

## Repository

This repository is where I forked [java-lotto-7](https://github.com/woowacourse-precourse/java-lotto-7) from [woowacourse precourse](https://github.com/woowacourse-precourse) to apply woowacourse.   

## Basic Lotto Rules
1. **Number Range**: 1 to 45
2. **Number Count**: Each lotto ticket consists of 6 unique numbers
3. **Winning Number Draw**:
    - Draws 6 unique winning numbers plus 1 bonus number

## Prize Tiers and Rewards
| Rank | Matching Criteria       | Prize Amount      |
|------|-------------------------|-------------------|
| 1st  | Match 6 numbers         | 2,000,000,000 KRW |
| 2nd  | Match 5 numbers + Bonus | 30,000,000 KRW    |
| 3rd  | Match 5 numbers         | 1,500,000 KRW     |
| 4th  | Match 4 numbers         | 50,000 KRW        |
| 5th  | Match 3 numbers         | 5,000 KRW         |

## Game Rules
1. **Lotto Ticket Price**: Each ticket costs 1,000 KRW
2. **Purchase Amount**: Enter the purchase amount to generate the corresponding number of tickets
3. **Checking Results**:
    - Enter the winning and bonus numbers, then compare them with the user’s tickets to determine prize rank and yield rate
4. **Game End**: After displaying the yield rate and prize details, the game concludes

## App Screen

## Exception Handling
- When incorrect input is detected, raise an `IllegalArgumentException`, display an error message prefixed with `[ERROR]`, and prompt for re-entry
- Handle specific exception types (e.g., `IllegalArgumentException`, `IllegalStateException`)

---
