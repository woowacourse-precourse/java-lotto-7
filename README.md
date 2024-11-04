# java-lotto-precourse

## 구현 기능

- [x] **출력 기능**
  - 구입 금액 입력을 위한 출력
  - 발행한 로또 수량 및 번호 출력
  - 당첨 번호 입력을 위한 출력
  - 보너스 번호 입력을 위한 출력
  - 당첨 내역 출력
  - 수익률 출력
- [x] **입력 기능**
  - 자연수 입력(구매 금액, 보너스 번호)
  - 당첨 번호 입력
- [x] **검증 기능**
  - 구입 금액의 검증
    - 구입 금액의 입력값은 1000 단위로 나누어 떨어져야함
    - 양수여야함
  - 입력받는 로또의 당첨 번호 검증
    - 로또의 번호는 6개여야함
    - 로또의 번호는 중복되면 안됨
    - 각 값은 1에서 45의 값이여야함
  - 입력받는 보너스 번호 검증
    - 보너스 번호는 당첨 번호와 중복되면 안됨
    - 1에서 45의 값이여야함
- [x] **계산 기능**
  - 로또 발권 기능
  - 당첨 확인 기능
  - 수익률 계산 기능

### 제공받은 클래스를 이용하여 구현
```
Lotto 클래스에서 생성자를 통해 검증하는 방식 
-> 즉 입력받은 당첨번호를 로또 객체를 생성하여 검증한다
-> 의도하는 바는 생성자를 통해 검증하는 방식
-> 주요 검증은 생성자를 통해서
-> 불가할경우 인스턴스 변수를 설정하는 매서드를 통해서
```
### FLOW
1. 금액을 입력받아 LottoGame을 생성
2. LottoGame에서 입력받은 값만큼 Lotto 생성 
3. 당첨번호를 입력받아 LottoGame의 당첨번호 설정
4. 보너스번호를 입력받아 LottoGame의 보너스번호 설정
5. LottoGame이 가지고 있는 Lotto리스트를 통해 결과를 저장
6. LottoGame에서 수익률 계산

### 프로젝트 구조
```
lotto
  ├── Application.java
  ├── controller
  │   └── LottoController.java
  ├── domain
  │   ├── Lotto.java
  │   ├── LottoGame.java
  │   └── MatchResult.java
  ├── exception
  │   ├── ExceptionMessage.java
  │   └── InvalidLottoException.java
  ├── util
  │   └── ParserUtil.java
  ├── validation
  │   └── Validation.java
  └── view
      ├── InputView.java
      ├── OutputView.java
      └── PrintMessage.java
```
