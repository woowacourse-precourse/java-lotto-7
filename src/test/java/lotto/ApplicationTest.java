package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 당첨 결과 테스트")
    @ParameterizedTest(name = "구입한 로또 번호: {3}, 수익률: {9}")
    @CsvSource(value = {
            "1000 : 1,2,3,4,5,6 : 7 : 1, 2, 3, 8, 9, 10 : 1 : 0 : 0 : 0 : 0 : 500.0",
            "1000 : 1,2,3,4,5,6 : 7 : 1, 2, 3, 4, 8, 9 : 0 : 1 : 0 : 0 : 0 : 5000.0",
            "1000 : 1,2,3,4,5,6 : 7 : 1, 2, 3, 4, 5, 8 : 0 : 0 : 1 : 0 : 0 : 150000.0",
            "1000 : 1,2,3,4,5,6 : 7 : 1, 2, 3, 4, 5, 7 : 0 : 0 : 0 : 1 : 0 : 3000000.0",
            "1000 : 1,2,3,4,5,6 : 7 : 1, 2, 3, 4, 5, 6 : 0 : 0 : 0 : 0 : 1 : 200000000.0"
    }, delimiter = ':')
    void testLottoResults(String purchaseAmount, String winningNumbers, String bonusNumber,
                          String chosenNumbers, int threeMatches, int fourMatches,
                          int fiveMatches, int fiveWithBonusMatches, int sixMatches,
                          String totalYield) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(purchaseAmount, winningNumbers, bonusNumber);
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[" + chosenNumbers + "]",
                            "3개 일치 (5,000원) - " + threeMatches + "개",
                            "4개 일치 (50,000원) - " + fourMatches + "개",
                            "5개 일치 (1,500,000원) - " + fiveMatches + "개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveWithBonusMatches + "개",
                            "6개 일치 (2,000,000,000원) - " + sixMatches + "개",
                            "총 수익률은 " + totalYield + "%입니다."
                    );
                },
                Arrays.stream(chosenNumbers.split(", "))
                        .map(Integer::parseInt)
                        .toList()
        );
    }

    @DisplayName("하나도 당첨되지 않은 경우 테스트")
    @Test
    void WhenNoMatch() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 9, 10, 11, 12, 13]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(8, 9, 10, 11, 12, 13)
        );
    }

    @DisplayName("잘못된 구입금액 입력으로 재입력 시도 및 6개 일치 테스트")
    @Test
    void WhenReTryAndAllMatch() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    runException("999");
                    assertThat(output()).contains(ERROR_MESSAGE);
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("여러 번 재입력 테스트")
    @Test
    void WhenAllReTry() {
        assertSimpleTest(() -> run(
                        "999",
                        "1001",
                        "abc",
                        "1000",

                        "1,2,3,4,5,a",
                        "1,2,3,4,5",
                        "1,2,3,4,5,6,7",
                        "1,2,3,4,5,46",
                        "1,2,3,4,5,5",
                        "1,2,3,4,5,6",

                        "a",
                        "0",
                        "6",
                        "7"
                )
        );
    }

    @DisplayName("구입금액이 잘못된 경우 예외가 발생한다.")
    @ParameterizedTest(name = "구입금액 입력값: {0}")
    @CsvSource({"999", "1001", "a", "가", "\\n", "\\t"})
    void shouldThrowExceptionPurchaseAmountIsValid(String purchaseAmount) {
        assertSimpleTest(() -> {
            runException(purchaseAmount);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입금액이 입력되지 않은 경우 예외가 발생한다.")
    @Test
    void shouldThrowExceptionPurchaseAmountIsValid() {
        assertSimpleTest(() -> {
            runException("\n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
