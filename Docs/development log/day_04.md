# Day 04 (2024.11.03.)

## 목차
* [로또 입력받기](./day_04.md#로또-입력받기)
    * [로또 당첨 번호 입력받기](./day_04.md#로또-당첨-번호-입력받기)
    * [로또 보너스 번호 입력받기](./day_04.md#로또-보너스-번호-입력받기)
* [Enum 정의하기](./day_04.md#enum-정의하기)
    * [로또 당첨 기준 Enum 정의하기](./day_04.md#로또-당첨-기준-enum-정의하기)
* [로또 당첨 여부 체크하기](./day_04.md#로또-당첨-여부-체크하기)
* [수익률 계산하기](./day_04.md#수익률-계산하기)
* [To do List](./day_04.md#to-do-list)

## [로또 입력받기](./day_04.md#목차)

### [로또 당첨 번호 입력받기](./day_04.md#목차)

#### Production Code

```java
public Lotto setWinningLotto(String inputValue) {
        return new Lotto(getNumbers(inputValue));
    }

private List<Integer> getNumbers(String inputValue) {
    String delimiter = ",";
    Set<Integer> inputNumbers = new HashSet<>();
    String[] splitInputValue = inputValue.split(delimiter);
    for (String value: splitInputValue) {
        inputNumbers.add(convertStringToNumber(value));
    }

    if (inputNumbers.size() != 6) {
        throw new IllegalArgumentException("[Error] 중복되지 않은 입력 번호가 6개이어야 합니다. 입력된 번호 개수: " + inputNumbers.size());
    }

    List<Integer> numbers = new ArrayList<>(inputNumbers);
    Collections.sort(numbers);
    return numbers;
}

private int convertStringToNumber(String value) {
    try {
        int number = Integer.parseInt(value.strip());
        if (0 < number && number <= 45) {
            return number;
        }
        throw new IllegalArgumentException("[Error] 당첨 번호는 1 이상 45 이하의 번호만 가능합니다. 입력 번호: " + number);
    } catch (NumberFormatException exception) {
        throw new NumberFormatException("[Error] 번호가 아닌 값을 입력받았습니다. 입력 값: " + value);
    }
}
```
<br>

#### Test Code

```java
@ParameterizedTest
@CsvFileSource(resources = "/winningLottoTestFile.csv")
void 당첨_번호_입력_테스트(String inputValue, String expected) {
    Lotto winningLotto = lottoService.setWinningLotto(inputValue);
    assertEquals(expected, winningLotto.getNumbersString());
}

@ParameterizedTest
@CsvFileSource(resources = "/winningLottoExceptionTestFile.csv")
void 당첨_번호_입력_예외_테스트(String inputValue) {
    assertThrows(IllegalArgumentException.class, () -> {
        lottoService.setWinningLotto(inputValue);
    });
}
```
<br><br>

### [로또 보너스 번호 입력받기](./day_04.md#목차)

#### Production Code

```java
private static void setBounsNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
    String inputValue = Console.readLine();
    try {
        bounsNumber = Integer.parseInt(inputValue.strip());
        if (1 > bounsNumber || 45 < bounsNumber) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 1 이상 45 이하이어야 합니다. 입력된 값: " + bounsNumber);
        }
        if (winningLotto.existsNumber(bounsNumber)) {
            throw new IllegalArgumentException("[Error] 입력된 보너스 번호가 당첨 번호에 포함되어 있습니다. 입력된 값: " + bounsNumber);
        }
    } catch (IllegalArgumentException exception) {
        throw new IllegalArgumentException("[Error] 잘못된 값을 입력받았습니다. 입력된 보너스 번호 값: " + inputValue);
    }
}
```

<br>

## [Enum 정의하기](./day_04.md#목차)

### [로또 당첨 기준 Enum 정의하기](./day_04.md#목차)

```java
public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int getPrize;

    LottoRank(int matchCount, int getPrize) {
        this.matchCount = matchCount;
        this.getPrize = getPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getGetPrize() {
        return getPrize;
    }
}
```

<br>

## [로또 당첨 여부 체크하기](./day_04.md#목차)

### Production Code

```java
// Lotto.java
public int getCount(Lotto lotto) {
    int count = 0;
    for (Integer num : lotto.numbers) {
        if(existsNumber(num))   count++;
    }

    return count;
}
```

```java
// LottoService.java
public int[] getWinningCount(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
    int[] counts = new int[LottoRank.values().length];

    for (Lotto issueLotto: lottos) {
        LottoRank rank = getLottoRank(issueLotto, winningLotto, bonusNumber);
        counts[rank.ordinal()]++;
    }

    return counts;
}

public LottoRank getLottoRank(Lotto issueLotto, Lotto winningLotto, int bonusNumber) {
    int matchCount = issueLotto.getCount(winningLotto);
    boolean existBonusNumber = issueLotto.existsNumber(bonusNumber);
    return getLottoRank(matchCount, existBonusNumber);
}

private LottoRank getLottoRank(int matchCount, boolean existBonusNumber) {
    if(matchCount == 5) {
        if (existBonusNumber) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    for (LottoRank rank : LottoRank.values()) {
        if(matchCount == rank.getMatchCount()) {
            return rank;
        }
    }

    return LottoRank.NONE;
}
```

<br>

### Test Code
```java
@Test
void 로또_당첨_테스트() {
    Lotto issueLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int bonusNumber = 7;

    assertEquals(LottoRank.SECOND, lottoService.getLottoRank(issueLotto, winningLotto, bonusNumber));
}
```

<br>

## [수익률 계산하기](./day_04.md#목차)

### Production Code

```java
// Application.java
private static void printIncomePercent(List<Lotto> lottos, int[] winningCount) {
    long income = lottoService.getWinningCost(winningCount);
    double incomePercent = Math.round((double)income / lottos.size());

    System.out.println("총 수익률은 " + incomePercent + "%입니다.");
}
```

```java
// LottoService.java
public long getWinningCost(int[] counts) {
    long cost = 0L;
    for (LottoRank rank : LottoRank.values()) {
        cost += (long)counts[rank.ordinal()] * rank.getGetPrize();
    }

    return cost;
}
```

<br>

## [To do List](./day_04.md#목차)

- [x] 로또 발행하기
    - [x] 로또 발급 개수 확인하기
    - [x] 중복되지 않는 6개의 숫자 뽑기
- [x] 사용자 입력 받기
    - [x] 로또 구입 금액 입력받기
    - [x] 로또 당첨 번호 입력받기
    - [x] 로또 보너스 번호 입력받기
- [x] ~~로또 당첨 기준 적용하기~~ Enum 정의로 해결
- [x] 로또 당첨 여부 체크하기
- [ ] ~~커스텀 Exception 생성하기~~
- [ ] Enum 정의하기
    - [x] 로또 당첨 기준 Enum 정의하기
    - [ ] 에러 메시지 Enum 정의하기
- [x] 수익률 계산하기
- [ ] 에러 후 다시 입력하게 기능 변경