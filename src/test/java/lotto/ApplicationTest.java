package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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

    @DisplayName("3자리씩 끊어서 수익률을 출력한다.")
    @Test
    void printFormatCorrectly() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("7000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "7개를 구매했습니다.",
                            "[1, 2, 8, 9, 10, 11]",
                            "[1, 2, 8, 9, 10, 12]",
                            "[1, 2, 8, 9, 10, 13]",
                            "[1, 2, 8, 9, 10, 14]",
                            "[1, 2, 8, 9, 10, 15]",
                            "[1, 2, 8, 9, 10, 16]",
                            "[1, 2, 3, 4, 5, 7]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 428,571.4%입니다."
                    );
                },
                List.of(1, 2, 8, 9, 10, 11),
                List.of(1, 2, 8, 9, 10, 12),
                List.of(1, 2, 8, 9, 10, 13),
                List.of(1, 2, 8, 9, 10, 14),
                List.of(1, 2, 8, 9, 10, 15),
                List.of(1, 2, 8, 9, 10, 16),
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @DisplayName("소수 둘째자리에서 반올림하여 수익률을 출력한다.")
    @Test
    void CalculateDecimalCorrectly() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("7000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "7개를 구매했습니다.",
                            "[1, 2, 8, 9, 10, 11]",
                            "[1, 2, 8, 9, 10, 12]",
                            "[1, 2, 8, 9, 10, 13]",
                            "[1, 2, 8, 9, 10, 14]",
                            "[1, 2, 8, 9, 10, 15]",
                            "[1, 2, 8, 9, 10, 16]",
                            "[1, 2, 3, 4, 10, 17]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 714.3%입니다."
                    );
                },
                List.of(1, 2, 8, 9, 10, 11),
                List.of(1, 2, 8, 9, 10, 12),
                List.of(1, 2, 8, 9, 10, 13),
                List.of(1, 2, 8, 9, 10, 14),
                List.of(1, 2, 8, 9, 10, 15),
                List.of(1, 2, 8, 9, 10, 16),
                List.of(1, 2, 3, 4, 10, 17)
        );
    }

    @DisplayName("숫자가 아닌 구매금액을 입력했을 때 예외가 발생한다")
    @NullSource
    @ParameterizedTest
    @ValueSource(strings = {"1000j"})
    void throwWhenInvalidPurchaseAmount(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자가 아닌 로또 번호를 입력했을 때 예외가 발생한다")
    @NullSource
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a"})
    void throwWhenInvalidLottoNumber(String input) {
        assertSimpleTest(() -> {
            runException("1000", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자가 아닌 보너스 번호를 입력했을 때 예외가 발생한다")
    @NullSource
    @ParameterizedTest
    @ValueSource(strings = {"a"})
    void throwWhenInvalidBonusNumber(String input) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
