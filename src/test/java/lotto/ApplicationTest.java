package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.exception.message.InputExceptionMessage;
import lotto.exception.message.LottoExceptionMessage;
import lotto.exception.message.LottoMoneyExceptionMessage;
import lotto.exception.message.LottoNumberExceptionMessage;
import lotto.exception.message.WinningNumberExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("숫자가 아닌 금액 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test1() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000j", "1000", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(InputExceptionMessage.INVALID_PURCHASE_AMOUNT.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("적은 금액 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test2() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("900", "1000", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(LottoMoneyExceptionMessage.INVALID_MONEY_AMOUNT.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("1000원 단위가 아닌 금액 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test3() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1100", "1000", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(LottoMoneyExceptionMessage.INVALID_MONEY_UNIT.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("최대 금액을 초과한 금액 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test4() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("2147483648000", "1000", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(LottoMoneyExceptionMessage.INVALID_MAX_MONEY.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("숫자가 아닌 당첨번호 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test5() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1,2,3,4,5,a", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(InputExceptionMessage.INVALID_WINNING_NUMBERS.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 숫자 범위가 아닌 당첨번호 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test6() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1,2,3,4,5,0", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(LottoNumberExceptionMessage.INVALID_NUMBER_RANGE.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("숫자가 아닌 보너스 번호 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test7() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1,2,3,4,5,6", "a", "7");
            assertThat(output())
                    .contains(commonMessage(InputExceptionMessage.INVALID_BONUS_NUMBER.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("숫자가 아닌 보너스 번호 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test8() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1,2,3,4,5,6", "6", "7");
            assertThat(output())
                    .contains(commonMessage(WinningNumberExceptionMessage.DUPLICATE_BONUS_NUMBER.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호의 범위를 벗어나는 보너스 번호 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test9() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1,2,3,4,5,6", "46", "7");
            assertThat(output())
                    .contains(commonMessage(LottoNumberExceptionMessage.INVALID_NUMBER_RANGE.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("중복되는 당첨 번호 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test10() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1,2,3,4,6,6", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(LottoExceptionMessage.INVALID_NUMBER_COUNT.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("6개를 초과하는 당첨 번호 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test11() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1,2,3,4,5,6,7", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(LottoExceptionMessage.INVALID_NUMBER_COUNT.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("6개 미만의 당첨 번호 입력시, 예외가 발생하고 재입력시 성공적으로 수행된다.")
    void end_to_end_test12() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1,2,3,4,5", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains(commonMessage(LottoExceptionMessage.INVALID_NUMBER_COUNT.getMessage()));
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨 번호 구분자 사이에 공백이 포함되어도 성공적으로 수행된다.")
    void end_to_end_test13() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("1000", "1 , 2 , 3 , 4 , 5 , 6", "7");
            assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "총 수익률은 200000000.0%입니다."
            );
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    String[] commonMessage(String message) {
        return new String[] {
                ERROR_MESSAGE,
                "1개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "총 수익률은 200000000.0%입니다.",
                message
        };
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
