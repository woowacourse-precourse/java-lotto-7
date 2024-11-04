# java-lotto-precourse

## 기능 요구 사항

### 간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

---

# 기능 목록

## domain

### Buyer

-[x] 구매자의 동등성을 확인하는 기능 (equals)
-[x] 구매자의 해시코드를 가져오는 기능 (hashCode)
-[x] 구매한 로또의 개수를 가져오는 기능 (getBuyerLottosCount)
-[x] 구매한 로또들을 가져오는 기능 (getBuyerLottos)

### BuyerFactory

-[x] 구매 개수에 따라 랜덤 로또를 뽑는 구매자를 생성하는 기능 (createBuyer) 
-[x] 구매 개수에 따라 테스트 로또를 뽑는 구매자를 생성하는 기능 (createTestBuyer)
  - 커스텀 로또의 개수와 로또 구매 개수는 일치해야 한다. (validateLottosCount)

### LottosCount

- [x] 입금한 금액으로 구입할 수 있는 로또 개수를 생성하는 기능 (from)
    - 입금한 금액은 0 이상 이어야 한다. (validatePositiveMoney)
    - 입금한 금액은 1000 단위로 나눠져야 한다. (validateThousandUnitMoney)
- [x] 구매한 로또의 개수를 반환받는 기능 (getBuyerLottosCount)
- [x] 로또 개수의 동등성을 확인하는 기능 (equals)
- [x] 로또의 해시코드를 반환받는 기능 (hashCode)
- [x] 로또의 개수를 가져오는 기능 (getLottosCount)

### Lotto

  - 로또를 검증한다. (validate)
      - 로또 번호로 6개의 숫자로 이루어있는지 검증한다. (validateNumbersSize)
      - 로또 번호 내 중복이 있는지 검증한다. (validateDuplicateNumbers)
  - 로또 내 번호를 오름차순으로 정렬한다 (sortAscendingLotto)
- [x] 로또가 동일한지 확인하는 기능 (equals)
- [x] 로또의 해시코드를 가져오는 기능 (hashCode)
- [x] 로또를 출력하는 기능 (toString)
- [x] 로또의 번호를 반환받는 기능 (getLottoNumbers)

### LottoFactory

- [x] 길이가 6인 배열을 입력받아 로또를 생성하는 기능 (createCustomLotto)
- [x] 랜덤 숫자를 6개 뽑아 로또를 생성하는 기능 (createRandomLotto)

### Lottos

- [x] Lottos 객체의 동등성 비교 기능 (equals)
- [x] Lottos 객체의 해시코드 생성 기능 (hashCode)
- [x] Lottos 객체를 문자열로 출력하는 기능 (toString)
- [x] Lottos 객체를 반환하는 기능 (getLottos)

### LottosFactory

- [x] 커스텀 로또들을 입력받아 Lottos 객체를 생성하는 기능 (createCustomLottos)
- [x] 6개의 랜덤 번호로 이루어진 로또를 구매 개수만큼 생성하는 기능 (generateRandomLottos)


### Number

- [x] 숫자를 생성하는 기능
  - 생성한 숫자가 로또 번호의 범위에 들어오는지 확인한다. (validateNumber)
- [x] Number 객체의 동등성을 비교하는 기능 (equals)
- [x] Number 객체의 해시코드를 가져오는 기능 (hashCode)
- [x] 숫자를 반환하는 기능 (getNumber)

### NumberFactory
- [x] 숫자를 생성하는 기능 (from)
- [x] 보너스 숫자 생성하는 기능 (createBonusNumber)
  - 보너스 숫자는 추첨한 로또 번호와 중복되서는 안된다. (validateBonusNumber)
- [x] 랜덤 숫자를 생성하는 기능 (generateRandomNumber)
  - 로또 번호 범위 내의 숫자 중 하나를 무작위로 생성한다.

### Numbers

- [x] Numbers 객체를 생성하는 기능 (of)
- [x] 랜덤 숫자 6개를 생성하는 기능 (generateSixRandomNumbers)
  - 로또 범위 내의 숫자 6개를 무작위로 생성한다.
- [x] Numbers 객체의 동등성을 비교하는 기능 (equals)
- [x] Numbers 객체의 해시코드를 가져오는 기능 (hashCode)
- [x] Numbers 객체를 반환하는 기능 (getNumbers)


### LottoMatcher

- [x] 로또 당첨 정보를 기반으로 등수를 계산하는 기능 (calculateRank)
  - 로또 번호와 당첨 번호의 일치 개수를 센다. (countMatches)
  - 로또 번호에 보너스 번호가 포함되어 있는지 확인한다. (hasBonusNumber)
  - 로또 객체에서 로또 번호들을 가져온다. (getLottoNumbers)
  - 당첨 정보에서 당첨 번호들을 가져온다. (getWinningLottoNumbers)

### LottoStatistics

- [x] 로또 통계 객체를 생성하는 기능 (createLottoStatistics)
  - 처음 생성하면 모든 등수의 횟수가 0이어야 한다.
  - 처음 생성하면 상금의 합이 0 이어야 한다.
- [x] 결과를 적용하는 기능 (addResult)
- [x] 로또 통계 객체를 반환하는 기능 (getStatistics)
- [x] 로또 상금을 반환하는 기능 (getTotalPrize)

### Rank

- [x] Rank 객체를 생성하는 기능 (of)
  - 보너스 번호를 맞추지 못한 경우, 로또 번호만 체크한다. (isMatchingRank)
  - 보너스 번호를 맞춘 경우, 보너스 번호와 로또 번호 둘다 체크한다.
- [x] 각 등수의 맞춰야 하는 개수를 반환하는 기능 (getMatchCount)
- [x] 보너스 번호를 맞췄는지 확인하는 기능 (getMatchBonusPriority)
- [x] 상금을 반환하는 기능 (getPrize)

### WinningInfo

- [x] 로또의 추첨 결과를 생성하는 기능 (of)
- [x] 추첨한 로또의 번호를 가져오는 기능 (getWinningNumbers)
- [x] 추첨한 로또의 보너스 번호를 가져오는 기능 (getBonusNumber)

### WinningStatistics

- [x] 당첨 결과 통계 객체를 생성하는 기능 (of)
- [x] 당첨 결과를 통계에 적용하는 기능 (calculateWinningStatistics)
- [x] 수익률을 반환하는 기능 (getReturnRate)
  - 백분율로 표현한다.
  - 소수 둘째 자리에서 반올림한다.
- [x] 통계 객체를 정렬하는 기능 (getSortedStatistics)
- [x] 당첨 결과 통계를 문자열로 출력하는 기능 (toString)
  - 등수를 오름차순으로(일치한 번호 수의 내림차순)으로 정렬한다.
  - 당첨되지 않은 결과를 출력하지 않는다.
- [x] 통계 자료를 반환하는 기능 (getStatistics)

---

## view

### InputHandler

- [x] 문자열을 숫자로 변환하는 기능 (stringToNumber)
- [x] 로또 추첨 결과 문자열에서 로또를 생성하는 기능  (splitLottoNumbers)

### InputView

- [x] 돈을 입력하는 기능 (inputMoney)
  - null이 입력됐는지 확인한다.
  - 빈칸, 또는 공백을 입력했는지 확인한다.
  - 숫자만 입력했는지 확인한다.
  - IllegalArgumentException 발생시 제대로 된 입력값을 받을때까지 반복한다.
- [x] 당첨 번호들을 입력하는 기능 (InputWinningNumbers)
  - null이 입력됐는지 확인한다.
  - 빈칸, 또는 공백을 입력했는지 확인한다.
  - 숫자와 ","만 입력했는지 확인한다.
  - ","로 시작하거나 끝나는지 확인한다.
  - ","가 연속으로 나오는지 확인한다.
  - IllegalArgumentException 발생시 제대로 된 입력값을 받을때까지 반복한다.
- [x] 보너스 번호를 입력하는 기능 (inputBonusNumber)
  - null이 입력됐는지 확인한다.
  - 빈칸, 또는 공백을 입력했는지 확인한다.
  - 숫자만 입력했는지 확인한다.
  - IllegalArgumentException 발생시 제대로 된 입력값을 받을때까지 반복한다.

---

# 예외 목록

### buyer

- 커스텀 로또의 경우, 구매 개수와 로또 개수가 일치하지 않으면 예외가 발생한다.
- 입력한 돈이 1000의 단위가 아니면 예외가 발생한다.

### Lotto

- 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.
- 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.

### Number

- 숫자가 로또번호 범위를 벗어나면 예외가 발생한다.
- 보너스 번호가 추첨한 로또 번호와 중복되면 예외가 발생한다.
  - 제대로된 보너스 번호를 입력할때까지 반복한다.

### Numbers

- 숫자들이 로또번호를 벗어나면 예외가 발생한다.
- 정상 범위를 벗어난 숫자들로 Numbers 를 생성하면 예외가 발생한다.

### InputView(예외가 발생하는 입력)

- money, bonusNumber
  - null
  - 빈칸
  - 공백
  - 숫자 외 다른 문자
  제대로된 money, bonusNumber를 입력할때까지 반복한다.

- 추첨한 로또 번호
  - null 
  - 빈칸 
  - 공백
  - 숫자와 ","외 다른 문자
  - ","로 시작하는 문자열
  - ","로 끝나는 문자열
  - ","가 연속으로 나오는 문자열
  제대로된 money를 입력할때까지 반복한다.

---
```
파일 구조
└── src
    ├── main
    │   └── java
    │       └── lotto
    │           ├── Application.java
    │           ├── config
    │           │   └── AppConfig.java
    │           ├── controller
    │           │   └── Controller.java
    │           ├── domain
    │           │   ├── buyer
    │           │   │   ├── Buyer.java
    │           │   │   ├── BuyerFactory.java
    │           │   │   └── LottosCount.java
    │           │   ├── lotto
    │           │   │   ├── Lotto.java
    │           │   │   ├── LottoFactory.java
    │           │   │   ├── Lottos.java
    │           │   │   └── LottosFactory.java
    │           │   ├── number
    │           │   │   ├── Number.java
    │           │   │   ├── NumberFactory.java
    │           │   │   └── Numbers.java
    │           │   └── winning
    │           │       ├── LottoMatcher.java
    │           │       ├── LottoStatistics.java
    │           │       ├── Rank.java
    │           │       ├── WinningInfo.java
    │           │       └── WinningStatistics.java
    │           ├── resources
    │           │   ├── Constants.java
    │           │   ├── ErrorMessages.java
    │           │   └── Messages.java
    │           ├── service
    │           │   ├── LottoNumberService.java
    │           │   ├── LottoService.java
    │           │   └── WinningStatisticsService.java
    │           └── view
    │               ├── InputHandler.java
    │               └── InputView.java
    └── test
        └── java
            └── lotto
                ├── ApplicationTest.java
                └── domain
                    ├── buyer
                    │   ├── BuyerTest.java
                    │   ├── LottosCountTest.java
                    │   └── LottosTest.java
                    ├── lotto
                    │   ├── LottoFactoryTest.java
                    │   └── LottoTest.java
                    ├── number
                    │   ├── NumberTest.java
                    │   └── NumbersTest.java
                    └── winning
                        ├── LottoMatcherTest.java
                        ├── LottoStatisticsTest.java
                        ├── RankTest.java
                        ├── WinningInfoTest.java
                        └── WinningStatisticsTest.java
``` 
