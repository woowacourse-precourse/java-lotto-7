# java-lotto-precourse

## Overview

- this project is Korean Lotto machine service.
- you can play simple simulation Korean Lotto.

## function

### Lotto relation

- generate 6 numbers randomly , non-duplicated from 1 to 45 and sorted in ascending,
   - [x] generate random number from 1 to 45
   - [x] generate randomly 6 numbers
   - [x] validate numbers **whether number is duplicated or not** 
   - [x] sort numbers in ascending order
- manage Internal Lotto data
   - [x] verify duplicated numbers

- provide interface for Lotto Data
   - [x] return stored Lotto data
   - [x] return matched Prize Tier by comparing winning numbers
   - [x] create empty Lotto Data

- manage Lotto Prize Tier
   - [x] return matched Prize Tier


### Lotto Machine relation

- provide interface for Machine service logic
  - [x] create Lotto more than ones
  - [x] save win Lotto number and bonus number from user
  - [x] return winning info of created Lottos

- provide user interface
  - [ ] read input money from user 
  - [ ] calculate a number of Lotto user buy
  - [ ] read input winning number and **bonus number from user**
  - [ ] print bought Lotto info
  - [ ] print winning Lotto info from bough Lotto info

- handle user request
  - [ ] deliver user request and info 

### Validation relation

- provide validation logic
   - [ ] validate string whether string is numeric or not
   - [ ] validate string whether numeric string is out of Int type range or not
   - [ ] validate string whether numeric string is positive or not
   - [ ] validate string whether string is blank or not