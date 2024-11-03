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
                            "총 수익률은 0.63%입니다."
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

    @DisplayName("로또 구매 가격이 음수이면 예외 발생")
    @Test
    void exception1() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구매 가격이 빈 값이면 예외 발생")
    @Test
    void exception2() {
        assertSimpleTest(() -> {
            runException("\n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구매 가격이 공백이면 예외 발생")
    @Test
    void exception3() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구매 가격이 1000단위가 아니면 예외 발생")
    @Test
    void exception4() {
        assertSimpleTest(() -> {
            runException("300");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구매 가격이 숫자가 아니면 예외 발생")
    @Test
    void exception5() {
        assertSimpleTest(() -> {
            runException("somin");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    // ===========================================================

    @DisplayName("당첨 번호가 중복되면 예외 발생")
    @Test
    void exception6() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외 발생")
    @Test
    void exception7() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 빈 값이면 예외 발생")
    @Test
    void exception8() {
        assertSimpleTest(() -> {
            runException("8000", "\n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 공백이면 예외 발생")
    @Test
    void exception10() {
        assertSimpleTest(() -> {
            runException("8000", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외 발생")
    @Test
    void exception9() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,d,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 음수이면 예외 발생")
    @Test
    void exception11() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,-2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니면 예외 발생")
    @Test
    void exception12() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니면 예외 발생")
    @Test
    void exception13() {
        assertSimpleTest(() -> {
            runException("8000", "0,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
