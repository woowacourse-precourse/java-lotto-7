# java-lotto-precourse

사용자가 구매한 로또와 컴퓨터가 생성한 랜덤 로또를 비교하여 당첨 내역과 수익률을 출력한다.

### 주요 기능

- 구매한 금액만큼 랜덤 로또를 생성한다.
- 사용자가 입력한 로또(6개+보너스) <-> 사용자가 구입한 만큼의 생성된 랜덤 로또(n개)를 매칭한다.
- 당첨 결과를 계산한다.
- 수익률을 계산한다.

### 세부 기능

- 로또 구입 금액을 입력받고 저장한다. + 유효검사

- 사용자가 구입 금액만큼 랜덤 로또를 생성한다.
    - 1장당 1,000원
    - 6자리
    - 1~45까지의 랜덤 숫자 범위
- 생성한 랜덤 로또를 오름차순으로 출력한다.

- 로또 6자리 번호를 입력받고 저장한다 + 유효검사
- 보너스 번호를 입력받고 저장한다 + 유효검사

- 랜덤 로또와 <-> 사용자 로또를 매칭한다.
    - 결과 1개 = 랜덤 로또 1개 <-> (입력한 로또+보너스)
- 당첨 통계를 출력한다.


- 수익률을 계산하여 출력한다.
    - 상금/구매한 금액 * 100
    - 수익률은 소수점 둘째 자리에서 반올림한다.
    - 천단위로 , 를 찍어 출력한다. - 1,000

### 플로우

1. 로또 구입 금액을 입력받는다. + 유효검사
2. 구입한 만큼 랜덤 로또를 생성한다.
3. 당첨번호 6자리를 입력받는다. + 유효검사
4. 보너스 번호 1자리를 입력받는다. + 유효검사
4. 발행한 로또 수량 및 번호를 오름차순으로 출력한다.
5. 당첨 내역을 출력한다.
6. 수익률을 출력한다. 소수점 둘째 자리에서 반올림한다.(ex. 100.0%, 51.5%, 1,000,000.0%)

### 유효 검사

- 구입 금액
    - 숫자인가?
    - 최소 1,000원인가?
    - 1,000단위로 나누어 떨어지는가?

- 6자리 메인 로또 번호
    - ,콤마 이외에 다른 특수문자가 존재하는가?
    - 숫자인가?
    - 빈 입력값이 있는가?
    - 6개인가?
    - 1~45범위에 있는가?
    - 중복지 않는가?

- 1자리 보너스 로또 번호
    - 숫자인가?
    - 1개인가?
    - 1~45범위에 있는가?
    - 6자리 메인 로또번호와 중복되지 않는가?

### 주의할 점

- 사용자가 입력한 로또(6개+보너스) <-> 사용자가 구입한 만큼의 생성된 랜덤 로또(n개)1개씩을 매칭한다.
- 2등과 3등은 메인 로또번호는 5개로 동일하지만 보너스 로또의 당첨 유무에 따라 달라진다.

### 추가 요구 사항

- 잘못 입력할 경우 그 부분부터 다시 입력받는다.
    - [ERROR] 로 시작하는 에러 메시지를 던진다.
- Enum을 사용한다.
- 상황에 맞는 다양한 예외를 던진다.
- 변수 이름에 자료형을 사용하지 않는다.
- 한 기능 구현이 끝나면 테스트 코드를 작성한다.

---

```
    lotto
    ├── Application.java
    ├── controller
    │   └── MainController.java
    ├── domain
    │   ├── InputErrorMessage.java
    │   ├── Rank.java
    │   ├── Wallet.java
    │   ├── calculators
    │   │   ├── FinalPrizeCalculator.java
    │   │   ├── TicketCalculator.java
    │   │   ├── TicketCalculatorImpl.java
    │   │   └── YieldCalculator.java
    │   ├── factory
    │   │   └── UserMainLottoFactory.java
    │   ├── lottos
    │   │   ├── Lotto.java
    │   │   ├── RandomLottos.java
    │   │   └── user
    │   │       ├── BonusLotto.java
    │   │       ├── UserLotto.java
    │   │       └── WinningRank.java
    │   └── number
    │       ├── NumbersMaker.java
    │       └── RandomLottoNumberMaker.java
    ├── service
    │   ├── LottoMatchService.java
    │   ├── RandomLottoMarket.java
    │   └── YieldCalculateService.java
    └── view
        ├── Input.java
        ├── Output.java
        └── WinningStatisticsPrinter.java
```

- 서비스
    - `RandomLottoMarket` : **티켓 개수 계산과, 랜덤 로또 생성을 요청한다.**
        - `TicketCalculator` : 티켓 개수(로또 구매 가능 개수)를 계산한다.
        - `RandomLottos` : 랜덤 숫자 6개를 생성한다.
        - `Wallet` : 구매 금액 데이터를 제공하고 계산된 티켓 개수를 반환한다.
    - `LottoMatchService` : **사용자 로또<->랜덤 로또의 매칭과, 당첨 통계 업데이트를 요청한다.**
        - `UserLotto` : 로또 매칭시 자신의 매칭 결과를 반환한다.
        - `RandomLottos` : 자신과 사용자의 로또를 매칭한다.
        - `WinningRank` : 매칭 결과를 당첨 통계로 저장한다.
    - `YieldCalculateService` : **총 상금액을 받아와 수익률 계산을 요청한다.**
        - `YieldCalculator` : 수익률을 계산한다.
        - `Wallet` : 구매 금액 데이터를 제공하고 수익률을 저장 및 반환한다.
        - `WinningRank` : 당첨 통계 결과로 최종 상금을 계산하여 반환한다.

- 객체
    - `Wallet`
        - amount : 구매 금액
        - rateOfReturn : 수익률
    - `UserLotto`
        - `mainLotto` : 6개 메인 로또
        - `bonusLotto` : 보너스 로또
    - `RandomLottos`
        - `lottos` : 사용자가 구매한 랜덤 로또들
    - `WinningRank`
        - ranks : 매칭된 결과 당첨 통계

- 계산기
    - TicketCalculator(interface) - `TicketCalculatorImpl` : 구입 금액과 로또 1장당 가격으로 티켓 개수 계산한다.
    - `YieldCalculator` : 구입 금액과 최종 상금으로 수익률 계산한다
    - `FinalPrizeCalculator` : 당첨 통계로 최종 상금을 계산한다.

- 숫자 생성
    - NumbersMaker(interface) - `RandomLottoNumberMaker` : 6개 로또 랜덤 숫자를 생성한다.

- 팩토리
    - `UserSixLottoFactory` : 사용자가 입력한 6개 로또를 콤마(,) 기준으로 나누어 Lotto객체를 생성한다.

- 정책
    - Rank(Enum) : 당첨 순위, 6개 로또 매칭 개수, 보너스 점수 매칭 상태, 총 상금 금액을 상수로 관리하고, 매칭 결과에 해당되는 당첨 순위를 찾아 반환한다.




