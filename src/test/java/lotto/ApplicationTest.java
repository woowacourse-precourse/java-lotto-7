package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.util.Errors;
import lotto.util.MessageParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    @Test
    void 기본_기능_테스트() {
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
    void 당첨_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "6,5,4,3,2,45", "1");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 45]",
                            "[2, 3, 4, 5, 6, 45]",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 68666666.7%입니다."
                    );
                },
                List.of(45, 5, 4, 3, 2, 1),
                List.of(6, 5, 45, 4, 3, 2),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "'', '1,2,3,4,5,6', '7'",
            "'4000', '   ', '7'",
            "'4000', '1,2,3,4,5,6', '\n'"})
    void 빈_값_예외_테스트(String money, String lotto, String bonus) {
        assertSimpleTest(() -> {
            runException(money, lotto, bonus);
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.NULL_OR_EMPTY_INPUT.getMessage()));
        });
    }

    @ParameterizedTest
    @CsvSource({
            "'1000j', '1,2,3,4,5,6', '7'",
            "'-', '1,2,3,4,5,6', '7'",
            "'4000', '1,2,3,4,5,6.', '7'",
            "'4000', '1,a,3,4,5,6', '7'",
            "'4000', '1,2,3,4,5,6', '.'"})
    void 숫자가_아닌_예외_테스트(String money, String number, String bonus) {
        assertSimpleTest(() -> {
            runException(money, number, bonus);
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.NOT_A_WHOLE_NUMBER.getMessage()));
        });
    }

    @Test
    void 금액_데이터타입_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("99999999999999999999999999");
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.NOT_A_LONG.getMessage()));
        });
    }

    @Test
    void 로또_데이터타입_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,99999999999999999999999999,4,5,6");
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.NOT_INTEGER.getMessage()));
        });
    }

    @Test
    void 보너스_데이터타입_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "99999999999999999999999999");
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.NOT_INTEGER.getMessage()));
        });
    }

    @ParameterizedTest
    @CsvSource({
            "'1000', '1,2,3,46,5,6', '7'",
            "'1000', '1,2,3,4,5,6', '0'"})
    void 로또_보너스_범위_예외_테스트(String money, String number, String bonus) {
        assertSimpleTest(() -> {
            runException(money, number, bonus);
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.NOT_IN_LOTTO_RANGE.getMessage()));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000", "0", "-1000"})
    void 금액_범위_예외_테스트(String money) {
        assertSimpleTest(() -> {
            runException(money);
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.NOT_IN_MONEY_RANGE.getMessage()));
        });
    }

    @Test
    void 로또_콤마_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,", "7");
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.ENDING_WITH_COMMA.getMessage()));
        });
    }

    @Test
    void 로또_개수_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5", "7");
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.LOTTO_NUMBER_COUNT_ERROR.getMessage()));
        });
    }

    @Test
    void 금액_나머지값_예외_테스트() {
        assertSimpleTest(() -> {
            runException("4010");
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.REMAINDER_EXISTENT.getMessage()));
        });
    }

    @ParameterizedTest
    @CsvSource({
            "'1000', '1,2,43,43,5,6', '7'",
            "'1000', '1,2,3,4,5,6', '6'"})
    void 중복_번호_예외_테스트(String money, String number, String bonus) {
        assertSimpleTest(() -> {
            runException(money, number, bonus);
            assertThat(output()).contains(
                    MessageParser.getErrorMessage(Errors.DUPLICATE_NUMBERS.getMessage()));
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
