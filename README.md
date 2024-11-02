# java-lotto-precourse

<br>

## ❐ Requirements

---

### 1. User

- 로또를 구입할 수 있다.
- 구매한 로또가 모두 일치하지 않을 수 있다.
- 총 세 번의 입력을 할 수 있다.(잘못 입력한 경우 댜시 입력을 할 수 있다.)<!-- {"fold":true} -->
    - 금액을 입력할 수 있다.
        - 안내문구 : `구입금액을 입력해 주세요.`
        - 로또 한장의 가격은 1000원이다.
        - 1000원 단위로만 구입할 수 있다.
    - 당첨 번호를 입력할 수 있다.
        - 안내 문구 : `당첨 번호를 입력해 주세요.`
        - 쉼표(,)를 기준으로 구분한다.
    - 보너스 번호를 입력할 수 있다.
        - 안내 문구 : `보너스 번호를 입력해 주세요.`
        - 당첨번호와 중복되는 않는 숫자를 입력한다.
- 총 두 번의 결과를 제공 받는다.<!-- {"fold":true} -->
    - 로또 구매후
        - 구입 금액 만큼의 로또를 발행 받는다.
        - 발행된 로또 정보를 오름차순으로 확인할 수 있다.
    - 게임 종료 후
        - 당첨 내역
        - 수익률(소수점 둘째 자리에서 반올림된 값이다.)

<br>

### 2. System

- 로또 한 장의 가격은 1000원이다.
- 로또 발행 규칙은 다음과 같다.
    - 로또 숫자의 범위는 1~45다.
    - 중복되지 않은 6개의 숫자와 보너스 번호 1개를 뽑는다.
        - 보너스 번호는 앞에 뽑은 6개의 번호 중 어떤 수와도 동일할 수 없다.
    - 사용자에게 구입 금액 만큼 발행해야 한다.
- 출력
    - 사용자가 **구매 직후** 안내 문구와 발행한 번호를 출력한다.
        - 안내 문구 : `${n}`개를 구매했습니다.
        - 발행 번호 : `[1,2,3,4,5,6]`
            - **오름차순으로 정렬**한다.
    - 로또 번호를 비교하여 다음의 결과를 출력하고 게임을 종료한다.
        - 당첨 내역
            - `${x}`개 일치 `(${reward}원)` - `${n}`개
            - `${x}`개 일치, 보너스 볼 일치  `(${reward}원)` - `${n}`개
        - 수익률
            - 안내 문구 : 총 수익률은 `${xx.xx}`%입니다.
            - 소수점 **둘째 자리에서 반올림**한다.
            - 기호(%)를 붙여야 한다.
                - Ex ) 100.0%, 51.5%, 1,000,000.0%
- 사용자가 잘못된 값을 입력한 경우
    - IllegalArgumentException을 발생시킨다.
    - 에러 문구는 [Error]로 시작해야 한다.
    - **다시 입력을 받아야 한다.**

<br>

### 3. Policy

당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다. 그 외는 등수, 상금이 없다.

| Rank | Matching Count | Bonus Number | Reward        |
|------|----------------|--------------|---------------|
| 1    | 6              | false        | 2,000,000,000 |
| 2    | 5              | **true**     | 30,000,000    |
| 3    | 5              | false        | 1,500,000     |
| 4    | 4              | false        | 50,000        |
| 5    | 3              | false        | 5,000         |

<br>
<br>

## ❐ Validation Check List

---

### 구입 금액

- 문자열
    - [x] 숫자 이외의 문자를 입력한 경우
    - [x] 입력하지 않는 경우
- 단위
    - [x] 1000원 단위로 입력하지 않은 경우
    - [x] 1000원 보다 작은 금액을 입력한 경우 (음수 포함)
- 공백(전처리)
    - [x] 앞, 뒤 공백을 입력한 경우

<br>

### 당첨 번호 (배열)

- 문자열
    - [x] 숫자 이외의 문자를 입력한 경우
    - [x] 하나도 입력하지 않은 경우
- 갯수
    - [x] 6개 미만해서 입력한 경우
    - [x] 6개 초과해서 입력한 경우
- 범위
    - [x] 1~45 범위 내의 숫자를 입력하지 않은 경우
- 중복
    - [x] 중복된 수를 입력한 경우
- 공백(전처리)
    - [x] 구분자로 쉼표(,)를 기준으로 split
    - [x] 앞, 뒤 공백 제거

<br>

### 보너스 번호

- 문자열
    - [x] 숫자 이외의 문자를 입력한 경우
    - [x] 하나도 입력하지 않은 경우
- 갯수
    - [x] 1개 초과해서 입력한 경우
- 범위
    - [x] 1~45 범위 내의 숫자를 입력하지 않은 경우
- 중복
    - [x] 당첨 번호와 중복된 수를 입력한 경우
- 공백(전처리)
    - [x] 앞, 뒤 공백을 입력한 경우

<br>
<br>

## ❐ Domain Modeling

---

### Money

| Type | Field |
|------|-------|
| long | value |

<br>

### RecoveryRatio

| Type       | Field |
|------------|-------|
| BigDecimal | value |

<br>

### Lotto

| Type          | Field   |
|---------------|---------|
| List<Integer> | numbers |

<br>

### Lottos

| Type        | Field  |
|-------------|--------|
| List<Lotto> | lottos |

<br>

### [Enum] RankPolicy

- [TYPE] : FIRST / SECOND / THIRD / FOURTH / FIFTH

| Type                          | Field        |
|-------------------------------|--------------|
| Integer                       | matchedCount |
| BiPredicate<Integer, Boolean> | predicate    |

<br>

### DrawResultRankTable

| Type                   | Field   |
|------------------------|---------|
| EnumMap<Rank, Integer> | results |

<br>
<br>

## ❐ Domain Logic

---

### Money

| Method                       | Parameter          | Return Type | Implementation |
|------------------------------|--------------------|-------------|----------------|
| calculatePurchasedLottoCount | -                  | int         | ✅              |
| addAll                       | List<Money> monies | Money       | ✅              | 
| toBigDecimal                 | -                  | BigDecimal  | ✅              | 
| hasSmallChange               | Money              | boolean     | ✅              | 

<br>

### Lotto

| Method                  | Parameter | Return Type | Implementation |
|-------------------------|-----------|-------------|----------------|
| countMatchedNumbersFrom | Lotto     | int         | ✅              |
| has                     | Integer   | boolean     | ✅              |              

<br>

### Lottos

| Method         | Parameter | Return Type   | Implementation |
|----------------|-----------|---------------|----------------|
| initiateStream | -         | Stream<Lotto> | ✅              |

<br>

### [Enum] RankCondition

| Method                                | Parameter        | Return Type         | Implementation |
|---------------------------------------|------------------|---------------------|----------------|
| getRankBy                             | Integer, Boolean | Rank                | ✅              |
| sortedValuesExceptNone                | -                | List<RankCondition> | ✅              |
| hasEnoughCountToBeSecondRank          | int              | boolean             | ✅              |
| calculateReceivableTotalPrizeAmountBy | int              | Money               | ✅              |

<br>

### RecoveryRatio

| Method | Parameter              | Return Type   | Implementation |
|--------|------------------------|---------------|----------------|
| of     | BigDecimal, BigDecimal | RecoveryRatio | ✅              |

<br>

### DrawResultRankTable

| Method           | Parameter     | Return Type | Implementation |
|------------------|---------------|-------------|----------------|
| updateIfPresent  | RankCondition | -           | ✅              |
| totalPrizeAmount | -             | Money       | ✅              |

<br>
<br>

## ❐ Business Logic

---

### LottoService

| Access  | Method        | Parameter              | Return Type        | Implementation |
|---------|---------------|------------------------|--------------------|----------------|
| public  | offerLottos   | Money                  | Lottos             | ✅              |
| public  | rankMyLottos  | Lottos, Lotto, Integer | LottoDrawRankTable | ✅              |
| private | rankEachLotto | Lottos, Lotto, Integer | RankCondition      | ✅              |

<br>

### StatisticService

| Access | Method             | Parameter                  | Return Type |
|--------|--------------------|----------------------------|-------------|
| public | returnOfInvestment | DrawResultRankTable, Money | EarningRate |
