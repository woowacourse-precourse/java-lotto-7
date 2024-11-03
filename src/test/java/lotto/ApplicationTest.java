package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("로또 구입 금액으로 숫자가 아닌 다른 문자를 입력받는다면 예외가 발생한다.")
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("1,000원으로 나누어 떨어지지 않는 로또 구입 금액을 입력받는다면 예외가 발생한다.")
    void existChangeTest() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("음수의 로또 구입 금액을 입력받는다면 예외가 발생한다.")
    void negativePurchaseAmountTest() {
        assertSimpleTest(() -> {
            runException("-2000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호로 입력받은 수와 중복되는 수를 보너스 번호로 입력받았을 때 예외가 발생한다.")
    void duplicateBonusNumberTest() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("로또 구입 금액, 당첨 번호, 보너스 번호 입력시 오류가 발생하면 다시 구입 금액을 입력받아야 한다.")
    void reInputTest() {
        assertSimpleTest(() -> {
            runException("1500", "1000K", "-10000", "1000",
                    "1,2,3,4,5,6,7", "1,2K,3,4,5,6", "0,1,2,3,4,5", "1,2,3,4,5,5", "1,2,3,4,5,6",
                    "6", "41K", "0", "7");
            assertThat(output()).contains(
                    "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.",
                    "[ERROR] 올바른 형태의 숫자가 아닙니다.",
                    "[ERROR] 로또 구입 금액은 음수가 될 수 없습니다.",
                    "[ERROR] 로또 번호는 6개여야 합니다.",
                    "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
                    "[ERROR] 각각의 로또 번호는 중복되지 않아야 합니다.",
                    "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.",
                    "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.",
                    "당첨 통계"
            );
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
