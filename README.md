# java-lotto-precourse

## 로또

간단한 로또 발매기

- 로또 번호의 숫자 범위 : 1 ~ 45
- 로또 1장 가격 : 1,000원
- 로또 구입 금액을 입력
- 구입 금액에 해당하는 만큼 로또 발행
- 당첨 번호와 보너스 번호 입력
    - 중복되지 않는 숫자 6개와 보너스 번호 1개
- 사용자가 구매한 로또 번호와 당첨 번호(+ 보너스 번호)를 비교하여 당첨 내역 및 수익률 출력
- 당첨 기준 및 금액
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

## 구현 기능 목록

- [x] 1000원 단위의 로또 구입 금액의 입력 요구 문구를 출력하고 금액을 입력 받는다.
- [x] 구입 금액에 해당하는 갯수의 로또를 발행한다.
    - 로또 하나당, 1에서 45 사이의 중복되지 않은 정수 6개
- [x] 발행한 로또 수량 및 번호(오름차순)를 출력한다.
- [x] 당첨 번호의 입력 요구 문구를 출력하고 번호를 입력 받는다.
- [x] 당첨 로또를 발행한다.
- [x] 보너스 번호의 입력 요구 문구를 출력하고 번호를 입력 받는다.
- [ ] 보너스 번호를 설정한다.
- [ ] 구매한 모든 로또를 당첨 번호(+ 보너스 번호)와 비교한다.
- [ ] 비교한 결과를 동해 등수를 계산하여 당첨 내역을 생성한다.
- [ ] 당첨 내역를 통해 수익률을 계산한다.
- [ ] 당첨 통계 안내 문구를 출력한다.
- [ ] 당첨 내역을 출력한다.
- [ ] 수익률을 출력한다.

### Exception

- 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException` 발생 & "[ERROR]"로 시작하는 에러 메시지를 출력 후 다시 입력
    - [ ] 로또 구입 금액 입력
        1. 입력이 없는 경우
        2. 숫자가 아닌 경우
        3. 양수가 아닌 경우
        4. 1000원 단위가 아닌 경우
    - [ ] 당첨 번호 입력(쉼표(,) 기준으로 번호 구분)
        1. 입력이 없는 경우
        2. 쉼표(,)가 포함되지 않은 경우
        3. 숫자나 쉼표(,)가 아닌 문자가 포함된 경우
        4. 번호가 6개가 아닌 경우
            - "[ERROR] 로또 번호는 6개여야 합니다."
        5. 번호가 1 ~ 45 사이의 숫자가 아닌 경우
            - "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        6. 번호에 중복된 숫자가 있는 경우
    - [ ] 보너스 번호 입력
        1. 입력이 없는 경우
        2. 숫자가 아닌 경우
        3. 1 ~ 45 사이의 숫자가 아닌 경우
            - "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        4. 당첨 번호에 중복된 숫자가 있는 경우

### 입출력 예시

#### 입력

- 로또 구입 금액(1,000원 단위)
    ```
    14000
    ```

- 당첨 번호(쉼표(,) 기준)
    ```
    1,2,3,4,5,6
    ```

- 보너스 번호
    ```
    7
    ```

#### 출력

- 구입금액 입력 요구 문구
    ```
    구입금액을 입력해 주세요.
    ```

- 발행한 로또 수량 및 번호(로또 번호 오름차순)
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

- 당첨 번호 입력 요구 문구
    ```
    당첨 번호를 입력해 주세요.
    ```  

- 보너스 번호 입력 요구 문구
    ```
    보너스 번호를 입력해 주세요.
    ```  

- 당첨 통계 안내 문구
    ```
    당첨 통계
    ---
    ```  

- 당첨 내역
    ```
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    ```

- 수익률(소수점 둘째 자리에서 반올림)
    ```
    총 수익률은 62.5%입니다.
    ```

- 예외 상황 시, 에러 문구("[ERROR]"로 시작)
    ```
    [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
    ```

#### 실행 결과

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
