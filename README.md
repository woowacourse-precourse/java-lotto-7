<div align="center">

<h1>java-lotto-precourse</h1>

<br />

</div>

<br />

## 학습 목표
```markdown
📝 관련 함수를 클래스로 묶어, 객체들이 협력하여 하나의 큰 기능을 수행하도록 구성한다.
📝 클래스와 함수에 대한 단위 테스트를 통해 기능의 정확성을 확보한다.
📝 2주 차 공통 피드백을 최대한 반영하여 개선한다.
```

<br />

# 목차

### [0. 요구사항 분석](#요구사항-분석)

### [1. 구현](#구현)

### [2. 테스트](#테스트)

### [3. 실수 회고](#실수-회고)

<br />

# 요구사항 분석

## 과제 진행 요구사항
1. 미션은 로또 저장소를 포크하고 클론하는 것으로 시작
2. 기능 구현 전 README.md에 구현할 기능 목록을 작성하고 커밋 단위를 설정
3. AngularJS Git Commit Message Conventions을 참고하여 커밋 메시지를 작성
4. JDK 21 환경에서 실행되도록 구현하고, 프로그램의 시작점은 `Application`의 `main()` 메서드로 설정

## 기능 요구사항
> 간단한 로또 발매기를 구현
- **로또 구입 및 발행**
  - 로또 번호는 1~45 범위의 중복되지 않은 6개의 숫자로 구성된
  - 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 무작위로 설정
  - 사용자는 로또 구입 금액을 입력하며, 구입 금액에 따라 발행할 로또의 수량이 결정
  - 로또 1장의 가격은 1,000원이며, 구입 금액은 반드시 1,000원 단위
  - 구입 금액을 1,000원으로 나눈 값에 해당하는 만큼 로또 티켓을 발행
- **당첨 번호 및 보너스 번호**
  - 당첨 번호 추첨 시, 중복되지 않는 숫자 6개와 보너스 번호 1개를 입력
  - 당첨 번호와 보너스 번호는 사용자 입력을 통해 설정
- **당첨 기준 및 상금**
  - 당첨은 1등부터 5등까지 있으며, 등수에 따른 상금
    - 1등: 6개 번호 일치 → 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 → 30,000,000원
    - 3등: 5개 번호 일치 → 1,500,000원
    - 4등: 4개 번호 일치 → 50,000원
    - 5등: 3개 번호 일치 → 5,000원
- **당첨 결과 확인**
  - 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 각 등수에 맞는 당첨 내역을 계산
  - 당첨 내역에 따라 총 수익률을 계산하여 출력
  - 수익률은 소수점 둘째 자리에서 반올림하여 출력 (예: 62.5%).
- **에러 처리**
  - 사용자가 잘못된 값을 입력할 경우, IllegalArgumentException을 발생
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리
  - 에러 메시지는 [ERROR]로 시작해야 하며, 해당 에러 이후부터 입력을 다시 받는다.
  - 가능한 예외 상황
    - 로또 번호 범위 오류: 번호가 1~45 범위를 벗어난 경우
    - 중복 번호 오류: 로또 번호나 보너스 번호가 중복되는 경우
    - 구입 금액 오류: 구입 금액이 1,000원 단위가 아닐 경우

## 프로그래밍 요구사항
- `indent` depth는 2까지만 허용
- 3항 연산자 사용 불가
- `System.exit()` 호출 불가
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현
- `JUnit 5`와 `AssertJ`를 이용해 단위 테스트를 작성하고, 구현한 기능을 테스트로 검증
  - 작은 단위 테스트부터 작성 후, 큰 단위 테스트를 작성
- Java Enum을 적용하여 프로그램을 구현
- else 예약어 사용 불가
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 사용 불가
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 가능
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
- `Lotto` 클래스를 수정하여 구현하되, `numbers` 필드 외에는 추가 필드를 추가할 수 없음

<br />

# 구현

## 구현해야 할 기능 목록

### 1. **입력 및 유효성 검사**
- [x] **로또 구입 금액 입력**
  - [x] 사용자가 구입 금액을 입력받고, 구입 금액이 1,000원 단위인지 확인한다.
  - [x] 구입 금액이 1,000원 단위가 아니면 IllegalArgumentException을 발생시키고 `[ERROR]` 메시지 출력 후 재입력 받는다.
- [x] **당첨 번호와 보너스 번호 입력**
  - [x] 사용자로부터 당첨 번호 6개를 입력받고, 중복되지 않고 1~45 범위 내의 값인지 확인한다.
  - [x] 보너스 번호를 입력받고, 당첨 번호와 중복되지 않으며 1~45 범위 내의 값인지 확인한다.
  - [x] 유효성에 어긋나는 경우 IllegalArgumentException을 발생시키고 `[ERROR]` 메시지 출력 후 재입력 받는다.

### 2. **로또 발행 및 번호 생성**
- [x] **로또 티켓 수량 계산**
  - [x] 사용자가 입력한 구입 금액에 따라 발행할 로또 티켓 수량을 계산한다. (예: 8,000원 입력 시 8장 발행)
- [x] **로또 번호 생성**
  - [x] 각 로또 티켓마다 중복되지 않은 6개의 번호를 1~45 범위에서 무작위로 생성한다.
  - [x] `Randoms.pickUniqueNumbersInRange()` 함수를 사용하여 번호를 생성하고, 로또 번호는 오름차순으로 정렬하여 출력한다.
- [x] **로또 티켓 출력**
  - [x] 발행된 모든 로또 티켓의 번호를 콘솔에 출력한다.

### 3. **당첨 확인 및 당첨 내역 계산**
- [x] **로또 번호와 당첨 번호 비교**
  - [x] 사용자가 발행한 각 로또 티켓의 번호를 당첨 번호 및 보너스 번호와 비교하여 일치하는 숫자 개수를 계산한다.
- [x] **당첨 내역 계산**
  - [x] 일치하는 개수와 보너스 번호 포함 여부에 따라 각 티켓의 등수를 결정한다.
  - [x] 당첨 기준:
    - 1등: 6개 번호 일치
    - 2등: 5개 번호 + 보너스 번호 일치
    - 3등: 5개 번호 일치
    - 4등: 4개 번호 일치
    - 5등: 3개 번호 일치
  - [x] 각 등수별 당첨된 로또 수량을 집계하고, 당첨 내역을 콘솔에 출력한다.

### 4. **수익률 계산 및 출력**
- [x] **총 수익 계산**
  - [x] 각 등수에 해당하는 상금 금액을 사용하여 총 수익을 계산한다.
    - 1등: 2,000,000,000원
    - 2등: 30,000,000원
    - 3등: 1,500,000원
    - 4등: 50,000원
    - 5등: 5,000원
- [x] **수익률 계산**
  - [x] 총 수익과 구입 금액을 바탕으로 수익률을 계산한다.
  - [x] 수익률은 소수점 둘째 자리에서 반올림하여 출력한다 (예: 62.5%).

### 5. **에러 처리 및 예외 상황 대응**
- [x] **[ERROR] 메시지 출력 및 재입력**
  - [x] 사용자가 입력한 값이 유효하지 않은 경우(범위 초과, 중복 번호, 1,000원 단위가 아닌 금액 등), IllegalArgumentException을 발생시키고 `[ERROR]` 메시지를 출력한다.
  - [x] 에러가 발생한 이후 해당 단계부터 다시 입력받도록 처리한다.
- [x] **명확한 예외 처리**
  - [x] `IllegalArgumentException`, `IllegalStateException` 등을 사용하여 명확한 예외 상황을 구분하여 처리한다.

<br />

# 테스트
- **테스트 코드**

```java
/* ApplicationTest.java */
@DisplayName("전체 로직 테스트")
@Test
void 기능_테스트() {
    assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("8000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                        "8개를 구매했습니다.",
                        "[8, 21, 23, 41, 42, 43]",
                        "[3, 5, 11, 16, 32, 38]",
                        "[7, 11, 16, 35, 36, 44]",
                        "[1, 8, 11, 31, 41, 42]",
                        "[13, 14, 16, 38, 42, 45]",
                        "[7, 11, 30, 40, 42, 43]",
                        "[2, 13, 22, 32, 38, 45]",
                        "[1, 3, 5, 14, 22, 45]",
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 0개",
                        "총 수익률은 62.5%입니다."
                );
            },
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44),
            List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45),
            List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(1, 3, 5, 14, 22, 45)
    );
}

@DisplayName("전체 로직 테스트 - 6개 번호 일치로 1등 당첨 시")
@Test
void 전체_로직_1등_테스트() {
    assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                        "3개를 구매했습니다.",
                        "[1, 2, 3, 4, 5, 6]",
                        "[7, 8, 9, 10, 11, 12]",
                        "[13, 14, 15, 16, 17, 18]",
                        "3개 일치 (5,000원) - 0개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 1개",
                        "총 수익률은 66,666,666.7%입니다."
                );
            },
            List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(13, 14, 15, 16, 17, 18)
    );
}

@DisplayName("전체 로직 테스트 - 5개 + 보너스 번호 일치로 2등 당첨 시")
@Test
void 전체_로직_2등_테스트() {
    assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("5000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                        "5개를 구매했습니다.",
                        "[1, 2, 3, 4, 5, 8]",  // 5개 번호 일치
                        "[1, 2, 3, 4, 5, 7]",  // 5개 + 보너스 번호 일치
                        "[11, 12, 13, 14, 15, 16]",
                        "[21, 22, 23, 24, 25, 26]",
                        "[31, 32, 33, 34, 35, 36]",
                        "3개 일치 (5,000원) - 0개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 0개",
                        "총 수익률은 630,000.0%입니다."
                );
            },
            List.of(1, 2, 3, 4, 5, 8),
            List.of(1, 2, 3, 4, 5, 7),
            List.of(11, 12, 13, 14, 15, 16),
            List.of(21, 22, 23, 24, 25, 26),
            List.of(31, 32, 33, 34, 35, 36)
    );
}

@DisplayName("구입 금액 입력 예외 테스트 - 숫자 형식이 아닌 경우")
@Test
void 예외_테스트() {
    assertSimpleTest(() -> {
        runException("1000j");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_NUMBER);
    });
}

@DisplayName("구입 금액 입력 예외 테스트 - 1,000원 단위가 아닌 경우")
@Test
void 구입_금액_단위_예외_테스트() {
    assertSimpleTest(() -> {
        runException("1050");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_1000);
    });
}

@DisplayName("당첨 번호 입력 예외 테스트 - 숫자가 아닌 경우")
@Test
void 당첨_번호_숫자_예외_테스트() {
    assertSimpleTest(() -> {
        runException("5000", "1,2,3,4,5,A", "7");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_NUMBER);
    });
}

@DisplayName("당첨 번호 입력 예외 테스트 - 6개가 아닌 경우")
@Test
void 당첨_번호_개수_예외_테스트() {
    assertSimpleTest(() -> {
        runException("5000", "1,2,3,4,5", "7");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_WIN6);
    });
}

@DisplayName("당첨 번호 입력 예외 테스트 - 1-45 범위를 벗어나는 경우")
@Test
void 당첨_번호_범위_예외_테스트() {
    assertSimpleTest(() -> {
        runException("5000", "0,1,2,3,4,5", "7");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_MATCH);
    });
}

@DisplayName("당첨 번호 입력 예외 테스트 - 중복된 번호가 있는 경우")
@Test
void 당첨_번호_중복_예외_테스트() {
    assertSimpleTest(() -> {
        runException("5000", "1,2,2,4,5,6", "7");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_DISTINCT);
    });
}

@DisplayName("보너스 번호 입력 예외 테스트 - 범위를 벗어나는 경우")
@Test
void 보너스_번호_범위_예외_테스트() {
    assertSimpleTest(() -> {
        runException("5000", "1,2,3,4,5,6", "46");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_MATCH);
    });
}

@DisplayName("보너스 번호 입력 예외 테스트 - 숫자 형식이 아닌 경우")
@Test
void 보너스_번호_숫자_형식_예외_테스트() {
    assertSimpleTest(() -> {
        runException("5000", "1,2,3,4,5,6", "abc");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_NUMBER);
    });
}
```

```java
/* LottoGameTest.java */
@DisplayName("금액 입력 시 1000원 단위가 아니면 예외가 발생해야 한다.")
@Test
void 금액_입력_시_1000원_단위가_아니면_예외가_발생해야_한다() {
    assertThatThrownBy(() -> lottoGame.purchaseTicket(2500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위로 입력 해야 합니다.");
}

@DisplayName("정상적인 금액 입력으로 로또 티켓이 발행되는지 테스트")
@Test
void 정상적인_금액_입력으로_로또_티켓이_발행되는지_테스트() {
    lottoGame.purchaseTicket(3000);

    assertThat(lottoGame.getTickets().size()).isEqualTo(3);
}

@DisplayName("당첨 번호를 설정할 수 있는지 테스트")
@Test
void 당첨_번호를_설정할_수_있는지_테스트() {
    lottoGame.setWinningNumber(List.of(1, 2, 3, 4, 5, 6));

    assertThat(lottoGame.calculateResult().getResults()).isNotNull();
}

@DisplayName("보너스 번호를 설정할 수 있는지 테스트")
@Test
void 보너스_번호를_설정할_수_있는지_테스트() {
    lottoGame.setBonusNumber(7);

    assertThat(lottoGame.calculateResult().getResults()).isNotNull();
}

@DisplayName("정확한 당첨 결과를 계산하는지 테스트")
@Test
void 정확한_당첨_결과를_계산하는지_테스트() {
    lottoGame.purchaseTicket(2000);

    List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    lottoGame.setWinningNumber(winningNumber);
    lottoGame.setBonusNumber(bonusNumber);

    // 구매한 티켓 중 1등, 2등, 3등이 될 수 있도록 강제 설정 (테스트 용도)
    lottoGame.getTickets().clear();
    lottoGame.getTickets().add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
    lottoGame.getTickets().add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등 (보너스)
    lottoGame.getTickets().add(new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 3등

    LottoResult result = lottoGame.calculateResult();

    Map<WinningRank, Integer> resultMap = result.getResults();
    assertThat(resultMap.getOrDefault(WinningRank.FIRST, 0)).isEqualTo(1);
    assertThat(resultMap.getOrDefault(WinningRank.SECOND, 0)).isEqualTo(1);
    assertThat(resultMap.getOrDefault(WinningRank.THIRD, 0)).isEqualTo(1);
    assertThat(resultMap.getOrDefault(WinningRank.FOURTH, 0)).isEqualTo(0);
    assertThat(resultMap.getOrDefault(WinningRank.FIFTH, 0)).isEqualTo(0);
}
```

```java
/* LottoResultTest.java */
@DisplayName("각 당첨 결과를 올바르게 기록하는지 테스트")
@Test
void 각_당첨_결과를_올바르게_기록하는지_테스트() {
    // 1등 1개, 3등 2개, 5등 1개 기록
    lottoResult.record(WinningRank.FIRST);
    lottoResult.record(WinningRank.THIRD);
    lottoResult.record(WinningRank.THIRD);
    lottoResult.record(WinningRank.FIFTH);

    Map<WinningRank, Integer> results = lottoResult.getResults();

    assertThat(results.getOrDefault(WinningRank.FIRST, 0)).isEqualTo(1);
    assertThat(results.getOrDefault(WinningRank.SECOND, 0)).isEqualTo(0);
    assertThat(results.getOrDefault(WinningRank.THIRD, 0)).isEqualTo(2);
    assertThat(results.getOrDefault(WinningRank.FOURTH, 0)).isEqualTo(0);
    assertThat(results.getOrDefault(WinningRank.FIFTH, 0)).isEqualTo(1);
}

@DisplayName("총 상금을 정확하게 계산하는지 테스트")
@Test
void 총_상금을_정확하게_계산하는지_테스트() {
    lottoResult.record(WinningRank.FIRST);
    lottoResult.record(WinningRank.THIRD);
    lottoResult.record(WinningRank.THIRD);
    lottoResult.record(WinningRank.FIFTH);

    // 총 상금 계산: 2,000,000,000 + 1,500,000 * 2 + 5,000 = 2,003,005,000
    assertThat(lottoResult.totalPrize()).isEqualTo(2003005000);
}

@DisplayName("아무 당첨 결과가 없을 때 상금은 0이어야 한다.")
@Test
void 아무_당첨_결과가_없을_때_상금은_0이어야_한다() {
    int totalPrize = lottoResult.totalPrize();

    assertThat(totalPrize).isEqualTo(0);
}
```

```java
/* LottoTest.java */
@Test
void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
}

@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
@Test
void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
}

@DisplayName("로또 번호가 오름차순으로 정렬되는지 확인한다.")
@Test
void 로또_번호가_오름차순으로_정렬되는지_확인한다() {
    Lotto lotto = new Lotto(List.of(42, 8, 23, 21, 43, 41));

    assertThat(lotto.getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
}

@DisplayName("로또 번호와 당첨 번호 간의 일치하는 숫자 개수를 반환한다.")
@Test
void 로또_번호와_당첨_번호_간의_일치하는_숫자_개수를_반환한다() {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto winningNumber = new Lotto(List.of(1, 2, 3, 10, 11, 12));

    int matchCount = lotto.matchCount(winningNumber);

    assertThat(matchCount).isEqualTo(3);
}

@DisplayName("모든 번호가 일치하지 않는 경우 0을 반환해야 한다.")
@Test
void 모든_번호가_일치하지_않는_경우_0을_반환해야_한다() {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto winningNumber = new Lotto(List.of(13, 14, 15, 10, 11, 12));

    int matchCount = lotto.matchCount(winningNumber);

    assertThat(matchCount).isEqualTo(0);
}
```

```java
/* WinningRankTest.java */
@DisplayName("matchRank 메서드가 정확히 일치하는 랭크를 반환하는지 테스트")
@Test
void matchRank_메서드가_정확히_일치하는_랭크를_반환하는지_테스트() {
    // 1등 테스트: 6개 일치, 보너스 미포함
    assertThat(WinningRank.matchRank(6, false)).isEqualTo(WinningRank.FIRST);

    // 2등 테스트: 5개 일치, 보너스 포함
    assertThat(WinningRank.matchRank(5, true)).isEqualTo(WinningRank.SECOND);

    // 3등 테스트: 5개 일치, 보너스 미포함
    assertThat(WinningRank.matchRank(5, false)).isEqualTo(WinningRank.THIRD);

    // 4등 테스트: 4개 일치, 보너스 무관
    assertThat(WinningRank.matchRank(4, false)).isEqualTo(WinningRank.FOURTH);

    // 5등 테스트: 3개 일치, 보너스 무관
    assertThat(WinningRank.matchRank(3, false)).isEqualTo(WinningRank.FIFTH);

    // 일치하는 랭크가 없을 경우 null 반환 테스트
    assertThat(WinningRank.matchRank(2, false)).isNull();
}

@DisplayName("getPrize 메서드가 정확한 상금을 반환하는지 테스트")
@Test
void getPrize_메서드가_정확한_상금을_반환하는지_테스트() {
    assertThat(WinningRank.FIRST.getPrize()).isEqualTo(2000000000);
    assertThat(WinningRank.SECOND.getPrize()).isEqualTo(30000000);
    assertThat(WinningRank.THIRD.getPrize()).isEqualTo(1500000);
    assertThat(WinningRank.FOURTH.getPrize()).isEqualTo(50000);
    assertThat(WinningRank.FIFTH.getPrize()).isEqualTo(5000);
}

@DisplayName("getMatchCount 메서드가 정확한 일치 개수를 반환하는지 테스트")
@Test
void getMatchCount_메서드가_정확한_일치_개수를_반환하는지_테스트() {
    assertThat(WinningRank.FIRST.getMatchCount()).isEqualTo(6);
    assertThat(WinningRank.SECOND.getMatchCount()).isEqualTo(5);
    assertThat(WinningRank.THIRD.getMatchCount()).isEqualTo(5);
    assertThat(WinningRank.FOURTH.getMatchCount()).isEqualTo(4);
    assertThat(WinningRank.FIFTH.getMatchCount()).isEqualTo(3);
}
```

> 아래의 출력 결과처럼 27개의 단위 테스트가 잘 됐음을 알 수 있다.

<img src="https://github.com/user-attachments/assets/9355431d-5278-459a-a126-45045620bfac" width="700;" alt="">

<br />

# 실수 회고

> 과제 수행 중 발생한 실수와 해결 방법에 대한 기록

- **실수 코드**
```java
public void printResult(LottoResult result, int amount) {
    System.out.println("당첨 통계");
    System.out.println("---");
    for (WinningRank rank : WinningRank.values()) {
        int count = result.getResults().getOrDefault(rank, 0);
        String matchMessage = formatMatchMessage(rank);
        System.out.println(matchMessage + " (" + formatPrize(rank.getPrize()) + "원) - " + count + "개");
    }
    long totalPrize = result.totalPrize();
    double rate = (double) totalPrize / amount;
    System.out.println("총 수익률은 " + Math.round(rate * 100 * 100) / 100.0 + "%입니다.");
}
```

- **개선된 코드**
```java
// 당첨 결과 출력 메소드
public void printResult(LottoResult result, int amount) {
    System.out.println("당첨 통계");
    System.out.println("---");
    printWinningRanks(result);
    printTotalProfitRate(result, amount);
}

// 당첨 순위별 결과 출력 메소드
private void printWinningRanks(LottoResult result) {
    for (WinningRank rank : WinningRank.values()) {
        int count = result.getResults().getOrDefault(rank, 0);
        String matchMessage = formatMatchMessage(rank);
        System.out.println(matchMessage + " (" + formatPrize(rank.getPrize()) + "원) - " + count + "개");
    }
}

// 수익률 계산 및 출력 메소드
private void printTotalProfitRate(LottoResult result, int amount) {
    long totalPrize = result.totalPrize();
    double rate = (double) totalPrize / amount;

    // 수익률을 소수점 둘째 자리까지 반올림하여 출력
    DecimalFormat df = new DecimalFormat("###,###.0");
    System.out.println("총 수익률은 " + df.format(rate * 100) + "%입니다.");
}
```

- **문제점**
    - printResult 메소드가 여러 가지 역할을 수행하고 있어, 코드의 가독성과 유지보수성이 떨어졌다.
    - 이 메소드 하나가 당첨 결과 출력과 수익률 계산 및 출력을 동시에 처리하고 있어, 단일 책임 원칙(SRP)을 위반하고 있었다.
    - 수익률을 소수점 첫째 자리까지 표시하는 부분에서, 수익률이 너무 높아지면 6.666666667E7% 같이 과학적 표기법으로 출력되는 문제가 있었다.

- **해결 방법**
    - printResult 메소드를 printWinningRanks와 printTotalProfitRate 메소드로 분리하여, 각각 당첨 결과 출력과 수익률 계산 및 출력을 담당하도록 했다.
    - 이를 통해 코드가 하나의 메소드에서 하나의 기능만 수행하도록 하여 가독성을 높이고 유지보수가 용이해졌다.
    - 수익률을 정확하게 소수점 첫째 자리까지 표시하기 위해 DecimalFormat 객체를 사용해 형식을 "###,###.0"으로 지정하여, 값이 항상 소수점 첫째 자리를 포함하도록 수정했다.

<br />