package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ExceptionMessage.BONUS_NUMBER_DUPLICATED;
import static lotto.constant.ExceptionMessage.BONUS_NUMBER_MUST_INTEGER;
import static lotto.constant.ExceptionMessage.EXCEPTION_PREFIX;
import static lotto.constant.ExceptionMessage.INPUT_EMPTY;
import static lotto.constant.ExceptionMessage.LOTTO_INVALID_SIZE;
import static lotto.constant.ExceptionMessage.LOTTO_NUMBER_DUPLICATED;
import static lotto.constant.ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE;
import static lotto.constant.ExceptionMessage.PURCHASE_AMOUNT_IS_POSITIVE;
import static lotto.constant.ExceptionMessage.PURCHASE_AMOUNT_MUST_LONG;
import static lotto.constant.ExceptionMessage.PURCHASE_AMOUNT_NOT_NEGATIVE;
import static lotto.constant.ExceptionMessage.WINNER_NUMBER_INPUT_INVALID_CHARACTER;
import static lotto.constant.ExceptionMessage.WINNER_NUMBER_INVALID_COMMA_POSITION;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 10]",
                            "[1, 2, 3, 4, 10, 11]",
                            "[1, 2, 3, 4, 7, 11]",
                            "[1, 2, 3, 10, 11, 12]",
                            "[1, 2, 3, 7, 10, 11]",
                            "[1, 2, 7, 10, 11, 12]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 2개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25395125.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6), // 1등 - 6개 일치, 보너스 x
                List.of(1, 2, 3, 4, 5, 7), // 2등 - 5개 일치, 보너스 o
                List.of(1, 2, 3, 4, 5, 10), // 3등 - 5개 일치, 보너스 x
                List.of(1, 2, 3, 4, 10, 11), // 4등 - 4개 일치, 보너스 x
                List.of(1, 2, 3, 4, 7, 11), // 4등 - 4개 일치, 보너스 o
                List.of(1, 2, 3, 10, 11, 12), // 5등 - 3개 일치, 보너스 x
                List.of(1, 2, 3, 7, 10, 11), // 5등 - 3개 일치, 보너스 o
                List.of(1, 2, 7, 10, 11, 12) // 등수 x - 2개 일치 이하
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void 빈_입력_예외(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(EXCEPTION_PREFIX + INPUT_EMPTY);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "8000, '1,2,3,4,5,46', 7",
            "8000, '1,2,3,4,5,6', 46"
    })
    void 로또_번호_범위_예외(String purchaseAmount, String winnerNumbers, String bonusNumber) {
        assertSimpleTest(() -> {

            runException(purchaseAmount, winnerNumbers, bonusNumber);
            assertThat(output()).contains(EXCEPTION_PREFIX + LOTTO_NUMBER_INVALID_RANGE);
        });
    }

    @Test
    void 당첨_번호_개수_예외() {
        assertSimpleTest(() -> {

            runException("8000", "1,2,3,4,5,6,7", "8");
            assertThat(output()).contains(EXCEPTION_PREFIX + LOTTO_INVALID_SIZE);
        });
    }

    @Test
    void 당첨_번호_중복_예외() {
        assertSimpleTest(() -> {

            runException("8000", "1,2,3,4,5,5", "7");
            assertThat(output()).contains(EXCEPTION_PREFIX + LOTTO_NUMBER_DUPLICATED);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "1000\t", "1000 ", "1000.0", "1000000000000000000000"})
    void 구입금액_파싱_예외(String purchaseAmount) {
        assertSimpleTest(() -> {

            runException(purchaseAmount, "1,2,3,4,5,6", "7");
            assertThat(output()).contains(EXCEPTION_PREFIX + PURCHASE_AMOUNT_MUST_LONG);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "500", "555", "100000050", "1959"})
    void 구입금액_단위_예외(String purchaseAmount) {
        assertSimpleTest(() -> {

            runException(purchaseAmount, "1,2,3,4,5,6", "7");
            assertThat(output()).contains(EXCEPTION_PREFIX + PURCHASE_AMOUNT_MUST_LONG);
        });
    }

    @Test
    void 구입금액_음수_예외() {
        assertSimpleTest(() -> {

            runException("-1000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(EXCEPTION_PREFIX + PURCHASE_AMOUNT_NOT_NEGATIVE);
        });
    }

    @Test
    void 구입금액_0_예외() {
        assertSimpleTest(() -> {

            runException("0", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(EXCEPTION_PREFIX + PURCHASE_AMOUNT_IS_POSITIVE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,#,2,3,4,5", "1.0,2,3,4,5,6", "1\t,2,3,4,5,6"})
    void 당첨_숫자_문자_예외(String winnerNumbers) {
        assertSimpleTest(() -> {

            runException("8000", winnerNumbers, "7");
            assertThat(output()).contains(EXCEPTION_PREFIX + WINNER_NUMBER_INPUT_INVALID_CHARACTER);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5", "1,,2,3,4,5", "1,,2,3,4,5,6", "1,,,,,6"})
    void 당첨_숫자_콤마_예외(String winnerNumbers) {
        assertSimpleTest(() -> {

            runException("8000", winnerNumbers, "7");
            assertThat(output()).contains(EXCEPTION_PREFIX + WINNER_NUMBER_INVALID_COMMA_POSITION);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"7j", "7.0", "7\t"})
    void 보너스_번호_타입_예외(String bonusNumber) {
        assertSimpleTest(() -> {

            runException("8000", "1,2,3,4,5,6", bonusNumber);
            assertThat(output()).contains(EXCEPTION_PREFIX + BONUS_NUMBER_MUST_INTEGER);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 보너스_번호_중복_예외(String bonusNumber) {
        assertSimpleTest(() -> {

            runException("8000", "1,2,3,4,5,6", bonusNumber);
            assertThat(output()).contains(EXCEPTION_PREFIX + BONUS_NUMBER_DUPLICATED);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
