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
    @DisplayName("돈 입력 예외처리")
    void moneyError() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE, " 구입 금액은 1,000원 단위여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ERROR_MESSAGE, " 구입 금액은 1,000원 단위여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE, " 구입 금액은 1,000원 단위여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE, " 구입 금액은 1,000원 단위여야 합니다.");
        });
    }

    @Test
    @DisplayName("당첨 번호 예외처리")
    void numberError() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE, " 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("3000", "a");
            assertThat(output()).contains(ERROR_MESSAGE, " 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,50,6");
            assertThat(output()).contains(ERROR_MESSAGE, " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    @DisplayName("보너스 번호 예외처리")
    void bonusNumberError() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "-1");
            assertThat(output()).contains(ERROR_MESSAGE, " 보너스 번호는 정수여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "50");
            assertThat(output()).contains(ERROR_MESSAGE, " 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ERROR_MESSAGE, " 보너스 번호는 정수여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "!");
            assertThat(output()).contains(ERROR_MESSAGE, " 보너스 번호는 정수여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "1a");
            assertThat(output()).contains(ERROR_MESSAGE, " 보너스 번호는 정수여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("6000", "1,2,3,4,5,6", "1, 2");
            assertThat(output()).contains(ERROR_MESSAGE, " 보너스 번호는 숫자 1개만 입력해야 합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
