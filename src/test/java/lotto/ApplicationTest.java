package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void testLottoPurchaseAndProfitCalculation() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 8, 9, 10]",
                            "[2, 3, 4, 8, 9, 10]",
                            "[3, 4, 5, 6, 8, 9]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[14, 15, 16, 17, 18, 19]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 601200.0%입니다."
                    );
                },
                List.of(1, 2, 3, 8, 9, 10),  // 3개 일치 - 5등
                List.of(2, 3, 4, 8, 9, 10),  // 3개 일치 - 5등
                List.of(3, 4, 5, 6, 8, 9),   // 4개 일치 - 4등
                List.of(1, 2, 3, 4, 5, 7),   // 5개 일치, 보너스 번호 일치 - 2등
                List.of(14, 15, 16, 17, 18, 19)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-100", "-1000", "100"})
    void testInsufficientPurchaseAmountThrowsException(String amountInput) {
        assertSimpleTest(() -> {
            runException(amountInput);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,46",
            "0,1,2,3,4,5",
            "1,2,-1,3,4,5",
            "1,2,3,4,5",
            "100,1,2,3,4,5,6",
            "a,1,2,3,4,5",
            "a,b,c,d,e,f"
    })
    void testInvalidWinningLottoNumbersInputThenThrowsException(String winningLottoNumbers) {
        assertSimpleTest(() -> {
            runException("1000", winningLottoNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "100", "a", "x", "해광"})
    void testInvalidBonusNumberInputThenThrowsException(String bonusNumber) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", bonusNumber);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
