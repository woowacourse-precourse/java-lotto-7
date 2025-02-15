# java-lotto-precourse

# 🎰 Lotto

## 🔍기본 과제 요약

1. 1000원당 1장의 로또를 발행하며, 각 로또는 1-45 사이의 중복되지 않는 6개 숫자로 구성
2. 당첨 번호(6개)와 보너스 번호(1개)를 입력받아 사용자의 로또와 비교하여 당첨 여부 확인
4. 잘못된 입력값에 대해서는 [ERROR] 메시지를 출력하고 재입력을 받으며, 최종적으로 당첨 내역과 수익률을 출력
   <br/>

## 🔧 미션 구현 방식
1. 입력값 검증
    * 구매 금액 검증 (1000원 단위, 양수)
    * 당첨 번호 형식 검증 (쉼표 구분, 6개 숫자)
    * 보너스 번호 검증 (당첨 번호와 중복x, 1-45 범위)

2. 로또 발행/저장
    * 구매 금액에 따른 로또 수량 계산
    * 각 로또마다 랜덤 번호 생성 (1-45 범위, 중복x)
    * 오름차순 정렬 후 구매 목록 출력

3. 당첨 확인/통계
    * 보유 로또와 당첨 번호 비교
    * 일치하는 번호 개수와 보너스 번호 확인
    * 등수별 당첨 횟수 집계

4. 결과 처리
    * 당첨금 총액 계산
    * 수익률 계산 (소수점 둘째 자리 반올림)
    * 당첨 통계 및 수익률 출력

<br/>

## 📂 파일 구조도
``` 
└─src
    ├─main
    │  └─java
    │      └─lotto
    │          │  Application.java
    │          │
    │          ├─constant
    │          │      ExceptionMessage.java
    │          │      GameConfig.java
    │          │      GameMessage.java
    │          │      Rank.java
    │          │
    │          ├─contoller
    │          │      LottoController.java
    │          │
    │          ├─model
    │          │      Lotto.java
    │          │      RandomLotto.java
    │          │      WinningLotto.java
    │          │
    │          ├─service
    │          │      ProfitCalculatorService.java
    │          │      ResultStatisticsService.java
    │          │
    │          └─view
    │                  InputView.java
    │                  OutputView.java
    │
    └─test
        └─java
            └─lotto
                │  ApplicationTest.java
                │  ControllerTest.java
                │  InputTest.java
                │
                ├─model
                │      LottoTest.java
                │      RankTest.java
                │      WinningLottoTest.java
                │
                └─service
                        ProfitCalculatorServiceTest.java
                        ResultStatisticsServiceTest.java
```


## 📚 패키지 설명

1. **lotto**: 메인 패키지
    - `Application.java`: 프로그램의 시작점, LottoController를 통해 게임 진행
   

2. **constant**: 상수 정의
    - `ExceptionMessage.java`: 예외 처리 관련 메시지
    - `GameConfig.java`: 로또 게임 설정값 (가격, 번호 범위 등)
    - `GameMessage.java`: 사용자 입출력 관련 메시지
    - `Rank.java`: 당첨 등수별 상금과 조건을 정의한 Enum 
   

3. **controller**: 게임 진행 제어
    - `LottoController.java`: 전체 게임 흐름 제어 및 서비스/뷰 연동
   

4. **model**: 데이터 모델
    - `Lotto.java`: 로또 번호 6개 저장 및 유효성 검증
    - `RandomLotto.java`: 랜덤 로또 번호 생성 기능
    - `WinningLotto.java`: 당첨번호 6개와 보너스번호 관리
   

5. **service**: 비즈니스 로직
    - `ProfitCalculatorService.java`: 당첨금 및 수익률 계산
    - `ResultStatisticsService.java`: 당첨 통계 및 등수 집계
   

6. **view**: 사용자 인터페이스
    - `InputView.java`: 구매금액, 당첨번호, 보너스번호 입력 처리
    - `OutputView.java`: 구매 로또 목록, 당첨 통계, 수익률 출력
   
    
# 🚨trouble shooting

## **💭 로또 클래스 설계 고민**
1. **컴포지션 방식 (WinningLotto가 Lotto를 포함)**
* 장점: 느슨한 결합도, 유연한 설계 가능
* 단점: 객체 생성 순서 의존성, 복잡한 초기화 과정
```java
public class WinningLotto {
    private final Lotto lotto; 
    private int bonusNumber;
    
    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
```

2. **상속 방식 (WinningLotto가 Lotto를 상속)**
* 장점: 깔끔한 초기화, 명확한 책임 분리
* 단점: 강한 결합도, 상속의 제약사항
```java
public class WinningLotto extends Lotto {
    private int bonusNumber;
    
    public WinningLotto(List<Integer> numbers) {
        super(numbers); 
    }
}
```

**해결 방법**
* 생성 로직의 응집도가 유지보수성보다 중요
* 상속으로 단순하고 명확한 초기화 과정 구현
* 각 하위 클래스가 자신의 책임에 집중하도록 설계
<br/>

## **🆚 로또 번호 비교 로직 위치 고민**
1. **Lotto 클래스 내부에 위치**
* 장점: 객체지향적 설계, 캡슐화 향상
* 단점: 비교 주체와 대상이 모호해짐


2. **ResultStatisticsService에 위치**
* 장점: 비교 주체와 대상이 명확함
* 단점: 객체의 데이터를 외부에서 처리

**해결 방법**
* 코드의 명확성이 객체지향적 설계보다 중요
* 비즈니스 로직의 의도가 명확히 드러나도록 설계
* 잠재적 오용 가능성 제거 우선
<br/>

## ** 🏆 Enum을 활용한 당첨 등수 관리**

1. **Prize Enum 구현**
```java
public enum Prize {
    // 기본 생성자: 꽝은 상금만 필요
    NONE(0),

    // 전체 생성자: 나머지 등수는 모든 정보 필요
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    // 필드 정의
    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    
    // 전체 데이터용 생성자
    Prize(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    // 상금만 필요한 NONE용 생성자
    Prize(int prize) {
        this(0, false, prize);
    }
}
```
**장점**
* NONE에 불필요한 데이터 제거
* 의도가 명확한 생성자 분리
* 데이터 최적화와 가독성 향상

2. **등수 판정 로직**
* Enum 내부에 판정 로직을 포함하여 응집도 향상
```java
    public static Rank getRank(int matchCount, boolean isBonusMatched) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && isBonusMatched) return SECOND;
        if (matchCount == 5 && !isBonusMatched) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }
```

3. **출력 처리**
* Enum의 values()를 활용한 순차적 출력
```java
public static void printWinningResults(Map<Rank, Integer> prizeResults) {
    for (Rank prize : Rank.values()) {
        if (prize == Rank.NONE) {
            continue;
        }
        String resultMessage = GameMessage.MATCH_RESULT_FORMAT;
        if (prize.isBonusMatched()) {
            resultMessage = GameMessage.MATCH_BONUS_RESULT_FORMAT;
        }
        System.out.println(String.format(
                resultMessage,
                prize.getCorrectNumberCount(),
                prize.getPrize(),
                prizeResults.getOrDefault(prize,0)));
    }
}
```

**장점**
* 당첨 정보의 중앙 관리
* 등수 판정과 출력 로직 단순화
* 새로운 등수 추가가 용이한 확장성
<br/>

## **✅ 유효성 검증 책임 분리**

1. **InputView - 입력 형식 검증**
```java
public class InputView {
    public static int readPurchasePrice() {
        String purchasePrice = Console.readLine();
        if (!purchasePrice.matches(GameConfig.VALID_DIGIT_LENGTH_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.MAX_AMOUNT_ERROR);
        }

        if (!purchasePrice.matches(GameConfig.VALID_UNIT_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT_ERROR);
        }
        return Integer.parseInt(purchasePrice);
    }
}
```

2. **Model - 도메인 규칙 검증**
```java
public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers.stream().sorted().toList();
}

private void validate(List<Integer> numbers) {
    if (numbers.size() != GameConfig.LOTTO_NUMBERS_COUNT) {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE_ERROR);
    }
    for(int number: numbers){
        if(number < GameConfig.MIN_RANGE_NUMBER || number > GameConfig.MAX_RANGE_NUMBER ){
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER_ERROR);
        }
    }
    HashSet<Integer> duplicate = new HashSet<>(numbers);
    if(duplicate.size() != GameConfig.LOTTO_NUMBERS_COUNT){
        throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_ERROR);
    }
}
```

**장점**
* 책임의 명확한 분리
* 각 계층별 관심사 분리
* 유지보수성과 재사용성 향상

## **💫 당첨 번호 비교 알고리즘 설계**

1. **List를 사용한 비교 방식**
```java
// 시간 복잡도 O(n²)
public int countMatches(List<Integer> purchased, List<Integer> winning) {
    return (int) purchased.stream()
            .filter(winning::contains)
            .count();
}
```

2. **Set을 사용한 비교 방식**
```java
// 시간 복잡도 O(n), 공간 복잡도 O(n)
public class Lotto {
    private final Set<Integer> numbers;  // Set으로 저장
    
    public int countMatches(Set<Integer> winning) {
        return (int) numbers.stream()
                .filter(winning::contains)  // O(1) 검색
                .count();
    }
}
```

**선택 이유**
* 시간 효율성 중요: Set의 contains는 O(1)
* 잦은 조회 연산: 모든 구매 로또와 당첨 번호 비교
* 메모리 사용 증가는 미미함

**추가 이점**
* 중복 검사도 O(1)로 가능
* 코드 단순화 및 가독성 향상
