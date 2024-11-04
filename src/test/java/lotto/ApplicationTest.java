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
    void 예외_테스트_구매금액이_숫자가_아닐_경우() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닐 경우 예외 메시지가 출력된다.")
    void 예외_테스트_구매금액이_1000원_단위가_아니면() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE, "구입 금액은 1,000원 단위여야 합니다.");
        });
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값이 포함되면 예외 메시지가 출력된다.")
    void 예외_테스트_당첨번호에_숫자가_아니면() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,X", "7");
            assertThat(output()).contains(ERROR_MESSAGE, "로또 번호는 숫자여야 합니다.");
        });
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외 메시지가 출력된다.")
    void 예외_테스트_보너스번호가_숫자가_아니면() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "X");
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호는 숫자여야 합니다.");
        });
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 메시지가 출력된다.")
    void 예외_테스트_보너스번호가_당첨번호와_중복되면() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        });
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어나면 예외 메시지가 출력된다.")
    void 예외_테스트_보너스번호가_범위를_벗어나면() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
