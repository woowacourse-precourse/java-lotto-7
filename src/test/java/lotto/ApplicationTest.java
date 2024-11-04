package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.ErrorConstants.ERROR_BONUS_NUMBER_DUPLICATE;
import static lotto.ErrorConstants.ERROR_DIVISIBLE_BY_LOTTO_PRICE;
import static lotto.ErrorConstants.ERROR_DUPLICATE_NUMBERS_NOT_ALLOWED;
import static lotto.ErrorConstants.ERROR_MINIMUM_LOTTO_PURCHASE;
import static lotto.ErrorConstants.ERROR_NUMBER_RANGE;
import static lotto.ErrorConstants.ERROR_ONLY_NUMBERS_ALLOWED;
import static lotto.ErrorConstants.ERROR_ONLY_NUMBER_ALLOWED;
import static lotto.ErrorConstants.ERROR_WINNING_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void test() {
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
    @DisplayName("예외: 구입 금액 입력이 숫자가 아닌 경우 예외")
    void errorCase1() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_ONLY_NUMBER_ALLOWED);
        });
    }

    @Test
    @DisplayName("예외: 구입 금액이 1,000원으로 나누어 떨어지지 않은 경우 예외")
    void errorCase2() {
        assertSimpleTest(() -> {
            runException("1999");
            assertThat(output()).contains(ERROR_DIVISIBLE_BY_LOTTO_PRICE);
        });
    }

    @Test
    @DisplayName("예외: 구입 금액이 1,000원 이하라면 예외")
    void errorCase3() {
        assertSimpleTest(() -> {
            runException("999");
            assertThat(output()).contains(ERROR_MINIMUM_LOTTO_PURCHASE);
        });
    }

    @Test
    @DisplayName("예외: 당첨 번호 입력이 숫자가 아니라면 예외")
    void errorCase4() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,j");
            assertThat(output()).contains(ERROR_ONLY_NUMBERS_ALLOWED);
        });
    }

    @Test
    @DisplayName("예외: 당첨 번호 입력이 1-45 사이 숫자가 아니라면 예외")
    void errorCase5() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,90");
            assertThat(output()).contains(ERROR_NUMBER_RANGE);
        });
    }

    @Test
    @DisplayName("예외: 입력된 당첨 번호 숫자가 6개가 아니라면 예외")
    void errorCase6() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4");
            assertThat(output()).contains(ERROR_WINNING_NUMBERS_SIZE);
        });
    }

    @Test
    @DisplayName("예외: 로또 번호에 중복된 숫자가 있다면 예외")
    void errorCase7() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_DUPLICATE_NUMBERS_NOT_ALLOWED);
        });
    }

    @Test
    @DisplayName("예외: 보너스 번호 입력이 숫자가 아니라면 예외")
    void errorCase8() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "j");
            assertThat(output()).contains(ERROR_ONLY_NUMBERS_ALLOWED);
        });
    }

    @Test
    @DisplayName("예외: 보너스 번호 입력이 1-45 사이 숫자가 아니라면 예외")
    void errorCase9() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "99");
            assertThat(output()).contains(ERROR_NUMBER_RANGE);
        });
    }

    @Test
    @DisplayName("예외: 보너스 번호 입력이 입력이 당첨 번호와 겹친다면 예외")
    void errorCase10() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "4");
            assertThat(output()).contains(ERROR_BONUS_NUMBER_DUPLICATE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
