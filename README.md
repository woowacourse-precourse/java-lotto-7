# 간단한 로또 발매기

---

# 어플리케이션 동작 흐름

## 규칙📒

- **로또 번호 범위**: 1 ~ 45 사이의 숫자
- **로또 발행**: 1개의 로또에는 중복되지 않는 6개의 숫자 포함
- **당첨 번호 추첨**: 중복되지 않는 6개의 숫자와 보너스 번호 1개

## 당첨 조건과 상금

| 등수 | 당첨 조건             | 상금             |
|----|-------------------|----------------|
| 1등 | 6개 번호 일치          | 2,000,000,000원 |
| 2등 | 5개 번호 + 보너스 번호 일치 | 30,000,000원    |
| 3등 | 5개 번호 일치          | 1,500,000원     |
| 4등 | 4개 번호 일치          | 50,000원        |
| 5등 | 3개 번호 일치          | 5,000원         |

## 로또 발매기 작동 과정 🎰

1. **로또 구입 금액 입력 및 로또 발행**
    - 사용자가 입력한 금액만큼 로또 발행
    - **로또 1장의 가격**: 1,000원
    - 1000원으로 나누어 떨어지지 않으면 예외처리

    ```
    14000
    ```

2. **당첨 번호 및 보너스 번호 입력**
    - 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

    ```
    1,2,3,4,5,6
    ```

    - 보너스 번호를 입력받는다.

    ```
    7
    ```

3. **당첨 내역 확인 및 수익률 계산**
    - 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 확인한다. 또한 수익률을 계산한다.
    - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
4. **출력**
    - 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

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

    - 당첨 내역을 출력한다.

   ```
   3개 일치 (5,000원) - 1개
   4개 일치 (50,000원) - 0개
   5개 일치 (1,500,000원) - 0개
   5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
   6개 일치 (2,000,000,000원) - 0개
   ```

    - 수익률을 출력한다

   ```
   총 수익률은 62.5%입니다.
   ```

5. **예외 상황시 에러 문구 출력 후 해당 부분 재입력**
    - `IllegalArgumentException` 발생
    - `Exception`이 아닌`IllegalArgumentException`,`IllegalStateException`등과 같은 명확한 유형을 처리한다
    - 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

## 예외 상황 경우🚫

### 구입 금액 입력 시

- 숫자가 아닌 경우.
- 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우.
- 구매할 수 있는 개수를 초과한 경우.

### 당첨 번호 입력 시

- 숫자가 아닌 경우
- 6개의 수가 아닌 경우
- 숫자 범위를 벗어난 경우

### 보너스 번호 입력 시

- 숫자가 아닌 경우
- 숫자 범위를 벗어난 경우

## 실행 결과:

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

---

# FlowChart

어플리케이션 동작 흐름을 요약하였습니다.

![img.png](img.png)
---

# 구현해야 할 기능 목록📝

- [ ]  로또 구입 금액 입력 기능
    - [ ]  구입 금액 검증 기능
        1. 숫자 형식의 유효성 검증
        2. 구입 금액이 1,000원 단위인지 검증
        3. 구매할 수 있는 최대 금액 검증

- [ ]  로또 발행 기능
    1. 구매한 로또 수량만큼 6개의 무작위 번호 생성 및 각각 오름차순 정렬

- [ ]  발행한 로또 수량 및 번호 출력 기능

- [ ]  당첨 번호 입력 기능
    - [ ]  당첨 번호 입력 검증 기능
        1. 숫자 형식의 유효성 검증
        2. 수 개수 검증
        3. 숫자 범위 검증

- [ ]  보너스 번호 입력 기능
    - [ ]  보너스 번호 검증 기능
        1. 숫자 형식의 유효성 검증
        2. 숫자 범위 확인
        3. 당첨 번호에 없는 번호인지 확인

- [ ]  당첨 내역 및 수익률 계산 기능
    - [ ]  당첨 번호와 사용자의 로또 번호 일치 개수 확인 기능
    - [ ]  구매 금액과 수익 금액을 통한 수익률 계산 기능
    - [ ] 수익률 소수점 둘째자리에서 반올림 기능

- [ ]  당첨 내역 및 수익률 출력 기능

- [ ]  검증 실패시 에러 처리 기능
    1. "[ERROR]" 메시지 출력
    2. 해당 부분 재입력 요청

---

# 구현시 2주차 피드백 반영한 부분

## 개인피드백

1. 생성자에서 객체 생성 시 결합도 주의
2. .gitIgnore로 build 폴더 전체 처리 시 .class 자동 제외
3. 유사 역할의 상수 그룹화로 가독성 향상
4. IO 작업 최적화
5. 원시 타입 래퍼 클래스 활용

## 공통 피드백

1. README를 더 상세하게 작성할 것
2. 기능 목록을 재검토하며 지속적으로 업데이트하기
3. Java에서 상수 구현을 적절히 적용해볼 것
4. 변수 이름에 자료형을 포함하지 않기
5. 초기부터 대규모 단위 테스트를 작성하지 않기
6. 테스트 코드 더 깊게 공부해보기