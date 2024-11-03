package lotto.custom;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.custom.common.ErrorMessages;
import lotto.custom.validator.CustomErrorMessages;
import org.junit.jupiter.api.Test;

class ApplicationCustomTest extends NsTest {

    // 구입 금액 입력 예외 처리

    @Test
    void 예외처리_구입금액입력_공백으로구성되어있을때_테스트() {
        assertSimpleTest(() -> {
            runException("   ");
            assertThat(output()).contains(ErrorMessages.WHITESPACE_ONLY_INPUT);
        });
    }

    @Test
    void 예외처리_구입금액입력_숫자와공백외의문자가있을때_테스트() {
        assertSimpleTest(() -> {
            runException("123#5");
            assertThat(output()).contains(ErrorMessages.INVALID_CHARACTERS_INPUT);
        });
    }

    @Test
    void 예외처리_구입금액입력_숫자와숫자사이에공백이있을때_테스트() {
        assertSimpleTest(() -> {
            runException("3000 0");
            assertThat(output()).contains(ErrorMessages.SPACES_BETWEEN_NUMBERS);
        });
    }

    @Test
    void 예외처리_구입금액입력_int타입의범위를벗어날때_테스트() {
        assertSimpleTest(() -> {
            runException("2147483648"); // Integer.MAX_VALUE + 1
            assertThat(output()).contains(ErrorMessages.INT_OUT_OF_BOUNDS);
        });
    }

    @Test
    void 예외처리_구입금액입력_1000으로나누어떨어지지않을때_테스트() {
        assertSimpleTest(() -> {
            runException("5400");
            assertThat(output()).contains(CustomErrorMessages.NOT_DIVISIBLE_BY_THOUSAND);
        });
    }

    // 당첨 번호 입력 예외 처리

    @Test
    void 예외처리_당첨번호입력_공백으로구성되어있을때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "       ");
            assertThat(output()).contains(ErrorMessages.WHITESPACE_ONLY_INPUT);
        });
    }

    @Test
    void 예외처리_당첨번호입력_쉼표공백숫자를제외한문자가존재할때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3*4,5,6");
            assertThat(output()).contains(ErrorMessages.INVALID_CHARACTERS_INPUT);
        });
    }

    @Test
    void 예외처리_당첨번호입력_숫자와숫자사이에공백이존재할때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4 5 6");
            assertThat(output()).contains(ErrorMessages.SPACES_BETWEEN_NUMBERS);
        });
    }

    @Test
    void 예외처리_당첨번호입력_숫자가6개가아닐때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4, 5");
            assertThat(output()).contains(CustomErrorMessages.LOTTO_NUMBER_COUNT);
        });
    }

    @Test
    void 예외처리_당첨번호입력_숫자가중복될때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4, 5, 5");
            assertThat(output()).contains(CustomErrorMessages.LOTTO_NUMBERS_MUST_BE_UNIQUE);
        });
    }

    @Test
    void 예외처리_당첨번호입력_숫자의범위가1에서45가아닐때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4, 5, 46");
            assertThat(output()).contains(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
        });
    }

    // 보너스 번호 입력 예외 처리

    @Test
    void 예외처리_보너스번호입력_공백으로만구성되어있을때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4, 5, 6", "     ");
            assertThat(output()).contains(ErrorMessages.WHITESPACE_ONLY_INPUT);
        });
    }

    @Test
    void 예외처리_보너스번호입력_숫자와공백을제외한문자가존재할때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4, 5, 6", "1,2");
            assertThat(output()).contains(ErrorMessages.INVALID_CHARACTERS_INPUT);
        });
    }

    @Test
    void 예외처리_보너스번호입력_숫자와숫자사이에공백이존재할때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4, 5, 6", "1 2");
            assertThat(output()).contains(ErrorMessages.SPACES_BETWEEN_NUMBERS);
        });
    }

    @Test
    void 예외처리_보너스번호입력_보너스번호와당첨번호가같을때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4, 5, 6", "6");
            assertThat(output()).contains(CustomErrorMessages.BONUS_NUMBER_DUPLICATE);
        });
    }

    @Test
    void 예외처리_보너스번호입력_숫자의범위가1에서45가아닐때_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1, 2, 3, 4, 5, 6", "47");
            assertThat(output()).contains(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
        });
    }

    // 기능 테스트
    @Test
    void 당첨번호_쉼표제거_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", ",1,,,2,3,,,4,5,6,,,", "7");
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
    void 당첨번호_공백제거_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "  1,  2, 3,   4,5,6 ", "7");
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
    void 보너스번호_공백제거_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", " 7  ");
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
