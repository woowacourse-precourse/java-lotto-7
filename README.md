# java-lotto-precourse

## Feature

- [x] get price, winning numbers and bonus number and print rate of return
    - [x] throw error when invalid input is given
        - [x] throw error when price is invalid
        - [x] throw error when winning numbers are invalid
        - [x] throw error when bonus number is invalid
        - [x] continue accepting input
    - [x] get the number of lottery to publish
    - [x] print lottery numbers in ascending order
        - [x] pick 6 numbers in range 1~45
    - [x] get winning numbers and bonus number
    - [x] calculate each lottery prize
    - [x] calculate rate of return
    - [x] print lottery results and rate of return

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

# Example

### Input 

Enter the purchase amount for the lottery. The purchase amount should be entered
in units of 1,000won, and if it is not divisible by 1,000, an exception should
be thrown.

```
14000
```

Enter the winning numbers. Numbers are divided by comma(,).

```

1,2,3,4,5,6
```

Enter the bonus number.

```
7
```

### Output

Print quantity and numbers of lottery. The numbers should be sorted in ascending
order.

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

Print winning results.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

Round the profit rate to the second decimal place. (e.g. 100.0%, 51.5%, 1,000,000.0%)

```
총 수익률은 62.5%입니다.
```

Print error messages on exceptional situations. The message should starts with
"[ERROR]".

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

### Execution example

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```
