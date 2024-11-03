# java-lotto-precourse

## 로또

### 기능 요구 사항
- 간단한 로또 발매기를 구현한다.
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

### 입출력 요구사항 및 프로그래밍 요구사항
**입력**
- 구입 금액(구입 금액이 1000원 단위가 아닌 경우 예외 처리)
- 당첨 번호(쉽표 기준으로 구분)
- 보너스 번호

**출력**
- 구매 수량 ex) "3개를 구매했습니다."
- 로또 번호 목록(오름차순 정렬)
- 수익률(소수점 둘째 자리에서 반올림)

**프로그래밍 요구사항**
- indent 2이하
- 3항 연산자 사용X
- 함수가 한 가지 일만 하도록 최대한 작게 구현
- 테스트 코드 구현(JUnit, AssertJ 사용)
- 함수의 길이가 15라인 미만
- else 예약어 사용X
- Java Enum 사용
- 구현한 기능에 대해 단위 테스트 작성

---

### 기능 정리
- [x] 구입 금액 입력
  - [x] 숫자가 아닌 경우 예외 처리
  - [x] 1000원 단위가 아닐 경우 예외 처리
  - [x] Exception 발생시 에러 메시지 출력 후 다시 입력 받기
  - [x] 테스트
- [x] 로또 발행
  - [x] 구입 금액 / 1000의 개수만큼 로또 발행
  - [x] 1~45까지의 숫자 중 중복되지 않는 6개의 숫자 뽑아 개수만큼 로또 발행
  - [x] 로또 번호 오름차순 정렬
  - [x] 테스트
- [x] 당첨 번호 입력
  - [x] 숫자가 아닌 경우 예외 처리
  - [x] 1~45 사이의 숫자가 아닌 경우 예외 처리
  - [x] 중복된 숫자가 있는 경우 예외 처리
  - [x] 6자리가 아닌 경우 예외 처리
  - [x] Exception 발생시 에러 메시지 출력 후 다시 입력 받기
  - [x] 테스트
- [x] 보너스 번호 입력
  - [x] 숫자가 아닌 경우 예외 처리
  - [x] 1~45 사이의 숫자가 아닌 경우 예외 처리
  - [x] 당첨 번호와 중복된 경우 예외 처리
  - [x] Exception 발생시 에러 메시지 출력 후 다시 입력 받기
  - [x] 테스트
- [x] 로또 결과 확인
  - [x] 당첨 번호와 로또 번호 비교
  - [x] 1등부터 5등까지 당첨 여부 확인
  - [x] 테스트
- [x] 결과 출력
  - [x] 로또 결과 출력
  - [x] 수익률 출력
  - [x] 테스트

### 코드 설명
- generic을 사용하여 함수를 인자로 받아 에러를 처리하고 다시 실행하는 repeatUntilValid 함수를 구현
```java
public class Application {
    private static <R> R repeatUntilValid(Supplier<R> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.printf("%s\n\n", e.getMessage());
            return repeatUntilValid(function);
        }
    }
}
```

- 정수 타입 변경시 에러를 사용자 하기 위해 parseIntWithIllegalArgumentException 함수 구현
```java
public class Application {
    private static int parseIntWithIllegalArgumentException(String value, String message) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
```

- 금액을 입력받아 정수로 변환하여 반환
```java
public class Application {
    private static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountString = Console.readLine();
        System.out.println();
        int purchaseAmount = parseIntWithIllegalArgumentException(purchaseAmountString, "[ERROR] 구입 금액은 숫자여야 합니다.");
        if (purchaseAmount % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        return purchaseAmount;
    }
}
```

- 사용자에게 총금액을 받아 구매 수량을 계산 후, 로또를 생성 (Lotto클래스에 Static 함수 create를 구현하여 간단하게 생성할 수 있도록 구현)
```java
public class Lotto {
  ...
    public static Lotto create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .toList();
        return new Lotto(numbers);
    }
  ...
}

public class Application {
    private static List<Lotto> buyLottos(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        List<Lotto> lottoList = IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.create())
                .toList();
        lottoList.forEach(System.out::println);
        System.out.println();
        return lottoList;
    }
}
```

- 당첨번호와 보너스 번호를 입력받고 당첨 번호를 저장하는 WinningLotto 객체를 생성
```java
public class Application {
    private static WinningLotto readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersString = Console.readLine();
        System.out.println();
        String[] winningNumberStringArray = winningNumbersString.replaceAll(" ", "").split(",");
        List<Integer> winningNumbers = Stream.of(winningNumberStringArray)
                .map(number -> parseIntWithIllegalArgumentException(number, "[ERROR] 당첨 번호는 숫자여야 합니다."))
                .toList();
        return new WinningLotto(winningNumbers);
    }

    private static WinningLotto readBonusNumber(WinningLotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberString = Console.readLine();
        System.out.println();
        int bonusNumber = parseIntWithIllegalArgumentException(bonusNumberString, "[ERROR] 보너스 번호는 숫자여야 합니다.");
        winningLotto.setBonusNumber(bonusNumber);
        return winningLotto;
    }
}
```

- enum을 사용하여 LottoResult를 구현하여 등수를 객체로 반환받도록 구현
```java
public enum LottoResult {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    NONE(0, 0, "");
  ...
}
public class Application {
    private static List<LottoResult> getLottoResults(WinningLotto winningLotto, List<Lotto> lottoList) {
        return lottoList.stream()
                .map(winningLotto::match)
                .toList();
    }
}
```

- lottoResult별 개수를 반환하는 함수 구현
```java
public class Application {
    private static Map<LottoResult, Integer> getLottoResultCounts(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .collect(Collectors.groupingBy(result -> result))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }
}
```

- 결과 출력하는 함수 구현
```java
public class Application {
    private static void printLottoResult(int purchaseAmount, List<LottoResult> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<LottoResult> printSequence = LottoResult.values.stream()
                .filter(result -> result != LottoResult.NONE)
                .toList();
        Map<LottoResult, Integer> lottoResultCount = getLottoResultCounts(lottoResults);
        int totalPrize = printSequence.stream()
                .mapToInt(result -> {
                    int count = lottoResultCount.getOrDefault(result, 0);
                    System.out.printf("%s - %d개\n", result.getDescription(), count);
                    return result.getPrize() * count;
                }).sum();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (double) totalPrize / purchaseAmount * 100);
    }
}
```