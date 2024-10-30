# java-lotto-precourse

# 구조 

```agsl
> lotto 
    > controller
        - LottoController.java
    > domain
        - Lotto.java
        - LottoMachine.java
        - LottoResultManager.java
        - BonusNumber.java
        > enums
            - LottoResult.java       
    > service
        - LottoService.java
    > utils
        - Constants.java
        - LottoConstants.java
        - ErrorMessages.java
        - Messages.java
    > view
        - InputView.java
        - OutputView.java
    - Application.java
        
```
---
# 클래스 역할과 책임

## Controller

### LottoController 
- InputView, OutputView를 통해 사용자 입력을 받고 출력하는 역할
- 입력 받은 값을 LottoService에 전달하여 로또 게임을 진행
- LottoService로부터 결과를 받아 OutputView에 전달하여 출력

---

## Model

### Lotto
- 로또 한 장을 의미하는 객체로, 로또 번호(6개)를 가지고 있음
- 입력 받은 로또 번호 검증

### LottoMachine
- 로또 발행을 담당하는 객체 
- 구입 금액에 해당하는 로또 개수만큼 로또 번호 생성 

### LottoResultManager
- 당첨 번호와 비교하여 당첨 여부 확인
- 당첨 등수별 당첨 횟수 분류
- 당첨 금액 및 수익률 계산

### BonusNumber
- 보너스 번호를 의미하는 객체

### LottoResult
- 당첨 결과를 의미하는 enum 객체
- 당첨 등수에 따른 당첨 금액을 가지고 있음
- 당첨 결과에 따라 당첨 금액을 반환

---

## Service
### LottoService
- 문자열 상태의 입력 값을 정수로 변환하여 LottoMachine, LottoResultManager에 전달
- LottoMachine, LottoResultManager로부터 결과를 받아 LottoController에 전달

---

## Utils
### Constants
- 프로젝트 전체에서 사용되는 상수를 정의
- 로또 숫자 범위, 로또 숫자 갯수 등

### LottoConstants
- 로또 게임에 사용되는 상수를 정의
- 로또 가격, 등수 별 일치 갯수 등

### ErrorMessages
- 예외 처리 시 출력할 에러 메시지를 정의

### Messages
- 사용자에게 출력할 메시지를 정의

---
## View
### InputView
- 사용자로부터 입력을 받는 메소드를 가지고 있는 클래스

### OutputView
- 사용자에게 출력을 하는 메소드를 가지고 있는 클래스

---

# 기능 명세서

## 1. 입력 처리

- **구입 금액 입력 받기**
  - [x] `"구입금액을 입력해 주세요"` 문구 출력
  - [x] 구입 금액 입력 받기
    - [x] 예외: 정수가 아닌 경우
      - `IllegalArgumentException("[ERROR] 구입 금액은 정수로 입력해 주세요.")`
    - [x] 예외: 1,000원으로 나누어 떨어지지 않는 경우
      - `IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.")`

- **당첨 번호 입력 받기**
  - [x] `"당첨 번호를 입력해 주세요."` 문구 출력
  - [x] 당첨 번호 입력 받기
    - [x] 예외: 정수가 아닌 경우
      - `IllegalArgumentException("[ERROR] 당첨 번호는 정수로 입력해 주세요.")`
    - [x] 예외: 1과 45 사이 밖의 정수가 입력된 경우
      - `IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이여야 합니다.")`
    - [x] 예외: 입력된 번호가 6개가 아닌 경우
      - `IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.")`
    - [x] 예외: 중복된 번호가 있는 경우
      - `IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.")`

- **보너스 번호 입력 받기**
  - [x] `"보너스 번호를 입력해 주세요."` 문구 출력
  - [x] 보너스 번호 입력 받기
    - [x] 예외: 정수가 아닌 경우
      - `IllegalArgumentException("[ERROR] 보너스 번호는 정수로 입력해 주세요.")`
    - [x] 예외: 1과 45 사이 밖의 정수가 입력된 경우
      - `IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.")`
    - [x] 예외: 당첨 번호와 중복되는 경우
      - `IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")`


## 2. 로또 게임

- **로또 발행**
  - [x] 구입 금액에 해당하는 로또 개수만큼 로또 번호 생성
  - [x] 각 로또에 대해 당첨 번호와 비교하여 당첨 여부 확인
  - [x] 당첨 등수별 당첨 횟수 분류

- **당첨 금액 및 수익률 계산**
  - [x] 각 등수별 당첨 금액 합산하여 총 당첨 금액 계산
  - [x] 수익률 계산 -> `(총 당첨 금액 / 구입 금액) * 100`
  - [x] 수익률은 소수점 둘째 자리에서 반올림 (ex. 100.0%, 51.5%, 1,000,000.0%)


## 3. 출력 처리

- **발행한 로또 출력**
  - [x] `"N개를 구매했습니다."` 문구 출력
  - [x] 오름차순으로 정렬하여 각 로또 번호 출력

- **당첨 내역 출력**
  - [x] `"당첨 통계" 및 "---"` 문구 출력
  - [x] 당첨 등수별 당첨 횟수 출력
  - [x] 수익률 출력 (소수점 둘째 자리에서 반올림)

