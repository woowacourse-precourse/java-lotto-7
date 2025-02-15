# java-lotto-precourse

## 프로젝트 구조

```
main
└── java
    └── lotto
        ├── Application.java
        ├── controller
        │   ├── LottoTransactionController.java
        │   └── MainController.java
        ├── model
        │   ├── Lotto.java
        │   ├── LottoTransaction.java
        │   └── PrizeRank.java
        ├── validator
        │   ├── InputValidator.java
        │   ├── LottoValidator.java
        │   ├── PurchaseAmountValidator.java
        │   └── Validator.java
        └── view
            ├── InputView.java
            └── LottoTransactionView.java
```
## 기능 리스트

### 입력 기능

1.
   - [x] 구입 금액은 1,000원 단위만 입력 가능 (아닐경우 에러)
2.
   - [x] 당첨 번호 입력시 숫자와 ','만 들어 올 수 있다.
   - 1~45 숫자만 입력 가능
3.
   - [x] 보너스 번호 1개를 입력
   - 1~45 숫자만 입력 가능
   - 당첨 번호와 같은 번호 불가능 (동일 번호 입력시, 재입력 실행)
4.
   - [x]  잘못된 값을 입력할 경우
   - "[ERROR]"로 시작하는 에러 메시지를 출력
   - 그 부분부터 입력을 다시 받는다.

### 출력 기능

1.
   - [x] 구매한 로또 개수 출력
2.
   - [x] 자동 생성된 로또 숫자 리스트 일렬로 출력
3.
   - [x] 당첨 통계 출력
   - "1,000.0%" 와 같이 숫자에 "," 필요
4.
   - [x] 총 수익률은 소수점 1자리로 출력

### 핵심 기능

#### 상금 지급

1.
   - [x] 로또는 1~5등까지 구현, (Enum 사용해서 1~5등 정의하기)
    - 1등: 6개만, 2등: 보너스 숫자 포함 5개만, 3등: 숫자 5개만 (보너스 제외), 4등: 숫자 4개만, 5등 숫자 3개만
   - 상금 차등 지급
2.
   - [x] 1~5등 당첩된 로또 개수 저장
3.
   - [x] 총 수익률 계산
4.
   - [x] 당첨 번호와 구매한 로또 번호 비교
    - 구매한 로또 정보 저장
    - 당첨 번호 입력되면 생성된 로또와 비교
5.
   - [x] 보너스 숫자 사용해서 당첨 번호 비교

#### 로또 생성

1.
   - [x] 로또 당첨 번호는 1~45 숫자
2.
   - [x] 숫자 중복 불가능
3.
   - [x] 로또 숫자는 언제나 6자리

#### 로또 구입

1.
   - [x] 로또 1개 1,000원 설정
2.
   - [x] 구입 금액이 0이 될 때까지 로또 구매
3.
   - [x] 구매한 로또 List<Lotto>로 반환 또는 저장
