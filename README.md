# 🎰로또🎰 기능목록

## 📚 프로젝트 개요

- 간단한 로또 발매기를 구현한다.
    - 사용자가 입력한 로또 구입 금액에 따라 발행된 로또 번호와 사용자가 입력한 당첨 번호를 비교해 당첨 내역을 출력한다.
- 입력 값이 잘못되었을 때 적절한 예외 처리를 수행한다.

## 📚 구현 기능 목록

### 💫입력

- [ ] 1장에 1000원인 로또 구입 금액을 입력한다.
  ```
  구입금액을 입력해 주세요.
  8000
  ```
- [ ] 1-45 중 당첨 번호를 6개 입력한다. (쉼표를 기준으로 구분한다.)
  ```
  구입금액을 입력해 주세요.
  8000
  ```
    - [ ] 쉼표로 구분된 문자에 공백이 포함되어 있는 경우 무시
        - ex) 입력 : `1  0, 1 1, 1   2, 13, 14, 15` 저장 : [10, 11, 12, 13, 14, 15]
- [ ] 1-45 중 보너스 번호를 1개 입력한다.
  ```
  보너스 번호를 입력해 주세요.
  7
  ```

#### 💣예외처리

- [x] 로또 구입 금액
    - [x] null 혹은 빈 문자열 입력한 경우
    - [x] 입력값이 숫자가 아닌 경우
    - [x] 입력값이 양수가 아닌 경우
    - [x] 1,000원으로 나누어 떨어지지 않는 경우
- [x] 당첨 번호
    - [x] null 혹은 빈 문자열 입력한 경우
    - [x] 구분자가 쉼표가 아닌 경우
    - [x] 쉼표로 구분된 문자가 6개가 아닌 경우
    - [x] 쉼표로 구분된 문자가 숫자가 아닌 경우
    - [x] 쉼표로 구분된 문자가 빈 문자열일 경우
    - [x] 쉼표로 구분된 수 각각이 1-45 범위가 아닐 경우
    - [x] 쉼표로 구분된 수가 중복되는 경우
- [ ] 보너스 번호
    - [ ] null 혹은 빈 문자열 입력한 경우
    - [ ] 숫자가 아닌 경우
    - [ ] 1-45 범위가 아닐 경우
    - [ ] 이미 뽑은 당첨 번호와 중복되는 경우

### 💫진행

- [ ] 예외 발생 시 `[ERROR]`로 시작하는 에러 문구를 출력한 후 그 부분부터 입력을 다시 받는다.
  ```
  [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
  ```

### 💫출력

- [ ] 로또 구입에 해당하는 만큼 발행된 로또 번호를 오름차순으로 출력한다.
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
- [ ] 당첨 내역을 출력한다.
  ```
  당첨 통계
  ---
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ```
- [ ] 수익률을 출력한다.
    - [ ] 수익률은 소수점 둘째 자리에서 반올림한다. `ex) 100.0%, 72.5%`
    - [ ] 금액은 세자리 단위로 끊어서 표기한다. `ex) 2,000,000,000`
  ``` 
  총 수익률은 72.5%입니다.      
  ```

## 📚 프로그램 전체 흐름

```dtd
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
