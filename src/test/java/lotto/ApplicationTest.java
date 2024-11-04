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
    @DisplayName("기능 테스트")
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
    @DisplayName("예외 테스트")
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("로또 구매 금액 예외 테스트")
    void 금액_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains("[ERROR] 숫자만 입력 가능합니다.");
        });

        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains("[ERROR] 구입금액은 0보다 커야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 예외 테스트")
    void 당첨_번호_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,a");
            assertThat(output()).contains("[ERROR] 숫자만 입력 가능합니다.");
        });

        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains("[ERROR] 로또 번호는 6개여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        });

        assertSimpleTest(() -> {
            runException("1000", "0,1,2,3,4,5");
            assertThat(output()).contains("[ERROR] 로또 번호는 1에서 45사이의 숫자여야 합니다.");
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 예외 테스트")
    void 보너스_번호_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains("[ERROR] 숫자만 입력 가능합니다.");
        });

        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        });

        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        });
    }

    @Test
    @DisplayName("모든 번호가 일치하는 경우 테스트")
    void 일등_당첨_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("당첨 번호가 없는 경우 테스트")
    void 미당첨_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(40, 41, 42, 43, 44, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
